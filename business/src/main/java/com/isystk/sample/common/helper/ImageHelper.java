package com.isystk.sample.common.helper;

import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
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
   * @param upFileName 画像ファイル名
   */
  public void saveFile(String imageData, String upFileName) {
    Assert.notNull(imageData, "imageData can't be null");

    try {
      // 画像ファイルをデコード
      byte[] decodedBytes = Base64.getDecoder().decode(imageData.substring(imageData.indexOf(',') + 1));

      String imageFilePath = imageUploadLocation + System.getProperty("file.separator")
          + upFileName;
      org.apache.commons.io.FileUtils.writeByteArrayToFile(new File(imageFilePath), decodedBytes);
      String remotePath = "/stocks" + "/" + upFileName;

      // S3に保存
      AwsS3Utils.s3PutObject(imageFilePath, remotePath, BUCKET_NAME, true);
    } catch (IOException e) {
      throw new IllegalStateException("failed to save file. " + upFileName, e);
    }
  }

  public String getImageData(String upFileName) {
    String remotePath = "/stocks" + "/" + upFileName;

    try {
      // S3から画像を取得
      S3Object s3Object = AwsS3Utils.s3GetObject(BUCKET_NAME, remotePath);

      if (s3Object != null) {
        // Base64のデータで読み込む
        BufferedImage imgBuf;
        imgBuf = ImageIO.read(s3Object.getObjectContent());
        return encodeBase64URL(imgBuf);
//				try (S3ObjectInputStream is = s3Object.getObjectContent()) {
//					StringWriter writer = new StringWriter();
//					IOUtils.copy(is, writer, StandardCharsets.UTF_8);
//					return writer.toString();
//				}
      }
    } catch (IOException | AmazonS3Exception e) {
    }
    return null;
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
  public String url(String imageFileName) {
    return getImageData(imageFileName);
  }

  @Value("${aws.s3.bucket-name}")
  public void setBucketName(String bucketName) {
    BUCKET_NAME = bucketName;
  }
}
