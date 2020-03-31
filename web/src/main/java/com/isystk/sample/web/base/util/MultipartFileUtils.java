package com.isystk.sample.web.base.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import com.isystk.sample.common.util.FileUtils;
import com.isystk.sample.domain.dto.common.BZip2Data;
import com.isystk.sample.domain.dto.common.MultipartFileConvertible;

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

    /**
     * ファイルを保存します。
     *
     * @param location
     * @param file
     *            保存先ディレクトリ
     */
    public static void saveFile(Path location, MultipartFile file) {
        Assert.notNull(file, "file can't be null");
        String filename = file.getOriginalFilename();

        try {
            if (file.isEmpty()) {
                throw new IllegalArgumentException("cloud not save empty file. " + filename);
            }

            // ディレクトリがない場合は作成する
            FileUtils.createDirectories(location);

            // インプットストリームをファイルに書き出す
            Files.copy(file.getInputStream(), location.resolve(filename));

        } catch (IOException e) {
            throw new IllegalStateException("failed to save file. " + filename, e);
        }
    }
}
