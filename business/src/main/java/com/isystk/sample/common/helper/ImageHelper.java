package com.isystk.sample.common.helper;

import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.google.common.collect.Lists;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import com.isystk.sample.common.util.AwsS3Utils;
import java.util.List;
import java.util.stream.Collectors;
import javax.imageio.ImageIO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import lombok.extern.slf4j.Slf4j;

/**
 * 画像ヘルパー
 */
@Component("img")
@Slf4j
public class ImageHelper {

  public static String BUCKET_NAME;

  @Value("${application.imageUploadLocation:#{systemProperties['java.io.tmpdir']}}") // 設定ファイルに定義されたアップロード先を取得する
  String imageUploadLocation;

  /**
   * ファイルを保存します。
   *
   * @param imageData 画像データ
   * @param dirPath ディレクトリパス
   * @param upFileName 画像ファイル名
   */
  public void saveFileData(String imageData, String dirPath , String upFileName, boolean delete) {
    Assert.notNull(imageData, "imageData can't be null");

    try {
      // 画像ファイルをデコード
      byte[] decodedBytes = Base64.getDecoder().decode(imageData.substring(imageData.indexOf(',') + 1));

      String imageFilePath = imageUploadLocation + System.getProperty("file.separator")
          + upFileName;
      org.apache.commons.io.FileUtils.writeByteArrayToFile(new File(imageFilePath), decodedBytes);

      saveFile(imageFilePath, dirPath, upFileName, delete);
    } catch (IOException e) {
      throw new IllegalStateException("failed to save file. " + upFileName, e);
    }
  }

  /**
   * ファイルを保存します。
   *
   * @param imageFilePath 画像データ
   * @param dirPath ディレクトリパス
   * @param upFileName 画像ファイル名
   */
  public void saveFile(String imageFilePath, String dirPath , String upFileName, boolean delete) {
    Assert.notNull(imageFilePath, "imageFile can't be null");
    String remotePath = dirPath + "/" + upFileName;
    // S3に保存
    AwsS3Utils.s3PutObject(imageFilePath, remotePath, BUCKET_NAME, delete);
  }

  /**
   * ファイルを削除します。
   *
   * @param dirPath ディレクトリパス
   * @param upFileName 画像ファイル名
   */
  public void removeFile(String dirPath , String upFileName) {
    String remotePath = dirPath + "/" + upFileName;
    // S3から削除
    AwsS3Utils.s3DeleteObject(BUCKET_NAME, remotePath);
  }

  public List<String> getImageList(String dirPath) {
    String remotePath = dirPath;

    try {
      // S3を探索
      List<S3ObjectSummary> list = AwsS3Utils.s3GetListsObject(BUCKET_NAME, remotePath);

      return list.stream().map((e) -> e.getKey()).collect(Collectors.toList());

    } catch (AmazonS3Exception e) {
      throw new RuntimeException(e);
    }
  }

  public String getImageData(String dirPath , String upFileName) {
    String remotePath = dirPath + "/" + upFileName;

    try {
      // S3から画像を取得
      S3Object s3Object = AwsS3Utils.s3GetObject(BUCKET_NAME, remotePath);

      // Base64のデータで読み込む
      if (s3Object != null) {
        BufferedImage imgBuf;
        imgBuf = ImageIO.read(s3Object.getObjectContent());
        return encodeBase64URL(imgBuf);
      }

    } catch (IOException | AmazonS3Exception e) {
      throw new RuntimeException(e);
    }
    return null;
  }
  public String getImageUrl(String dirPath , String upFileName) {
    String remotePath = dirPath + "/" + upFileName;
    return "/thumb" + remotePath;
  }

  public String encodeBase64URL(BufferedImage imgBuf) {
    String base64;
    if (imgBuf == null) {
      base64 = null;
    } else {
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      try {
        ImageIO.write(imgBuf, "png", out);
      } catch (IOException e) {
        base64 = null;
      }
      byte[] bytes = out.toByteArray();
      base64 = "data:image/png;base64," + Base64.getEncoder().encodeToString(bytes);
    }
    return base64;
  }

  /**
   * JSPからアクセス用
   */
  public String url(String dirPath, String imageFileName) {
    return getImageUrl(dirPath, imageFileName);
  }
  public String data(String dirPath, String imageFileName) {
    return getImageData(dirPath, imageFileName);
  }

  @Value("${aws.s3.bucket-name}")
  public void setBucketName(String bucketName) {
    BUCKET_NAME = bucketName;
  }
}
