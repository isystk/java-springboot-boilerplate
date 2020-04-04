package com.isystk.sample.web.base.util;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.web.multipart.MultipartFile;

/**
 * 入力チェックユーティリティ
 */
public class WebValidateUtils {

	/**
	 * 必須か（値が含まれているか）どうかをチェック
	 *
	 * @param value
	 *            値
	 * @return true / false
	 */
	public static boolean required(String value) {
		if (value == null) {
			return false;
		}

		if (value.length() == 0) {
			return false;
		}

		value = value.replaceAll("[\t\r\n 　]", "");
		if (value.length() == 0) {
			return false;
		}

		return true;
	}

	/**
	 * 必須か（値が含まれているか）どうかをチェック。（エラーメッセージも同時に追加）
	 *
	 * @param propertyName
	 *            プロパティ名
	 * @param value
	 *            値
	 * @param messages
	 *            メッセージ
	 * @param itemName
	 *            項目名（表示文字列）
	 */
	public static void requiredChk(String propertyName, String value, Errors errors, String itemName) {
		if (required(value) == false) {
			errors.rejectValue(propertyName, "NotBlank");
		}
	}

	/**
	 * フラグ（0 or 1）かどうかをチェック。
	 *
	 * @param value
	 *            値
	 * @return true / false
	 */
	public static boolean flg(String value) {
		if (StringUtils.isEmpty(value))
			return true;

		try {
			int i = Integer.parseInt(value);
			return (i == 0 || i == 1) ? true : false;

		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * 最短文字数チェック
	 *
	 * @param value
	 *            値
	 * @param min
	 *            最小文字数
	 * @return true / false
	 */
	public static boolean minLength(String value, int min) {
		return length(value, min, Integer.MAX_VALUE);
	}

	/**
	 * 最短文字数チェック（エラーメッセージも同時に追加）
	 *
	 * @param propertyName
	 *            プロパティ名
	 * @param value
	 *            値
	 * @param min
	 *            最小文字数
	 * @param messages
	 *            メッセージ
	 * @param itemName
	 *            項目名（表示文字列）
	 */
	public static void minLengthChk(String propertyName, String value, int min, Errors errors,
			String itemName) {
		if (minLength(value, min) == false) {
			errors.rejectValue(propertyName, "errors.minlength", new Object[]{itemName, Integer.toString(min)}, "");
		}
	}

	/**
	 * 最長文字数チェック
	 *
	 * @param value
	 *            値
	 * @param max
	 *            最大文字数
	 * @return true / false
	 */
	public static boolean maxLength(String value, int max) {
		return length(value, 0, max);
	}

	/**
	 * 最長文字数チェック（エラーメッセージも同時に追加）
	 *
	 * @param propertyName
	 *            プロパティ名
	 * @param value
	 *            値
	 * @param max
	 *            最大文字数
	 * @param messages
	 *            メッセージ
	 * @param itemName
	 *            項目名（表示文字列）
	 */
	public static void maxLengthChk(String propertyName, String value, int max, Errors errors,
			String itemName) {
		if (maxLength(value, max) == false) {
			errors.rejectValue(propertyName, "errors.maxlength", new Object[]{itemName, Integer.toString(max)}, "");
		}
	}

	/**
	 * 文字数チェック
	 *
	 * @param value
	 *            値
	 * @param min
	 *            最小文字数
	 * @param max
	 *            最大文字数
	 * @return true / false
	 */
	public static boolean length(String value, int min, int max) {
		if (StringUtils.isEmpty(value))
			return true;
		// js側で改行は2文字でカウントさせるようにした
		// value = value.replaceAll("\r\n", "\n");
		final int count = value.codePointCount(0, value.length());

		return count >= min && count <= max;
	}

	/**
	 * 文字数チェック（エラーメッセージも同時に追加）
	 *
	 * @param propertyName
	 *            プロパティ名
	 * @param value
	 *            値
	 * @param min
	 *            最小文字数
	 * @param max
	 *            最大文字数
	 * @param messages
	 *            メッセージ
	 * @param itemName
	 *            項目名（表示文字列）
	 */
	public static void lengthChk(String propertyName, String value, int min, int max, Errors errors,
			String itemName) {
		if (length(value, min, max) == false) {
			errors.rejectValue(propertyName, "errors.range", new Object[]{itemName, Integer.toString(min), Integer.toString(max)}, "");
		}
	}

	/**
	 * 最小数値チェック
	 *
	 * @param value
	 *            数値
	 * @param min
	 *            最小数値
	 * @return true / false
	 */
	public static boolean minValue(Integer value, int min) {
		if (value == null)
			return true;

		if (min <= value) {
			return true;
		}
		return false;
	}

	/**
	 * 最小数値チェック（エラーメッセージも同時に追加）
	 *
	 * @param propertyName
	 *            プロパティ名
	 * @param value
	 *            数値
	 * @param min
	 *            最小数値
	 * @param messages
	 *            メッセージ
	 * @param itemName
	 *            項目名（表示文字列）
	 */
	public static void minValueChk(String propertyName, Integer value, int min, Errors errors,
			String itemName) {
		if (minValue(value, min) == false) {
			errors.rejectValue(propertyName, "errors.minValue", new Object[]{itemName, Integer.toString(min)}, "");
		}
	}

	/**
	 * 最小数値チェック
	 *
	 * @param value
	 *            数値
	 * @param min
	 *            最小数値
	 * @return true / false
	 */
	public static boolean minValue(BigDecimal value, double min) {
		if (value == null)
			return true;

		if (min <= value.doubleValue()) {
			return true;
		}
		return false;
	}

	/**
	 * 最小数値チェック（エラーメッセージも同時に追加）
	 *
	 * @param propertyName
	 *            プロパティ名
	 * @param value
	 *            数値
	 * @param min
	 *            最小数値
	 * @param messages
	 *            メッセージ
	 * @param itemName
	 *            項目名（表示文字列）
	 */
	public static void minValueChk(String propertyName, BigDecimal value, double min, Errors errors,
			String itemName) {
		if (minValue(value, min) == false) {
			errors.rejectValue(propertyName, "errors.minValue", new Object[]{itemName, Double.toString(min)}, "");
		}
	}

	/**
	 * 最大数値チェック
	 *
	 * @param value
	 *            数値
	 * @param min
	 *            最大数値
	 * @return true / false
	 */
	public static boolean maxValue(Integer value, int max) {
		if (value == null)
			return true;

		if (value <= max) {
			return true;
		}
		return false;
	}

	/**
	 * 最大数値チェック（エラーメッセージも同時に追加）
	 *
	 * @param propertyName
	 *            プロパティ名
	 * @param value
	 *            数値
	 * @param min
	 *            最大数値
	 * @param messages
	 *            メッセージ
	 * @param itemName
	 *            項目名（表示文字列）
	 */
	public static void maxValueChk(String propertyName, Integer value, int max, Errors errors,
			String itemName) {
		if (maxValue(value, max) == false) {
			errors.rejectValue(propertyName, "errors.maxValue", new Object[]{itemName, Integer.toString(max)}, "");
		}
	}

	/**
	 * 最大数値チェック
	 *
	 * @param value
	 *            数値
	 * @param min
	 *            最大数値
	 * @return true / false
	 */
	public static boolean maxValue(BigDecimal value, double max) {
		if (value == null)
			return true;

		if (value.doubleValue() <= max) {
			return true;
		}
		return false;
	}

	/**
	 * 最大数値チェック（エラーメッセージも同時に追加）
	 *
	 * @param propertyName
	 *            プロパティ名
	 * @param value
	 *            数値
	 * @param max
	 *            最大数値
	 * @param messages
	 *            メッセージ
	 * @param itemName
	 *            項目名（表示文字列）
	 */
	public static void maxValueChk(String propertyName, BigDecimal value, double max, Errors errors,
			String itemName) {
		if (maxValue(value, max) == false) {
			errors.rejectValue(propertyName, "errors.maxValue", new Object[]{itemName, Double.toString(max)}, "");
		}
	}

	/**
	 * 少数値フォーマットチェック
	 *
	 * @param val
	 *            数値
	 * @param num1
	 *            整数部分の桁数
	 * @param num2
	 *            少数部分の桁数
	 * @return
	 */
	public static boolean decimalValue(String val, int num1, int num2) {
		String regex = "^(\\d{" + num1 + "})(\\.\\d{" + num2 + "})?$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(val);
		return matcher.find();
	}

	/**
	 * 少数値フォーマットチェック（エラーメッセージも同時に追加）
	 *
	 * @param propertyName
	 *            プロパティ名
	 * @param value
	 *            数値
	 * @param num1
	 *            整数部分の桁数
	 * @param num2
	 *            少数部分の桁数
	 * @param messages
	 *            メッセージ
	 * @param itemName
	 *            項目名（表示文字列）
	 */
	public static void decimalValueChk(String propertyName, String value, int num1, int num2, Errors errors,
			String itemName) {
		if (decimalValue(value, num1, num2) == false) {
			errors.rejectValue(propertyName, "errors.decimalValue", new Object[]{itemName, Integer.toString(num1), Integer.toString(num2)}, "");
		}
	}

	/**
	 * 半角文字（1バイト文字）にマッチするかどうか（半角カナはマルチバイトなのでNG）
	 *
	 * @param value
	 *            値
	 * @return true / false
	 */
	public static boolean matchesHalfChar(String value) {
		if (StringUtils.isEmpty(value))
			return true;

		return value.length() == value.getBytes().length;
	}

	/**
	 * 半角文字（1バイト文字）にマッチするかどうか（半角カナはマルチバイトなのでNG）（エラーメッセージも同時に追加）
	 *
	 * @param propertyName
	 *            プロパティ名
	 * @param value
	 *            値
	 * @param messages
	 *            メッセージ
	 * @param itemName
	 *            項目名（表示文字列）
	 */
	public static void matchesHalfCharChk(String propertyName, String value, Errors errors, String itemName) {
		if (matchesHalfChar(value) == false) {
			errors.rejectValue(propertyName, "errors.halfChar", new Object[]{itemName}, "");
		}
	}

	/**
	 * 半角英数にマッチするかどうか
	 *
	 * @param value
	 *            値
	 * @return true / false
	 */
	public static boolean matchesHalf(String value) {
		if (StringUtils.isEmpty(value))
			return true;

		return value.matches("[0-9a-zA-Z]+");
	}

	/**
	 * 半角英数にマッチするかどうか（エラーメッセージも同時に追加）
	 *
	 * @param propertyName
	 *            プロパティ名
	 * @param value
	 *            値
	 * @param messages
	 *            メッセージ
	 * @param itemName
	 *            項目名（表示文字列）
	 */
	public static void matchesHalfChk(String propertyName, String value, Errors errors, String itemName) {
		if (matchesHalf(value) == false) {
			errors.rejectValue(propertyName, "errors.ishankakueisu", new Object[]{itemName}, "");
		}
	}

	/**
	 * 半角英数、アンダースコア、ハイフン、ドットにマッチするかどうか
	 *
	 * @param value
	 *            値
	 * @return true / false
	 */
	public static boolean matchesResourceKey(String value) {
		if (StringUtils.isEmpty(value))
			return true;

		return value.matches("[\\w\\.\\-]+");
	}

	/**
	 * 半角英数、アンダースコア、ハイフン、ドットにマッチするかどうか（エラーメッセージも同時に追加）
	 *
	 * @param propertyName
	 *            プロパティ名
	 * @param value
	 *            値
	 * @param messages
	 *            メッセージ
	 * @param key
	 *            キー
	 * @param params
	 *            置換文字列
	 */
	public static void matchesResourceKeyChk(String propertyName, String value, Errors errors, String key,
			Object... params) {
		if (matchesResourceKey(value) == false) {
			errors.rejectValue(propertyName, "errors.resourceKey", new Object[]{propertyName}, "");
		}
	}

	/**
	 * 半角正の整数（0始まりNG）にマッチするかどうか
	 *
	 * @param value
	 *            値
	 * @return true / false
	 */
	public static boolean matchesHalfPositiveInteger(String value) {
		if (StringUtils.isEmpty(value))
			return true;

		return value.matches("0|[1-9][0-9]*");
	}

	/**
	 * 半角正の整数（0始まりNG）にマッチするかどうか（エラーメッセージも同時に追加）
	 *
	 * @param propertyName
	 *            プロパティ名
	 * @param value
	 *            値
	 * @param messages
	 *            メッセージ
	 * @param itemName
	 *            項目名（表示文字列）
	 */
	public static void matchesHalfPositiveIntegerChk(String propertyName, String value, Errors errors,
			String itemName) {
		if (matchesHalfPositiveInteger(value) == false) {
			errors.rejectValue(propertyName, "errors.halfPositiveInteger", new Object[]{propertyName}, "");
		}
	}

	/**
	 * 半角整数（0始まりNG・正負ともOK）にマッチするかどうか
	 *
	 * @param value
	 *            値
	 * @return true / false
	 */
	public static boolean matchesHalfInteger(String value) {
		if (StringUtils.isEmpty(value))
			return true;

		return value.matches("\\-?(0|[1-9][0-9]*)");
	}

	/**
	 * 半角整数（0始まりNG・正負ともOK）にマッチするかどうか（エラーメッセージも同時に追加）
	 *
	 * @param propertyName
	 *            プロパティ名
	 * @param value
	 *            値
	 * @param messages
	 *            メッセージ
	 * @param itemName
	 *            項目名（表示文字列）
	 */
	public static void matchesHalfIntegerChk(String propertyName, String value, Errors errors,
			String itemName) {
		if (matchesHalfInteger(value) == false) {
			errors.rejectValue(propertyName, "errors.ishankakusu", new Object[]{propertyName}, "");
		}
	}

	/**
	 * 半角正の小数（整数部分の0埋めNG）にマッチするかどうか
	 *
	 * @param value
	 *            値
	 * @return true / false
	 */
	public static boolean matchesHalfPositiveDecimal(String value) {
		if (StringUtils.isEmpty(value))
			return true;

		return value.matches("(0|[1-9][0-9]*)(|\\.[0-9]+)");
	}

	/**
	 * 半角正の小数（整数部分の0埋めNG）にマッチするかどうか（エラーメッセージも同時に追加）
	 *
	 * @param propertyName
	 *            プロパティ名
	 * @param value
	 *            値
	 * @param messages
	 *            メッセージ
	 * @param itemName
	 *            項目名（表示文字列）
	 */
	public static void matchesHalfPositiveDecimalChk(String propertyName, String value, Errors errors,
			String itemName) {
		if (matchesHalfPositiveDecimal(value) == false) {
			errors.rejectValue(propertyName, "errors.halfPositiveDecimal", new Object[]{propertyName}, "");
		}
	}

	/**
	 * 半角小数（整数部分の0埋めNG・正負ともOK）にマッチするかどうか
	 *
	 * @param value
	 *            値
	 * @return true / false
	 */
	public static boolean matchesHalfDecimal(String value) {
		if (StringUtils.isEmpty(value))
			return true;

		return value.matches("\\-?(0|[1-9][0-9]*)(|\\.[0-9]+)");
	}

	/**
	 * 半角小数（整数部分の0埋めNG・正負ともOK）にマッチするかどうか（エラーメッセージも同時に追加）
	 *
	 * @param propertyName
	 *            プロパティ名
	 * @param value
	 *            値
	 * @param messages
	 *            メッセージ
	 * @param itemName
	 *            項目名（表示文字列）
	 */
	public static void matchesHalfDecimalChk(String propertyName, String value, Errors errors,
			String itemName) {
		if (matchesHalfDecimal(value) == false) {
			errors.rejectValue(propertyName, "errors.halfDecimal", new Object[]{propertyName}, "");
		}
	}

	/**
	 * 半角数字（0始まりOK、0～9だけで構成された値）にマッチするかどうか
	 *
	 * @param value
	 *            値
	 * @return true / false
	 */
	public static boolean matchesHalfNumber(String value) {
		if (StringUtils.isEmpty(value))
			return true;

		return value.matches("[0-9]+");
	}

	/**
	 * 半角数字（0始まりOK、0～9だけで構成された値）にマッチするかどうか（エラーメッセージも同時に追加）
	 *
	 * @param propertyName
	 *            プロパティ名
	 * @param value
	 *            値
	 * @param messages
	 *            メッセージ
	 * @param itemName
	 *            項目名（表示文字列）
	 */
	public static void matchesHalfNumberChk(String propertyName, String value, Errors errors,
			String itemName) {
		if (matchesHalfNumber(value) == false) {
			errors.rejectValue(propertyName, "errors.ishankakusu", new Object[]{propertyName}, "");
		}
	}

	private static final Pattern PTN_DIGIT_OR_ALPHA_OR_PUNCT = Pattern.compile("[\\p{Digit}\\p{Alnum}\\p{Punct}\\s]*");

	/**
	 * 半角英数記号および空白にマッチするかどうか
	 *
	 * @param value
	 *            値
	 * @return true / false
	 */
	public static boolean matchesHalfNumberOrAlphaOrPunct(String value) {
		if (StringUtils.isEmpty(value))
			return true;

		return PTN_DIGIT_OR_ALPHA_OR_PUNCT.matcher(value).matches();
	}

	/**
	 * 半角英数記号および空白にマッチするかどうか（エラーメッセージも同時に追加）
	 *
	 * @param propertyName
	 *            プロパティ名
	 * @param value
	 *            値
	 * @param messages
	 *            メッセージ
	 * @param itemName
	 *            項目名（表示文字列）
	 */
	public static void matchesHalfNumberOrAlphaOrPunctChk(String propertyName, String value, Errors errors,
			String itemName) {
		if (matchesHalfNumberOrAlphaOrPunct(value) == false) {
			errors.rejectValue(propertyName, "errors.ishankakueisukigou", new Object[]{propertyName}, "");
		}
	}

	// 半角文字(半角英数/記号/ｶﾅ)
	private static final Pattern PTN_HALFWIDTH = Pattern.compile("^[ -~｡-ﾟ]+$");

	// 全角文字(半角英数/記号/ｶﾅ 以外の文字すべて)
	private static final Pattern PTN_FULLWIDTH = Pattern.compile("^[^ -~｡-ﾟ]+$");

	/**
	 * 半角文字(半角英数/記号/ｶﾅ)にマッチするかどうか
	 *
	 * @param value
	 *            値
	 * @return true / false
	 */
	public static boolean matchesHalfWidth(String value) {
		if (StringUtils.isEmpty(value))
			return true;

		return PTN_HALFWIDTH.matcher(value).matches();
	}

	/**
	 * 全角文字にマッチするかどうか
	 *
	 * @param value
	 *            値
	 * @return true / false
	 */
	public static boolean matchesFullWidth(String value) {
		if (StringUtils.isEmpty(value))
			return true;

		return PTN_FULLWIDTH.matcher(value).matches();
	}

	/**
	 * 全角文字にマッチするかどうか（エラーメッセージも同時に追加）
	 *
	 * @param propertyName
	 *            プロパティ名
	 * @param value
	 *            値
	 * @param messages
	 *            メッセージ
	 * @param itemName
	 *            項目名（表示文字列）
	 */
	public static void matchesFullWidthChk(String propertyName, String value, Errors errors,
			String itemName) {
		if (matchesFullWidth(value) == false) {
			errors.rejectValue(propertyName, "errors.zenkakutype", new Object[]{propertyName}, "");
		}
	}

	/**
	 * 全角カタカナにマッチするかどうか
	 *
	 * @param value
	 *            値
	 * @return true / false
	 */
	public static boolean matchesFullWidthKatakana(String value) {
		if (StringUtils.isEmpty(value))
			return true;

		int len = value.length();
		for (int i = 0; i < len; i++) {
			char ch = value.charAt(i);
			if (ch >= 'ァ' && ch <= 'ヾ' || ch == '　') {
			} else {
				return false;
			}
		}

		return true;
	}

	/**
	 * 全角カタカナにマッチするかどうか（エラーメッセージも同時に追加）
	 *
	 * @param propertyName
	 *            プロパティ名
	 * @param value
	 *            値
	 * @param messages
	 *            メッセージ
	 * @param itemName
	 *            項目名（表示文字列）
	 */
	public static void matchesFullWidthKatakanaChk(String propertyName, String value, Errors errors,
			String itemName) {
		if (matchesFullWidthKatakana(value) == false) {
			errors.rejectValue(propertyName, "errors.isFullWidthKatakana", new Object[]{propertyName}, "");
		}
	}

	/**
	 * メールアドレスにマッチするかどうか
	 *
	 * @param value
	 *            値
	 * @return true / false
	 */
	public static boolean matchesEmail(String value) {
		if (StringUtils.isEmpty(value))
			return true;

		int indexOfAtmark = value.indexOf("@", 0);

		// メールアドレスに "@" が含まれているかの確認
		if (indexOfAtmark == -1) {
			return false;
		} else if (value.indexOf("@", indexOfAtmark + 1) != -1) {
			// @が複数存在する場合
			return false;
		} else if (indexOfAtmark == 0 || indexOfAtmark + 1 == value.length()) {
			// @が最初や最後に現れた場合
			return false;
		} else if (isWrongSymbolContain(value)) {
			// メールアドレス中に不正な記号（送信エラーになるもの） が含まれているかのチェック
			return false;
		} else if (value.indexOf(" ") != -1) {
			// メールアドレス中に半角スペースが含まれているかのチェック
			// ※バリデーションで半角スペースは空文字にしているため、通常ありえない
			return false;
		} else if (!matchesHalfWidth(value)) {
			// メールアドレスが半角文字か
			// ※全角文字は許容しない
			return false;
			// RFC に準拠しているかのチェック
			// 注意：API に直接 "mailAddress" を渡さないこと
		}
		return true;
	}

	/**
	 * メールアドレスチェック用 メール送信不可の記号が含まれているか<br>
	 * 対象記号→ ( ) < > [ ] ; : , \ "
	 *
	 * @param mailAddress
	 *            メールアドレス
	 * @return true / false
	 */
	private static boolean isWrongSymbolContain(String mailAddress) {
		char[] parenthesis = { '(', ')', '<', '>', '[', ']', ';', ':', ',', '\\', '"', '\u00a5' };
		for (int i = 0; i < mailAddress.length(); i++) {
			for (int j = 0; j < parenthesis.length; j++) {
				if (mailAddress.charAt(i) == parenthesis[j]) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * メールアドレスにマッチするかどうか（エラーメッセージも同時に追加）
	 *
	 * @param propertyName
	 *            プロパティ名
	 * @param value
	 *            値
	 * @param itemName
	 *            項目名（表示文字列）
	 */
	public static void matchesEmailChk(String propertyName, String value, Errors errors, String itemName) {
		if ((matchesEmail(value) == false)) {
			errors.rejectValue(propertyName, "errors.email", new Object[]{propertyName}, "");
		}
	}


	/**
	 * 電話番号（数字始まり、-ありOK）にマッチするかどうか
	 *
	 * @param value
	 *            値
	 * @return true / false
	 */
	public static boolean matchesPhone(String value) {
		if (StringUtils.isEmpty(value))
			return true;

		return value.matches("(?!-)(?!.*-$)(?!.*--)([-0-9]+)$");
	}

	/**
	 * 郵便番号（7文字の数値もしくはハイフン付き）にマッチするかどうか
	 *
	 * @param value
	 *            値
	 * @return true / false
	 */
	public static boolean matchesPostCode(String value) {
		if (StringUtils.isEmpty(value))
			return true;

		try {
			if (value.charAt(3) == '-') {
				value = value.substring(0, 3) + value.substring(4);
			}

			if (matchesHalfNumber(value) == false) { // Integer.valueOf(value)は全角でも数値を変換できてしまうので半角数値であることをチェックする
				return false;
			}

			Integer.valueOf(value); // 数値チェック （念のためIntegerへの変換に失敗しないかどうかをチェック）
			if (value.length() == 7) {
				return true;
			}
		} catch (Exception e) {
			// void
		}

		return false;
	}

	/**
	 * 郵便番号（7文字の数値）にマッチするかどうか（エラーメッセージも同時に追加）
	 *
	 * @param propertyName
	 *            プロパティ名
	 * @param value
	 *            値
	 * @param messages
	 *            メッセージ
	 * @param key
	 *            キー
	 * @param params
	 *            置換文字列
	 */
	public static void matchesPostCodeChk(String propertyName, String value, Errors errors,
			Object... params) {
		if (matchesPostCode(value) == false) {
			errors.rejectValue(propertyName, "errors.postcodetype", new Object[]{propertyName}, "");
		}
	}

	/**
	 * URL(HTTPS)にマッチするかどうか
	 *
	 * @param value
	 *            値
	 * @return true / false
	 */
	public static boolean matchesHttpsUrl(String value) {
		if (StringUtils.isEmpty(value))
			return true;

		try {
			new URL(value);
			return (value.startsWith("https://"));
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * URL(HTTPS)にマッチするかどうか（エラーメッセージも同時に追加）
	 *
	 * @param propertyName
	 *            プロパティ名
	 * @param value
	 *            値
	 * @param messages
	 *            メッセージ
	 * @param itemName
	 *            項目名（表示文字列）
	 */
	public static void matchesHttpsUrlChk(String propertyName, String value, Errors errors, String itemName) {
		if (matchesHttpsUrl(value) == false) {
			errors.rejectValue(propertyName, "errors.httpsurltype", new Object[]{propertyName}, "");
		}
	}

	/**
	 * URL(HTTPかHTTPS)にマッチするかどうか
	 *
	 * @param value
	 *            値
	 * @return true / false
	 */
	public static boolean matchesHttpOrHttpsUrl(String value) {
		if (StringUtils.isEmpty(value))
			return true;

		try {
			new URL(value);
			return (value.startsWith("http://") || value.startsWith("https://"));
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * URL(HTTPかHTTPS)にマッチするかどうか（エラーメッセージも同時に追加）
	 *
	 * @param propertyName
	 *            プロパティ名
	 * @param value
	 *            値
	 * @param messages
	 *            メッセージ
	 * @param itemName
	 *            項目名（表示文字列）
	 */
	public static void matchesHttpOrHttpsUrlChk(String propertyName, String value, Errors errors,
			String itemName) {
		if (matchesHttpOrHttpsUrl(value) == false) {
			errors.rejectValue(propertyName, "errors.httporhttpsurltype", new Object[]{propertyName}, "");
		}
	}

	/**
	 * 当該URLが指定のドメインにマッチするかどうか（ただし、URLの形式でない場合にはチェックをしないので注意。
	 * matchesHttpUrlを合わせて使用すること）
	 *
	 * @param value
	 *            値
	 * @param domainName
	 *            ドメイン名
	 * @return true / false
	 */
	public static boolean matchesUrlDomain(String value, String domainName) {
		if (StringUtils.isEmpty(value))
			return true;

		try {
			URL url = new URL(value);
			return domainName.equals(url.getHost());
		} catch (Exception e) {
			return true;
		}
	}

	/**
	 * 空文字または印刷可能文字のみの場合、true
	 *
	 * @param value
	 *            値
	 * @return true / false
	 */
	public static boolean matchPrintableCharacters(String value) {
		if (StringUtils.isEmpty(value))
			return true;
		return value.matches("\\p{Print}+");
	}

	/**
	 * ファイルの拡張子をチェックします。
	 *
	 * @param file
	 *            ファイル
	 * @param extensions
	 *            対応する拡張子
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
	 * @param propertyName
	 *            プロパティ名
	 * @param file
	 *            ファイル
	 * @param extensions
	 *            対応する拡張子
	 * @param messages
	 *            メッセージ
	 * @param itemName
	 *            項目名（表示文字列）
	 */
	public static void isExtensionChk(String propertyName, MultipartFile file, String[] extensions, Errors errors,
			String itemName) {
		if (!isExtension(file, extensions)) {
			errors.rejectValue(propertyName, "errors.isextension", new Object[]{propertyName}, "");
		}
	}

	/**
	 * ファイルサイズをチェックします。
	 *
	 * @param file
	 *            ファイル
	 * @param maxSize
	 *            最大のファイルサイズ（バイト）
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
	 * @param propertyName
	 *            プロパティ名
	 * @param file
	 *            ファイル
	 * @param maxSize
	 *            最大のファイルサイズ（バイト）
	 * @param messages
	 *            メッセージ
	 * @param itemName
	 *            項目名（表示文字列）
	 */
	public static void maxFileSizeChk(String propertyName, MultipartFile file, long maxSize, Errors errors,
			String itemName) {
		if (!maxFileSize(file, maxSize)) {
		errors.rejectValue(propertyName, "errors.maxfilesize", new Object[]{propertyName}, "");
		}
	}

	/**
	 * 画像ファイルかどうかをチェックします。
	 *
	 * @param imageFile
	 *            画像ファイル
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
	 * @param propertyName
	 *            プロパティ名
	 * @param file
	 *            ファイル
	 * @param messages
	 *            メッセージ
	 * @param itemName
	 *            項目名（表示文字列）
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
