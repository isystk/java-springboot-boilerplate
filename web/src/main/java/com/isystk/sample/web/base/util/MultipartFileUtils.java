package com.isystk.sample.web.base.util;

import com.isystk.sample.common.dto.BZip2Data;
import com.isystk.sample.common.dto.MultipartFileConvertible;
import org.slf4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * MultipartFile関連のユーティリティ
 */
public class MultipartFileUtils {

  private static final Logger log = org.slf4j.LoggerFactory.getLogger(MultipartFileUtils.class);

  /**
   * MultipartFileConvertibleに値を詰め替えます。
   *
   * @param from
   * @param to
   */
  public static void convert(MultipartFile from, MultipartFileConvertible to) {
    to.setFilename(from.getName());
    to.setOriginalFilename(from.getOriginalFilename());
    to.setContentType(from.getContentType());

    try {
      to.setContent(BZip2Data.of(from.getBytes()));
    } catch (IOException e) {
      log.error("failed to getBytes", e);
      throw new IllegalArgumentException(e);
    }
  }

}
