package com.isystk.sample.common.values;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 都道府県
 */
@Getter
@AllArgsConstructor
public enum Prefecture implements Values {

    HOKKAIDO    (1, "北海道"),
    AOMORI      (2, "青森県"),
    IWATE       (3, "岩手県"),
    MIYAGI      (4, "宮城県"),
    AKITA       (5, "秋田県"),
    YAMAGATA    (6, "山形県"),
    FUKUSHIMA   (7, "福島県"),
    IBARAKI     (8, "茨城県"),
    TOCHIGI     (9, "栃木県"),
    GUNMA       (10, "群馬県"),
    SAITAMA     (11, "埼玉県"),
    CHIBA       (12, "千葉県"),
    TOKYO       (13, "東京都"),
    KANAGAWA    (14, "神奈川県"),
    NIIGATA     (15, "新潟県"),
    TOYAMA      (16, "富山県"),
    ISHIKAWA    (17, "石川県"),
    FUKUI       (18, "福井県"),
    YAMANASHI   (19, "山梨県"),
    NAGANO      (20, "長野県"),
    GIFU        (21, "岐阜県"),
    SHIZUOKA    (22, "静岡県"),
    AICHI       (23, "愛知県"),
    MIE         (24, "三重県"),
    SHIGA       (25, "滋賀県"),
    KYOTO       (26, "京都府"),
    OSAKA       (27, "大阪府"),
    HYOGO       (28, "兵庫県"),
    NARA        (29, "奈良県"),
    WAKAYAMA    (30, "和歌山県"),
    TOTTORI     (31, "鳥取県"),
    SHIMANE     (32, "島根県"),
    OKAYAMA     (33, "岡山県"),
    HIROSHIMA   (34, "広島県"),
    YAMAGUCHI   (35, "山口県"),
    TOKUSHIMA   (36, "徳島県"),
    KAGAWA      (37, "香川県"),
    EHIME       (38, "愛媛県"),
    KOCHI       (39, "高知県"),
    FUKUOKA     (40, "福岡県"),
    SAGA        (41, "佐賀県"),
    NAGASAKI    (42, "長崎県"),
    KUMAMOTO    (43, "熊本県"),
    OITA        (44, "大分県"),
    MIYAZAKI    (45, "宮崎県"),
    KAGOSHIMA   (46, "鹿児島県"),
    OKINAWA     (47, "沖縄県"),
    ;

	private Prefecture(int code, String text) {
		this.code = code;
		this.text = text;
	}

	private final Integer code;
	private final String text;

	/**
	 * コードに一致する値を取得します。
	 * @param code
	 * @return
	 */
	public static Prefecture getValue(Integer code) {
		if (code == null) {
			return null;
		}
		for (Prefecture div : values()) {
			if (div.getCode().equals(code)) {
				return div;
			}
		}
		return null;
	}
}