import * as React from 'react'
import { Url } from '@/constants/url'
import Layout from '@/components/Layout'
import { FC } from 'react'
import MainService from '@/services/main'
import { Link } from 'react-router-dom'

type Props = {
  appRoot: MainService
}

const ContactComplete: FC<Props> = ({ appRoot }) => {
  return (
    <Layout appRoot={appRoot} title="会員登録">
      <main className="main">
        <div className="contentsArea">
          <h2
            className="heading02"
            style={{
              color: '#555555',
              fontSize: '1.2em',
              padding: '24px 0px',
            }}
          >
            会員登録手続きが完了しました。
          </h2>

          <div className="ta-center">
            <p>
              会員専用ページへは、ログイン画面より、ご登録いただいたメールアドレスとパスワードを入力してログインしてください。
            </p>
            <Link to={Url.LOGIN} className="btn text-danger mt40">
              ログイン画面へ戻る
            </Link>
          </div>
        </div>
      </main>
    </Layout>
  )
}

export default ContactComplete
