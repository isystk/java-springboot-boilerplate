import React, { useEffect, useState, FC } from 'react'
import { Form } from 'reactstrap'
import TextInput from '@/components/elements/TextInput'
import SubmitButton from '@/components/elements/SubmitButton'
import CSRFToken from '@/components/elements/CSRFToken'
import RequestToken from '@/components/elements/RequestToken'
import SessionAlert from '@/components/elements/SessionAlert'
import Box from '@/components/Box'
import Layout from '@/components/Layout'
import MainService from '@/services/main'
import { useParams } from 'react-router-dom'

type Props = {
  appRoot: MainService
}

const ResetForm: FC<Props> = ({ appRoot }) => {
  const [onetimeKey, setOnetimeKey] = useState<string>('')
  const { id } = useParams()

  useEffect(() => {
    if (!id) {
      return
    }
    setOnetimeKey(id)
  }, [id])

  return (
    <Layout appRoot={appRoot} title="パスワード変更">
      <main className="main">
        <Box title="パスワード変更" small={true}>
          <SessionAlert target="status" />
          <Form
            method="POST"
            action={`/password/reset/${onetimeKey}`}
            id="login-form"
          >
            <CSRFToken appRoot={appRoot} />
            <RequestToken />
            <TextInput
              identity="password"
              controlType="password"
              autoComplete="new-password"
              label="新しいパスワード"
              autoFocus={true}
            />
            <TextInput
              identity="passwordConfirmation"
              controlType="password"
              autoComplete="new-password"
              label="新しいパスワード(確認)"
            />
            <SubmitButton label="パスワードを変更する" />
          </Form>
        </Box>
      </main>
    </Layout>
  )
}

export default ResetForm
