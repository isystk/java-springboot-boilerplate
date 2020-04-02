package com.isystk.sample.common.values;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 性別
 */
@Getter
@AllArgsConstructor
public enum Sex implements Values {

	WOMAN(1, "女性"),
	MAN(2, "男性")
	;

    private Sex(int code, String text) {
        this.code = code;
        this.text = text;
    }

	private final Integer code;
	private final String text;

}