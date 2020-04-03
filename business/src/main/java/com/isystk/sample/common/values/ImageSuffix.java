package com.isystk.sample.common.values;

import lombok.Getter;

/**
 * 保存する画像サイズ
 */
@Getter
public enum ImageSuffix implements Values {

	SQUARE("_square", 900, 900),
	SD("_sd", 900, 675),
	;

	private ImageSuffix(String suffix, int width, int height) {
		this.suffix = suffix;
		this.width = width;
		this.height = height;
	}

	private final String suffix;
	private final int width;
	private final int height;

}