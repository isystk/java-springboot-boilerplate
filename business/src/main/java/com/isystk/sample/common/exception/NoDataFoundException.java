package com.isystk.sample.common.exception;

/**
 * データ不存在エラー
 */
public class NoDataFoundException extends RuntimeException {

	private static final long serialVersionUID = -3553226048751584224L;

	/**
	 * コンストラクタ
	 */
	public NoDataFoundException(String message) {
		super(message);
	}

	/**
	 * コンストラクタ
	 */
	public NoDataFoundException(Exception e) {
		super(e);
	}
}
