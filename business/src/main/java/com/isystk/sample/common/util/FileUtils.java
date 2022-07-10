package com.isystk.sample.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import org.apache.commons.io.FilenameUtils;

public class FileUtils {

  /**
   * ディレクトリがない場合は作成します。
   *
   * @param location
   */
  public static void createDirectory(Path location) {
    try {
      Files.createDirectory(location);
    } catch (FileAlreadyExistsException ignore) {
      // ignore
    } catch (IOException e) {
      throw new IllegalArgumentException("could not create directory. " + location.toString(), e);
    }
  }

  /**
   * 親ディレクトリを含めてディレクトリがない場合は作成します。
   *
   * @param location
   */
  public static void createDirectories(Path location) {
    try {
      Files.createDirectories(location);
    } catch (FileAlreadyExistsException ignore) {
      // ignore
    } catch (IOException e) {
      throw new IllegalArgumentException("could not create directory. " + location.toString(), e);
    }
  }

  /**
   * ファイルの拡張子をチェックします。
   *
   * @param file       ファイル
   * @param extensions 対応する拡張子
   * @return true / false
   */
  public static boolean isExtension(File file, String[] extensions) {
    if (file == null) {
      return false;
    }
    String fileName = file.getName();
    if (extensions == null || extensions.length == 0) {
      return (FilenameUtils.indexOfExtension(fileName) == -1);
    }
    String fileExt = getExtension(fileName);
    for (int i = 0; i < extensions.length; i++) {
      if (fileExt.equalsIgnoreCase(extensions[i])) {
        return true;
      }
    }
    return false;
  }

  /**
   * ファイルの拡張子を取得します。
   *
   * @param fileName ファイル
   */
  public static String getExtension(String fileName) {
    if (StringUtils.isBlankOrSpace(fileName)) {
      return "";
    }
    String fileExt = FilenameUtils.getExtension(fileName);
    return fileExt.toLowerCase();
  }

  /**
   * ファイルサイズをチェックします。
   *
   * @param file    ファイル
   * @param maxSize 最大のファイルサイズ（バイト）
   * @return true / false
   */
  public static boolean maxFileSize(File file, long maxSize) {
    if (file == null) {
      return false;
    }
    if (maxSize < file.length()) {
      return false;
    }
    return true;
  }

  /**
   * 画像ファイルかどうかをチェックします。
   *
   * @param imageFile 画像ファイル
   * @return true / false
   */
  public static boolean isImageFile(File imageFile) {
    if (imageFile == null) {
      return false;
    }
    ImageInputStream is = null;
    try {
      is = ImageIO.createImageInputStream(new FileInputStream(imageFile));
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
   * ファイルまたはフォルダを削除する
   *
   * @param path パス
   * @return true=削除成功、false=削除失敗
   */
  public static boolean delete(String path) {
		if (StringUtils.isNullOrEmpty(path)) {
			return false;
		}
    File file = new File(path);
    return delete(file);
  }

  /**
   * ファイルまたはフォルダを削除する
   *
   * @param file java.io.File
   * @return true=削除成功、false=削除失敗
   */
  public static boolean delete(File file) {
		if (file == null) {
			return false;
		}
		if (!file.exists()) {
			return false;
		}
    try {
      org.apache.commons.io.FileUtils.forceDelete(file);
      return true;
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
  }

}
