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
  /** パスワード忘れ */
  PASSWORD_RESET: '/password/reset',
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
