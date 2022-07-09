/** API のエンドポイント */
export const Url = {
  /** TOP */
  TOP: '/',
  /** ログイン */
  LOGIN: '/login',
  /** ログイン処理 */
  AUTHENTICATE: '/auth/authenticate',
  /** Googleログイン */
  AUTH_GOOGLE: '/auth/google',
  /** ログアウト */
  LOGOUT: '/auth/logout',
  /** 会員登録 */
  REGISTER: '/register',
  /** 仮会員登録 */
  REGISTER_SENDMAIL: '/register/sendMail',
  /** 会員登録完了 */
  REGISTER_COMPLETE: '/register/complete',
  /** パスワード変更 */
  PASSWORD_RESET: '/password/reset',
  /** パスワード変更メール送信完了 */
  PASSWORD_RESET_SENDMAIL: '/password/reset/sendMail',
  /** パスワード変更完了 */
  PASSWORD_RESET_COMPLETE: '/password/reset/complete',
  /** メールアドレス認証 */
  EMAIL_VERIFY: '/email/verify',
  /** ユーザーHOME */
  HOME: '/home',
  /** お問い合わせ */
  CONTACT: '/contact',
  /** お問い合わせ完了 */
  CONTACT_COMPLETE: '/contact/complete',
  /** マイカート */
  MYCART: '/mycart',
  /** 購入完了 */
  SHOP_COMPLETE: '/complete',
}
