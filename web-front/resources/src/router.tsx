import React, { FC, Suspense, useEffect } from 'react'
import { BrowserRouter, Route, Routes } from 'react-router-dom'

import AuthCheck from '@/components/auths/AuthCheck'
import ContactComplete from '@/pages/contact/complete'
import ContactCreate from '@/pages/contact'
import Home from '@/pages/home'
import LoginForm from '@/pages/login'
import MyCart from '@/pages/mycart'
import NotFound from '@/pages/NotFound'
import RegisterForm from '@/pages/register'
import RegisterSendMailForm from '@/pages/register/sendMail'
import RegisterCompleteForm from '@/pages/register/complete'
import PasswordResetForm from '@/pages/password/reset'
import PasswordResetSendMailForm from '@/pages/password/reset/sendMail'
import PasswordResetInputForm from '@/pages/password/reset/[id]'
import PasswordResetCompleteForm from '@/pages/password/reset/complete'
import ShopComplete from '@/pages/complete'
import ShopTop from '@/pages'
import Verify from '@/pages/email/verify'
import { Url } from '@/constants/url'
import useAppRoot from '@/stores/useAppRoot'
import { Session } from '@/services/auth'

type Props = {
  session: Session
}

const Router: FC<Props> = ({ session }) => {
  const appRoot = useAppRoot()

  useEffect(() => {
    if (!appRoot) return
    // セッションのセット
    appRoot.auth.setSession(session)
    ;(async () => {
      // 定数のセット
      await appRoot.const.readConsts()
    })()

    // CSRFのセット
    const token = document.head.querySelector<HTMLMetaElement>(
      'meta[name="csrf-token"]'
    )
    if (token) {
      appRoot.auth.setCSRF(token.content)
    }
  }, [appRoot])

  if (!appRoot) return <></>

  return (
    <BrowserRouter>
      <Suspense fallback={<p>Loading...</p>}>
        <Routes>
          <Route index element={<ShopTop appRoot={appRoot} />} />
          <Route path={Url.LOGIN} element={<LoginForm appRoot={appRoot} />} />
          <Route
            path={Url.REGISTER}
            element={<RegisterForm appRoot={appRoot} />}
          />
          <Route
            path={Url.REGISTER_SENDMAIL}
            element={<RegisterSendMailForm appRoot={appRoot} />}
          />
          <Route
            path={Url.REGISTER_COMPLETE}
            element={<RegisterCompleteForm appRoot={appRoot} />}
          />
          <Route
            path={Url.PASSWORD_RESET}
            element={<PasswordResetForm appRoot={appRoot} />}
          />
          <Route
            path={Url.PASSWORD_RESET_SENDMAIL}
            element={<PasswordResetSendMailForm appRoot={appRoot} />}
          />
          <Route
            path={`${Url.PASSWORD_RESET}/:id`}
            element={<PasswordResetInputForm appRoot={appRoot} />}
          />
          <Route
            path={Url.PASSWORD_RESET_COMPLETE}
            element={<PasswordResetCompleteForm appRoot={appRoot} />}
          />
          <Route
            path={Url.EMAIL_VERIFY}
            element={<Verify appRoot={appRoot} />}
          />
          <Route
            path={Url.CONTACT}
            element={<ContactCreate appRoot={appRoot} />}
          />
          <Route
            path={Url.CONTACT_COMPLETE}
            element={<ContactComplete appRoot={appRoot} />}
          />

          {/* ★ログインユーザー専用ここから */}
          <Route
            path={Url.HOME}
            element={
              <AuthCheck
                session={session}
                component={<Home appRoot={appRoot} />}
              />
            }
          />
          <Route
            path={Url.MYCART}
            element={
              <AuthCheck
                session={session}
                component={<MyCart appRoot={appRoot} />}
              />
            }
          />
          <Route
            path={Url.SHOP_COMPLETE}
            element={
              <AuthCheck
                session={session}
                component={<ShopComplete appRoot={appRoot} />}
              />
            }
          />
          {/* ★ログインユーザー専用ここまで */}

          <Route path="*" element={<NotFound appRoot={appRoot} />} />
        </Routes>
      </Suspense>
    </BrowserRouter>
  )
}

export default Router
