import MainService from '@/services/main'
import { API } from '@/utilities/api'
import { API_ENDPOINT } from '@/constants/api'
import { Stock } from '@/services/shop'

type Carts = {
  data: Cart[]
  message: string
  username: string
  count: number
  sum: number
}

type Cart = {
  id: number
  stock_id: number
  user_id: number
  created_at: Date
  updated_at: Date
  stock: Stock
}

type Form = {
  amount: number
  username: string
}

const initialState: Carts = {
  data: [],
  message: '',
  username: '',
  count: 0,
  sum: 0,
}

export default class CartService {
  main: MainService
  carts: Carts

  constructor(main: MainService) {
    this.main = main
    this.carts = initialState
  }

  async readCarts() {
    // ローディングを表示する
    this.main.showLoading()
    try {
      const response = await API.post(API_ENDPOINT.MYCARTS)
      if (response.result) {
        this.carts = response.data[0]
      }
    } catch (e) {
      alert('マイカートの取得に失敗しました')
    }
    // ローディングを非表示にする
    this.main.hideLoading()
    this.main.setAppRoot()
  }

  async addCart(stockId: number): Promise<boolean> {
    let result = false
    // ローディングを表示する
    this.main.showLoading()
    try {
      const response = await API.post(API_ENDPOINT.MYCARTS_ADD, {
        stock_id: stockId,
      })
      if (response.result) {
        this.carts = response.data[0]
        result = true
      }
    } catch (e) {
      alert('マイカートの追加に失敗しました')
    }
    // ローディングを非表示にする
    this.main.hideLoading()
    this.main.setAppRoot()
    return result
  }

  async removeCart(cartId: number): Promise<boolean> {
    let result = false
    // ローディングを表示する
    this.main.showLoading()
    try {
      const response = await API.post(API_ENDPOINT.MYCARTS_REMOVE, {
        cart_id: cartId,
      })
      if (response.result) {
        this.carts = response.data[0]
        result = true
      }
    } catch (e) {
      alert('マイカートの削除に失敗しました')
    }
    // ローディングを非表示にする
    this.main.hideLoading()
    this.main.setAppRoot()
    return result
  }

  async payment(stripe, elements, values: Form): Promise<boolean> {
    let result = false
    // ローディングを表示する
    this.main.showLoading()
    try {
      //paymentIntentの作成を（ローカルサーバ経由で）リクエスト
      const response = await API.post(API_ENDPOINT.MYCARTS_PAYMENT, {
        amount: values.amount,
        username: values.username,
      })

      //レスポンスからclient_secretを取得
      const client_secret = response.data[0].client_secret

      //client_secretを利用して（確認情報をStripeに投げて）決済を完了させる
      const confirmRes = await stripe.confirmCardPayment(client_secret, {
        payment_method: {
          // @ts-ignore
          card: elements.getElement('cardNumber'),
          billing_details: {
            name: values.username,
          },
        },
      })

      if (
        confirmRes.data[0].paymentIntent &&
        confirmRes.data[0].paymentIntent.status === 'succeeded'
      ) {
        // 決算処理が完了したら、注文履歴に追加してマイカートから商品を削除する。
        const response = await API.post(API_ENDPOINT.MYCARTS_CHECKOUT, {})

        result = response.result
      }
    } catch (e) {
      alert('決算処理に失敗しました')
    }
    // ローディングを非表示にする
    this.main.hideLoading()
    this.main.setAppRoot()
    return result
  }
}
