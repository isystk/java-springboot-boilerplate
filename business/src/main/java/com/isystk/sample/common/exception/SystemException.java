package com.isystk.sample.common.exception;

/**
 * アプリケーション内部で発生した例外を catch & throw するための実行時例外です。
 */
public class SystemException extends RuntimeException {

  private static final long serialVersionUID = 8462188377363105093L;

  /**
   * @param message この例外に関する詳細な情報.
   * @param cause   原因となった例外
   */
  public SystemException(String message, Throwable cause) {
    super(message, cause);
    if ((message == null || message.trim().length() == 0) && cause == null) {
      throw new IllegalArgumentException("Either of message or cause must be not null.");
    }
  }

  /**
   * メッセージを指定するコンストラクタ。
   *
   * @param message メッセージ
   */
  public SystemException(String message) {
    super(message);
  }

  /**
   * 根源の例外を指定するコンストラクタ。
   *
   * @param cause 根源の例外
   */
  public SystemException(Throwable cause) {
    super(cause);
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Throwable#toString()
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder(getClass().getName());

    if (getCause() != null) {
      sb.append(": ").append(getCause().getClass().getName());
    }

    String message = getLocalizedMessage();
    if (message != null) {
      sb.append(": ").append(message);
    }

    return sb.toString();
  }
}
