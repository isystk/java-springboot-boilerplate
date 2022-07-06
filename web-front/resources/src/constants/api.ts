import Env from '@/constants/env'

/**
 * BFF（バックエンドフォーフロントエンド）用の URL を作成する
 * @param path
 */
const getBffUrl = (path: string): string => {
  const url = [Env.apiEndpointUrl, path].join('')
  return url
}

/** API のエンドポイント */
export const API_ENDPOINT = {
  /** ログイン状態チェック */
  SESSION: getBffUrl('/session'),
  /** ログイン */
  LOGIN: getBffUrl('/authenticate'),
  /** ログアウト */
  LOGOUT: getBffUrl('/logout'),
  /** 共通定数 */
  CONSTS: getBffUrl('/consts'),

  /** お気に入りデータ取得 */
  LIKES: getBffUrl('/likes'),
  /** お気に入り追加 */
  LIKES_STORE: getBffUrl('/likes/store'),
  /** お気に入り削除 */
  LIKES_DESTROY: getBffUrl('/likes/destroy'),

  /** お問い合わせ登録 */
  CONTACT_STORE: getBffUrl('/contact/store'),

  /** 商品一覧データ取得 */
  STOCKS: getBffUrl('/stocks'),
  /** マイカートデータ取得 */
  MYCARTS: getBffUrl('/mycarts'),
  /** カートに商品を追加する */
  MYCARTS_ADD: getBffUrl('/mycarts/add'),
  /** カートから商品を削除する */
  MYCARTS_REMOVE: getBffUrl('/mycarts/remove'),
  /** Stripe用のペイメント作成 */
  MYCARTS_PAYMENT: getBffUrl('/mycarts/payment'),
  /** 決算処理後の後処理 */
  MYCARTS_CHECKOUT: getBffUrl('/mycarts/checkout'),
}
