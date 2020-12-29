/*
 * NumberUtil.java 2011/03/28 iseyoshitaka
 */
package com.isystk.sample.common.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class NumberUtils {

  /**
   * 文字列をIntegerに変換します
   *
   * @param str 文字列
   * @return Integer
   */
  public static final Integer toInteger(String str) {
    return toInteger(str, null);
  }

  /**
   * 文字列をIntegerに変換します
   *
   * @param str          文字列
   * @param defaultValue 数値変換に失敗した場合のデフォルト値
   * @return Integer
   */
  public static final Integer toInteger(String str, Integer defaultValue) {
    if (str == null) {
      return defaultValue;
    }
    try {
      return Integer.parseInt(str);
    } catch (NumberFormatException nfe) {
      return defaultValue;
    }
  }

  /**
   * 文字列の配列をIntegerの配列に変換します (null の場合は値が消えてしまうので非推奨)
   *
   * @param strArray 文字列の配列
   * @return Integerの配列
   */
  public static final Integer[] toIntegerArray(String[] strArray) {
    if (strArray == null) {
      return null;
    }
    List<Integer> intArray = new ArrayList<Integer>();
    for (int i = 0; i < strArray.length; i++) {
      Integer num = toInteger(strArray[i], null);
      if (num != null) {
        intArray.add(num);
      }
    }
    return intArray.toArray(new Integer[intArray.size()]);
  }

  /**
   * 文字列の配列をIntegerの配列に変換します。null の場合も含みます。
   *
   * @param strArray 文字列の配列
   * @return Integerの配列
   */
  public static final Integer[] toIntegerArrayIncludeNull(String[] strArray) {
    if (strArray == null) {
      return null;
    }
    List<Integer> intArray = new ArrayList<Integer>();
    for (int i = 0; i < strArray.length; i++) {
      Integer num = toInteger(strArray[i], null);
      intArray.add(num);
    }
    return intArray.toArray(new Integer[intArray.size()]);
  }

  /**
   * 文字列をIntegerに変換します
   *
   * @param strArray     文字列の配列
   * @param defaultValue 数値変換に失敗した場合のデフォルト値
   * @return Integer
   */
  public static final Integer[] toIntegerArray(String[] strArray, Integer[] defaultValue) {
    if (strArray == null) {
      return defaultValue;
    }
    return toIntegerArray(strArray);
  }

  /**
   * 値がNULLの場合にデフォルト値を設定します。
   */
  public static final Integer toInteger(Integer num, Integer defaultValue) {
    if (num == null) {
      return defaultValue;
    }
    return num;
  }

  /**
   * 値がNULLの場合にデフォルト値を設定します。
   */
  public static final Long toLong(Long num, Long defaultValue) {
    if (num == null) {
      return defaultValue;
    }
    return num;
  }

  /**
   * 文字列をLongに変換します
   *
   * @param str 文字列
   * @return Long
   * @see NumberUtils#toLong(String)
   */
  public static final Long toLong(String str) {
    return toLong(str, null);
  }

  /**
   * 文字列をLongに変換します
   *
   * @param str          文字列
   * @param defaultValue 数値変換に失敗した場合のデフォルト値
   * @return Long
   */
  public static final Long toLong(String str, Long defaultValue) {
    if (str == null) {
      return defaultValue;
    }
    try {
      return Long.parseLong(str);
    } catch (NumberFormatException nfe) {
      return defaultValue;
    }
  }

  /**
   * 文字列の配列をLongの配列に変換します
   *
   * @param strArray 文字列の配列
   * @return Longの配列
   */
  public static final Long[] toLongArray(String[] strArray) {
    Long[] intArray = new Long[strArray.length];
    for (int i = 0; i < strArray.length; i++) {
      intArray[i] = toLong(strArray[i], null);
    }
    return intArray;
  }

  /**
   * IntegerをBigIntegerに変換します
   *
   * @param num Integer値
   * @return Long
   * @see NumberUtils#toBigInteger(Integer)
   */
  public static final BigInteger toBigInteger(Integer num) {
    return toBigInteger(num, null);
  }

  /**
   * IntegerをBigIntegerに変換します
   *
   * @param num          Integer値
   * @param defaultValue 数値変換に失敗した場合のデフォルト値
   * @return Long
   */
  public static final BigInteger toBigInteger(Integer num, BigInteger defaultValue) {
    if (num == null) {
      return defaultValue;
    }
    try {
      return new BigInteger(num.toString());
    } catch (NumberFormatException nfe) {
      return defaultValue;
    }
  }

  /**
   * 文字列をDoubleに変換します
   *
   * @param str 文字列
   * @return Double
   * @see NumberUtils#toDouble(String)
   */
  public static final Double toDouble(String str) {
    return toDouble(str, null);
  }

  /**
   * 文字列をDoubleに変換します
   *
   * @param str          文字列
   * @param defaultValue 数値変換に失敗した場合のデフォルト値
   * @return Double
   */
  public static final Double toDouble(String str, Double defaultValue) {
    if (str == null) {
      return defaultValue;
    }
    try {
      return Double.parseDouble(str);
    } catch (NumberFormatException nfe) {
      return defaultValue;
    }
  }

  /**
   * 文字列をBigDecimalに変換します
   *
   * @param str 文字列
   * @return BigDecimal
   * @see NumberUtils#toBigDecimal(String)
   */
  public static final BigDecimal toBigDecimal(String str) {
    return toBigDecimal(str, null);
  }

  /**
   * 文字列をDoubleに変換します
   *
   * @param str          文字列
   * @param defaultValue 数値変換に失敗した場合のデフォルト値
   * @return Double
   */
  public static final BigDecimal toBigDecimal(String str, BigDecimal defaultValue) {
    if (str == null) {
      return defaultValue;
    }
    try {
      return new BigDecimal(str);
    } catch (NumberFormatException nfe) {
      return defaultValue;
    }
  }

  /**
   * 1~999999999の範囲内で乱数を取得します。
   *
   * @return
   */
  public static final Integer getRandomInteger() {
    return Integer.valueOf((int) (Math.random() * 999999999 + 1));
  }

  /**
   * 対象がNULLの場合に指定したデフォルト値を返却します。
   *
   * @return
   */
  public static Integer defaultValue(Integer target, Integer defaultValue) {
    if (target == null) {
      return defaultValue;
    }
    return target;
  }

  /**
   * 対象がNULLの場合に指定したデフォルト値を返却します。
   *
   * @return
   */
  public static Long defaultValue(Long target, Long defaultValue) {
    if (target == null) {
      return defaultValue;
    }
    return target;
  }

  /**
   * 引数で指定したリストの和を返却します。
   *
   * @return
   */
  public static Double sum(List<Object> targets) {
    if (targets == null) {
      return Double.valueOf(0);
    }
    double sum = 0;
    for (int i = 0; i < targets.size(); i++) {
      Double target = Double.valueOf(targets.get(i).toString());
      sum = sum + target;
    }
    return sum;
  }

  /**
   * 引数で指定したリストの平均を返却します。
   *
   * @return
   */
  public static Double avg(List<Object> targets) {
    if (targets == null) {
      return Double.valueOf(0);
    }
    double sum = 0;
    for (int i = 0; i < targets.size(); i++) {
      Double target = Double.valueOf(targets.get(i).toString());
      sum = sum + target;
    }
    return sum / targets.size();
  }

}
