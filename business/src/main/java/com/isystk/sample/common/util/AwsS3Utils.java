package com.isystk.sample.common.util;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.SDKGlobalConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.internal.StaticCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import com.google.common.collect.Lists;
import com.isystk.sample.common.Environment;
import com.isystk.sample.common.exception.SystemException;
import java.io.File;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@Slf4j
public class AwsS3Utils {

  /** ログ */
  protected static final Logger logger = LoggerFactory.getLogger(AwsS3Utils.class);

  public static String ENDPOINT_URL;
  public static String REGION;
//  private static String PROFILE_NAME;
  private static String AWS_ACCESS_KEY;
  private static String AWS_SECRET_KEY;

  /**
   * S3クライアントを取得する
   * @return AmazonS3
   */
  private static AmazonS3 getS3Client() {
    System.setProperty(SDKGlobalConfiguration.ENABLE_S3_SIGV4_SYSTEM_PROPERTY, "true");
    ClientConfiguration clientConfig = new ClientConfiguration();
    clientConfig.setConnectionTimeout(30000);
    clientConfig.setClientExecutionTimeout(300000);
    clientConfig.setSocketTimeout(30000);
    clientConfig.setRequestTimeout(30000);
    clientConfig.setMaxErrorRetry(10);

    EndpointConfiguration endpointConfiguration = new EndpointConfiguration(ENDPOINT_URL,
        REGION);
    AmazonS3ClientBuilder clientBuilder = AmazonS3ClientBuilder.standard().withClientConfiguration(clientConfig)
        .withEndpointConfiguration(endpointConfiguration)
        .withPathStyleAccessEnabled(true);

    if (Environment.get() == Environment.LOCAL) {
      // ローカル環境の場合のみクレディンシャルのパスを指定する
      AWSCredentials credentials = new BasicAWSCredentials(AWS_ACCESS_KEY, AWS_SECRET_KEY);
      AWSCredentialsProvider credentialsProvider = new StaticCredentialsProvider(credentials);
//			ProfileCredentialsProvider credentialsProvider = new ProfileCredentialsProvider(CREDENTIALS, PROFILE_NAME);
      return clientBuilder.withCredentials(credentialsProvider).build();
    }
    // AWS環境の場合はIAMロール認証なのでクレディンシャルは設定しない
    return clientBuilder.build();
  }

  /**
   * S3にファイルをアップロードします。
   * アップロード後にローカルファイルを削除します。
   * @param filePath
   * @param remotePath
   * @param bucket
   * @return
   */
  public static boolean s3PutObject(String filePath, String remotePath, String bucket) {
    return s3PutObject(filePath, remotePath, bucket, true);
  }
  /**
   * S3にファイルをアップロードします。
   * delete がtrueの場合、ローカルファイルを削除します。
   * @param filePath
   * @param remotePath
   * @param bucket
   * @param delete
   * @return
   */
  public static boolean s3PutObject(String filePath, String remotePath, String bucket, boolean delete) {
    AmazonS3 s3 = getS3Client();
    // remotePathは先頭/始まりの場合には、削除する
    remotePath = remotePath.startsWith("/") ? remotePath.substring(1) : remotePath;
    try {
      logger.info("bucket:" + bucket + " remotePath:" + remotePath + " localPath:" + filePath);
      s3.putObject(bucket, remotePath, new File(filePath));
    } catch (SystemException e) {
      throw e;
    } catch (Exception e) {
      throw new SystemException(e);
    }
    // s3アップロード完了後はファイルを削除する。
    if (delete)
      FileUtils.delete(filePath);
    return true;
  }

  public static boolean s3Exist(String bucket, String filePath) {
    AmazonS3 s3 = getS3Client();
    return s3.doesObjectExist(bucket, filePath);
  }


  /**
   * 条件に当たるS3ObjectSummaryをListで返す</br>
   * 最大1000件まで取得するため、s3GetListsObjectV2を使うこと
   *
   * @param bucket
   * @param filePath
   * @return
   */
  public static List < S3ObjectSummary > s3GetListsObject(String bucket, String filePath) {
    AmazonS3 s3 = getS3Client();
    ObjectListing list = s3.listObjects(new ListObjectsRequest().withBucketName(bucket)
        .withPrefix(filePath.startsWith("/") ? filePath.substring(1) : filePath));
    return list.getObjectSummaries();
  }

  public static S3Object s3GetObject(String bucket, String filePath) {
    AmazonS3 s3 = getS3Client();
    return s3.getObject(bucket, filePath);
  }

  public static void s3DeleteObject(String bucket, String filePath) {
    AmazonS3 s3 = getS3Client();
    ObjectListing objects = s3.listObjects(bucket, filePath);
    for (S3ObjectSummary objectSummary : objects.getObjectSummaries()) {
      s3.deleteObject(bucket, objectSummary.getKey());
    }
  }

  public static CopyObjectResult s3CopyObject(String fromBucket, String fromObjectKey, String toBucket, String toObjectKey) {
    AmazonS3 s3 = getS3Client();
    CopyObjectRequest copyObjectRequest = new CopyObjectRequest(fromBucket, fromObjectKey, toBucket, toObjectKey);
    return s3.copyObject(copyObjectRequest);
  }

  /**
   * 条件に当たるS3ObjectSummaryをListで返す
   *
   * @param bucket
   * @param filePath
   * @return
   */
  public static List < S3ObjectSummary > s3GetListsObjectV2(String bucket, String filePath) {
    AmazonS3 s3 = getS3Client();
    List<S3ObjectSummary> resultList = Lists.newArrayList();
    ListObjectsV2Request request =
        new ListObjectsV2Request()
            .withBucketName(bucket)
            .withPrefix(filePath.startsWith("/") ? filePath.substring(1) : filePath);
    ListObjectsV2Result result;

    do {
      result = s3.listObjectsV2(request);
      resultList.addAll(result.getObjectSummaries());
      String token = result.getNextContinuationToken();
      request.setContinuationToken(token);
    }  while(result.isTruncated());
    return resultList;
  }

  @Value("${aws.s3.endpoint-url}")
  public void setEndpointUrl(String endpointUrl) {
    ENDPOINT_URL = endpointUrl;
  }

  @Value("${aws.s3.region}")
  public void setRegion(String region) {
    REGION = region;
  }

//  @Value("${aws.s3.profile-name}")
//  public void setProfileName(String profileName) {
//    PROFILE_NAME = profileName;
//  }

  @Value("${aws.s3.aws-access-key}")
  public void setAwsAccessKey(String awsAccessKey) {
    AWS_ACCESS_KEY = awsAccessKey;
  }

  @Value("${aws.s3.aws-secret-key}")
  public void setAwsSecretKey(String awsSecretKey) {
    AWS_SECRET_KEY = awsSecretKey;
  }

}
