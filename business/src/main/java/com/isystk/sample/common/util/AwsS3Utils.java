package com.isystk.sample.common.util;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import com.isystk.sample.common.exception.SystemException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Configuration
@Slf4j
public class AwsS3Utils {

  public static String ENDPOINT_URL;
  public static String REGION;
  public static String BUCKET_NAME;
  private static String PROFILE_NAME;

  //--------------------------------------------------
  // アップロード
  //--------------------------------------------------
  public static void putObject(String objectKey, long objectSize, String contentType,
      File source) throws FileNotFoundException {

    // クライアント生成
    AmazonS3 client = getClient(BUCKET_NAME);

    ObjectMetadata metadata = new ObjectMetadata();
    metadata.setContentLength(objectSize);
    metadata.setContentType(contentType);

    // アップロード
    client.putObject("/" + BUCKET_NAME, objectKey, new FileInputStream(source), metadata);

    // S3にアップロードしたので元のファイルは削除
    source.deleteOnExit();

  }

  //--------------------------------------------------
  // ダウンロード
  //--------------------------------------------------
  public static S3ObjectInputStream getObject(String objectKey) {

    // クライアント生成
    AmazonS3 client = getClient(BUCKET_NAME);

    // ダウンロード
    S3Object s3Object = client.getObject("/" + BUCKET_NAME, objectKey);

    return s3Object.getObjectContent();
  }

  //--------------------------------------------------
  // 一括削除
  //--------------------------------------------------
  public static List<String> deleteObjects(List<String> objectKeys) {

    // クライアント生成
    AmazonS3 client = getClient(BUCKET_NAME);

    List<DeleteObjectsRequest.KeyVersion> keys = new ArrayList<DeleteObjectsRequest.KeyVersion>();
    objectKeys.forEach(obj -> keys.add(new DeleteObjectsRequest.KeyVersion(obj)));

    // ファイル削除
    DeleteObjectsRequest request = new DeleteObjectsRequest("/" + BUCKET_NAME).withKeys(keys);
    DeleteObjectsResult result = client.deleteObjects(request);

    // 削除したオブジェクトのキーを取得
    List<String> deleted = new ArrayList<String>();
    result.getDeletedObjects().forEach(obj -> deleted.add(obj.getKey()));

    return deleted;
  }

  //--------------------------------------------------
  // クライアント生成
  //--------------------------------------------------
  private static AmazonS3 getClient(String BUCKET_NAME) {

    // 認証情報
    AWSCredentialsProvider provider = new ProfileCredentialsProvider(PROFILE_NAME);
//        AWSCredentials credentials = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
    AWSCredentials credentials = provider.getCredentials();

    // クライアント設定
    ClientConfiguration clientConfig = new ClientConfiguration();
    clientConfig.setProtocol(Protocol.HTTPS);  // プロトコル
    clientConfig.setConnectionTimeout(10000);   // 接続タイムアウト(ms)

    // エンドポイント設定
    AwsClientBuilder.EndpointConfiguration endpointConfiguration = new AwsClientBuilder.EndpointConfiguration(
        ENDPOINT_URL, REGION);

    // クライアント生成
    AmazonS3 client = AmazonS3ClientBuilder.standard()
        .withCredentials(new AWSStaticCredentialsProvider(credentials))
        .withClientConfiguration(clientConfig)
        .withEndpointConfiguration(endpointConfiguration)
        .withPathStyleAccessEnabled(true)
        .build();

    if (!client.doesBucketExistV2("/" + BUCKET_NAME)) {
      // バケットの作成

      client.createBucket(new CreateBucketRequest(BUCKET_NAME, REGION));

//      // バケットがなければException
//      throw new SystemException("S3バケット[" + BUCKET_NAME + "]がありません");
    }

    return client;
  }

  @Value("${aws.s3.endpoint-url}")
  public void setEndpointUrl(String endpointUrl) {
    ENDPOINT_URL = endpointUrl;
  }

  @Value("${aws.s3.region}")
  public void setRegion(String region) {
    REGION = region;
  }

  @Value("${aws.s3.bucket-name}")
  public void setBucketName(String bucketName) {
    BUCKET_NAME = bucketName;
  }

  @Value("${aws.s3.profile-name}")
  public void setProfileName(String profileName) {
    PROFILE_NAME = profileName;
  }

}
