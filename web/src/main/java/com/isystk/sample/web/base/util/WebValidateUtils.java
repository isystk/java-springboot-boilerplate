package com.isystk.sample.web.base.util;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.io.IOException;
import java.util.Iterator;

/**
 * 入力チェックユーティリティ
 */
public class WebValidateUtils {

  /**
   * ファイルの拡張子をチェックします。
   *
   * @param file       ファイル
   * @param extensions 対応する拡張子
   * @return true / false
   */
  public static boolean isExtension(MultipartFile file, String[] extensions) {
    if (file == null) {
      return false;
    }
    String fileName = file.getResource().getFilename();
    if (extensions == null || extensions.length == 0) {
      return (FilenameUtils.indexOfExtension(fileName) == -1);
    }
    String fileExt = FilenameUtils.getExtension(fileName);
    for (int i = 0; i < extensions.length; i++) {
      if (fileExt.equalsIgnoreCase(extensions[i])) {
        return true;
      }
    }
    return false;
  }

  /**
   * ファイルの拡張子をチェックします。（エラーメッセージも同時に追加）
   *
   * @param propertyName プロパティ名
   * @param file         ファイル
   * @param extensions   対応する拡張子
   * @param messages     メッセージ
   * @param itemName     項目名（表示文字列）
   */
  public static void isExtensionChk(String propertyName, MultipartFile file, String[] extensions,
      Errors errors,
      String itemName) {
    if (!isExtension(file, extensions)) {
      errors.rejectValue(propertyName, "errors.isextension", new Object[]{propertyName}, "");
    }
  }

  /**
   * ファイルサイズをチェックします。
   *
   * @param file    ファイル
   * @param maxSize 最大のファイルサイズ（バイト）
   * @return true / false
   */
  public static boolean maxFileSize(MultipartFile file, long maxSize) {
    if (file == null) {
      return false;
    }
    if (maxSize < file.getSize()) {
      return false;
    }
    return true;
  }

  /**
   * ファイルサイズをチェックします。（エラーメッセージも同時に追加）
   *
   * @param propertyName プロパティ名
   * @param file         ファイル
   * @param maxSize      最大のファイルサイズ（バイト）
   * @param messages     メッセージ
   * @param itemName     項目名（表示文字列）
   */
  public static void maxFileSizeChk(String propertyName, MultipartFile file, long maxSize,
      Errors errors,
      String itemName) {
    if (!maxFileSize(file, maxSize)) {
      errors.rejectValue(propertyName, "errors.maxfilesize", new Object[]{propertyName}, "");
    }
  }

  /**
   * 画像ファイルかどうかをチェックします。
   *
   * @param imageFile 画像ファイル
   * @return true / false
   */
  public static boolean isImageFile(MultipartFile imageFile) {
    if (imageFile == null) {
      return false;
    }
    ImageInputStream is = null;
    try {
      is = ImageIO.createImageInputStream(imageFile.getInputStream());
      Iterator<ImageReader> i = ImageIO.getImageReaders(is);
      while (i.hasNext()) {
        return true;
      }
    } catch (IOException e) {
    } finally {
      if (is != null) {
        try {
          is.close();
        } catch (IOException e1) {
        }
      }
    }
    return false;
  }

  /**
   * 画像ファイルかどうかをチェックします。（エラーメッセージも同時に追加）
   *
   * @param propertyName プロパティ名
   * @param file         ファイル
   * @param messages     メッセージ
   * @param itemName     項目名（表示文字列）
   */
  public static void isImageFileChk(String propertyName, MultipartFile imageFile, Errors errors,
      String itemName) {
    if (!isImageFile(imageFile)) {
      errors.rejectValue(propertyName, "errors.isImageFile", new Object[]{propertyName}, "");
    }
  }

  /**
   * 画像がCMYKであるかどうか
   *
   * @param imageFile
   * @return true:CMYK、false:CMYKでない
   */
  public static boolean isCmykImageChk(MultipartFile imageFile) {

    try {
      ImageIO.read(imageFile.getInputStream());

    } catch (IIOException e) {
      if (!StringUtils.isEmpty(e.getMessage()) && e.getMessage().equals("Unsupported Image Type")) {
        // CMYKの場合当該例外が発生する
        return true;
      }
      return false;

    } catch (Exception e) {
      return false;

    }
    return false;
  }

}
