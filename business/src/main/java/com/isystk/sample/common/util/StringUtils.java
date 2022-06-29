package com.isystk.sample.common.util;

import java.util.List;
import org.apache.commons.compress.utils.Lists;

/**
 * 文字列に関するユーティリティ。
 */
public final class StringUtils {

  /**
   * スペース文字のみで構成されているかチェックします.
   *
   * @param str 文字列
   * @return 空かスペース構成文字のみのときtrue
   */
  public static boolean isBlankOrSpace(String str) {
    if (str == null) {
      return true;
    }
    return isNullOrEmpty(str.replaceAll("[\t 　]", ""));

  }

  /**
   * 指定した文字列がnullまたは空文字列であるか否かを取得する。
   *
   * @param string 対象文字列
   * @return 文字列がnullまたは空文字列の場合true.そうでなければfalse.
   */
  public static boolean isNullOrEmpty(Object string) {
    return string == null || string.toString().length() == 0;
  }

  /**
   * すべての値が、スペース文字のみで構成されているかチェックします.
   *
   * @param str 文字列
   * @return すべての値が、空かスペース構成文字のみのときtrue
   */
  public static boolean isAllBlankOrSpace(String[] str) {
    if (str == null) {
      return true;
    }
    boolean result = true;
    for (String a : str) {
      if (!isBlankOrSpace(a)) {
        result = false;
        break;
      }
    }
    return result;
  }

  /**
   * カンマ区切りの文字列をリストに変換する
   * @param line
   * @return
   */
  public static List<String> csvSplit(String line) {
    List<String> list = Lists.newArrayList();
    if (isBlankOrSpace(line)) {
      return list;
    }
    String[] words = line.split(",");
    for (String word : words) {
      list.add(trimDoubleQuot(word));
    }
    return list;
  }

  /**
   * 文字列前後のダブルクォーテーションを削除するFunction
   * @param str 文字列
   * @return 前後のダブルクォーテーションを削除した文字列
   */
  public static String trimDoubleQuot(String str) {
    if (isBlankOrSpace(str)) {
      return str;
    }
    str = str.trim();
    char c = '"';
    if(str.charAt(0) == c && str.charAt(str.length()-1) == c) {
      return str.substring(1, str.length()-1);
    }else {
      return str;
    }
  }
}