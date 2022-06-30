import React, { lazy, Suspense, useEffect } from 'react'
import { BrowserRouter, Route, Routes } from 'react-router-dom'

import { Url } from '@/constants/url'
const Top = lazy(() => import('@/pages/Top'))
const PostIndex = lazy(() => import('@/pages/post/[id]'))
const SignIn = lazy(() => import('@/pages/signin'))
const SignUp = lazy(() => import('@/pages/signup'))
const Member = lazy(() => import('@/pages/member'))
const NotFound = lazy(() => import('@/pages/NotFound'))
import useAppRoot from '@/stores/useAppRoot'
import { RouteAuthGuard } from '@/auth/RouteAuthGuard'

function App() {
  const appRoot = useAppRoot()

  useEffect(() => {
    if (!appRoot) return
    ;(async () => {
      // ログインチェック
      await appRoot.auth.signCheck()
    })()
  }, [appRoot])

  if (!appRoot) return <></>

  return (
    <BrowserRouter>
      <Suspense fallback={<p>Loading...</p>}>
        <Routes>
          <Route index element={<Top appRoot={appRoot} />} />
          <Route
            path="/post/:postId"
            element={<PostIndex appRoot={appRoot} />}
          />
          <Route path={Url.SignIn} element={<SignIn appRoot={appRoot} />} />
          <Route path={Url.SignUp} element={<SignUp appRoot={appRoot} />} />

          {/* ★ログインユーザー専用ここから */}
          <Route
            path={Url.Member}
            element={
              <RouteAuthGuard
                component={<Member appRoot={appRoot} />}
                redirect={Url.SignIn}
              />
            }
          />
          {/* ★ログインユーザー専用ここまで */}

          <Route path="*" element={<NotFound />} />
        </Routes>
      </Suspense>
    </BrowserRouter>
  )
}

export default App
