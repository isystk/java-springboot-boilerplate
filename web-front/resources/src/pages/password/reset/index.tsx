import React, { FC } from 'react'
import { Form } from 'reactstrap'
import TextInput from '@/components/elements/TextInput'
import SubmitButton from '@/components/elements/SubmitButton'
import CSRFToken from '@/components/elements/CSRFToken'
import SessionAlert from '@/components/elements/SessionAlert'
import Box from '@/components/Box'
import Layout from '@/components/Layout'
import MainService from '@/services/main'

type Props = {
  appRoot: MainService
}

const ResetForm: FC<Props> = ({ appRoot }) => {
  return (
    <Layout appRoot={appRoot} title="パスワード変更">
      <main className="main">
        <Box title="パスワード変更" small={true}>
          <SessionAlert target="status" />
          <Form method="POST" action="/password/reset" id="login-form">
            <CSRFToken appRoot={appRoot} />
            <TextInput
              identity="email"
              controlType="email"
              label="メールアドレス"
              autoFocus={true}
            />
            <SubmitButton label="メールを送信する" />
          </Form>
        </Box>
      </main>
    </Layout>
  )
}

export default ResetForm
