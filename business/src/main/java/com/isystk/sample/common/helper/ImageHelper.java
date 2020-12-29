package com.isystk.sample.common.helper;

import static com.isystk.sample.common.Const.*;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.Formatter;
import java.util.stream.Stream;

import javax.imageio.ImageIO;

import com.isystk.sample.common.util.AwsS3Utils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import com.isystk.sample.common.dto.UploadFileDto;
import com.isystk.sample.common.exception.FileNotFoundException;
import com.isystk.sample.common.exception.SystemException;
import com.isystk.sample.common.util.DateUtils;
import com.isystk.sample.common.util.FileUtils;
import com.isystk.sample.common.values.ImageSuffix;
import com.isystk.sample.domain.dao.TImageDao;
import com.isystk.sample.domain.entity.TImage;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.filters.Canvas;
import net.coobird.thumbnailator.geometry.Positions;

/**
 * 画像ヘルパー
 */
@Component("img")
@Slf4j
public class ImageHelper {

  @Value("${application.imageUploadLocation:#{systemProperties['java.io.tmpdir']}}") // 設定ファイルに定義されたアップロード先を取得する
  String imageUploadLocation;

  @Autowired
  TImageDao tImageDao;

  /**
   * ファイルの一覧を取得します。
   *
   * @param location
   * @return
   */
  public Stream<Path> listAllFiles(Path location) {
    try {
      return Files.walk(location, 1).filter(path -> !path.equals(location))
          .map(location::relativize);
    } catch (IOException e) {
      throw new IllegalArgumentException("failed to list uploadfiles. ", e);
    }
  }

  /**
   * ファイルを読み込みます。
   *
   * @param imageId
   * @return
   */
  public Resource loadFile(Integer imageId) {
    // ディレクトリ
    String dir = getHash(imageId);
    Path location = Paths.get(imageUploadLocation, dir);
    try {

      // 保存するファイル名
      String saveFileName = imageId + "." + IMAGE_EXTENSION;

      Path file = location.resolve(dir).resolve(saveFileName);
      Resource resource = new UrlResource(file.toUri());

      if (resource.exists() || resource.isReadable()) {
        return resource;
      }

      throw new FileNotFoundException("could not read file. " + imageId);

    } catch (MalformedURLException e) {
      throw new IllegalArgumentException(
          "malformed Url resource. [location=" + location.toString() + ", imageId=" + imageId + "]",
          e);
    }
  }

  /**
   * ID生成
   *
   * @return 生成されたID
   */
  private Integer generateID(int maxLength) {
    Integer id = 0;
    boolean loopFlg = true;

    do {
      id = Integer.valueOf(RandomStringUtils.randomNumeric(maxLength));

      // 生成したIDが存在しない場合、そのIDを返却する
      TImage tImage = tImageDao.selectById(id).orElse(null);

      if (tImage == null) {
        loopFlg = false;
      }
    } while (loopFlg);

    return id;
  }

  /**
   * 画像IDからパスを表すハッシュを取得する。
   *
   * @param imgId 画像ID
   * @return ハッシュ
   */
  private String getHash(Integer imgId) {
    int h;
    try {
      MessageDigest md = MessageDigest.getInstance("MD5");
      byte[] d = md.digest(new DecimalFormat("00000000").format(imgId).getBytes());
      h = d[0];
      h += d[1] << 8;
    } catch (NoSuchAlgorithmException e) {
      throw new SystemException(e);
    }
    Formatter f = new Formatter();
    f.format("%02x/%02x/", (h & 0xff), ((h >> 8) & 0xff));
    return f.toString();
  }

  /**
   * ファイルを保存します。
   *
   * @param file 保存先ディレクトリ
   */
  public UploadFileDto saveFile(MultipartFile file) {
    Assert.notNull(file, "file can't be null");
    String upFileName = file.getOriginalFilename();

    try {
      if (file.isEmpty()) {
        throw new IllegalArgumentException("cloud not save empty file. " + upFileName);
      }

      // 画像の拡張子
      String extension = upFileName.substring(upFileName.lastIndexOf(".") + 1);

      // 画像ID
      var id = generateID(Integer.valueOf(9));

      // ディレクトリ
      String dir = getHash(id);
      Path dirPath = Paths.get(imageUploadLocation, dir);

      // ディレクトリがない場合は作成する
      FileUtils.createDirectories(dirPath);

      Path filePath = dirPath.resolve(id + "." + extension);

      // インプットストリームをファイルに書き出す
      Files.copy(file.getInputStream(), filePath);

      File source = new File(dirPath.toUri().getPath(), String.valueOf(id) + "." + IMAGE_EXTENSION);
      source.deleteOnExit();
      if (!IMAGE_EXTENSION.equalsIgnoreCase(extension)) {
        // JPG 以外の場合は変換する
        BufferedImage image = ImageIO.read(filePath.toFile());
        BufferedImage tmp = new BufferedImage(image.getWidth(), image.getHeight(),
            BufferedImage.TYPE_INT_RGB);
        Graphics2D off = tmp.createGraphics();
        off.drawImage(image, 0, 0, Color.WHITE, null);
        ImageIO.write(tmp, IMAGE_EXTENSION, source);
      }

      // 画像のアスペクト比を変換
      for (ImageSuffix suffix : ImageSuffix.values()) {
        File dist = new File(dirPath.toUri().getPath(),
            String.valueOf(id) + suffix.getSuffix() + "." + IMAGE_EXTENSION);
        dist.deleteOnExit();
        convert(source, dist, suffix.getWidth(), suffix.getHeight());
        // S3アップロード
        AwsS3Utils.putObject(dir + dist.toPath().getFileName().toString(), dist.length(),
            file.getContentType(), new FileInputStream(dist));
      }

      TImage tImage = new TImage();
      tImage.setImageId(id);
      tImage.setRegistTime(DateUtils.getNow());
      tImage.setUpdateTime(DateUtils.getNow());
      tImage.setDeleteFlg(false);
      tImageDao.insert(tImage);

      UploadFileDto dto = new UploadFileDto();
      dto.setImageId(id);
      dto.setImageUrlSquare(getUrl(id, ImageSuffix.SQUARE.getSuffix()));
      dto.setImageUrlSd(getUrl(id, ImageSuffix.SD.getSuffix()));
      return dto;

    } catch (IOException e) {
      throw new IllegalStateException("failed to save file. " + upFileName, e);
    }
  }

  /**
   * 画像をトリミングします。
   *
   * @param source
   * @param dist
   * @param width
   * @param height
   * @throws IOException
   */
  private void convert(File source, File dist, int width, int height) throws IOException {

    BufferedImage bimage = ImageIO.read(source);

    // 縦長と横長の場合とでリサイズ
    if (bimage.getHeight() > bimage.getWidth()) {
      // 縦長画像
      log.info("縦長画像のため中心をトリミングします");
      if (width == height) {
        // 1:1画像の場合はそのまま中央をトリミング
        Thumbnails.of(bimage).crop(Positions.CENTER).size(width, height).keepAspectRatio(true)
            .outputQuality(0.9f).toFile(dist);
      } else {
        // 1:1画像でない場合は中央をトリミング後、左右に白背景を設定
        Thumbnails.of(bimage).crop(Positions.CENTER).size(width, width).keepAspectRatio(true)
            .outputQuality(0.9f).toFile(dist);
        BufferedImage wkimage = ImageIO.read(dist);
        Thumbnails.of(wkimage).height(height)
            .addFilter(new Canvas(width, height, Positions.CENTER, Color.white))
            .keepAspectRatio(true)
            .outputQuality(0.95f).toFile(dist);
      }
    } else {
      // 横長画像
      log.info("横長画像のため中心をトリミングします");
      Thumbnails.of(bimage).crop(Positions.CENTER).size(width, height).keepAspectRatio(true)
          .outputQuality(0.9f)
          .toFile(dist);
    }

    log.info("width:" + width + " height:" + height + " path:" + dist);
  }

  /**
   * 画像IDを元に表示用のパスを取得します。
   *
   * @param imageId
   * @return
   */
  public String getUrl(Integer imageId, String suffix) {
    String dir = getHash(imageId);
    String saveFileName = imageId + suffix + "." + IMAGE_EXTENSION;
    return "/thumb/" + dir + saveFileName;
//		return AwsS3Utils.ENDPOINT_URL + AwsS3Utils.BUCKET_NAME + "/" + dir + saveFileName;
  }

  /**
   * JSPからアクセス用
   */
  public String url(Integer imageId, String suffix) {
    return getUrl(imageId, suffix);
  }
}
