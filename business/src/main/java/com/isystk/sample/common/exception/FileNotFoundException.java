package com.isystk.sample.common.exception;

/**
 * ファイル不存在エラー
 */
public class FileNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -6212475941372852475L;

	/**
	 * コンストラクタ
	 */
	public FileNotFoundException(String message) {
		super(message);
	}

	/**
	 * コンストラクタ
	 */
	public FileNotFoundException(Exception e) {
		super(e);
	}
}
