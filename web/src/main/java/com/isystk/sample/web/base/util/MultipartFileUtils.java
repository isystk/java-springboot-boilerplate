package com.isystk.sample.web.base.util;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.isystk.sample.common.dto.BZip2Data;
import com.isystk.sample.common.dto.MultipartFileConvertible;

import lombok.extern.slf4j.Slf4j;

/**
 * MultipartFile関連のユーティリティ
 */
@Slf4j
public class MultipartFileUtils {

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
