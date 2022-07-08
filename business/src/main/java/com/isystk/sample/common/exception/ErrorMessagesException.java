package com.isystk.sample.common.exception;

/**
 * エラーメッセージ Exception
 */
public class ErrorMessagesException extends RuntimeException {

  private static final long serialVersionUID = -3553226048751584224L;

  /**
   * コンストラクタ
   */
  public ErrorMessagesException(String message) {
    super(message);
  }

  /**
   * コンストラクタ
   */
  public ErrorMessagesException(Exception e) {
    super(e);
  }
}
