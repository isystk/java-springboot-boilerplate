import React, { FC, useState } from 'react'
import useAppRoot from '@/stores/useAppRoot'
import Header from '@/components/Header'
import Footer from '@/components/Footer'
import SideMenu from '@/components/SideMenu'
import { Helmet } from 'react-helmet'

type Props = {
  children?: React.ReactNode
  title: string
}

const Layout: FC<Props> = ({ children, title }) => {
  const appRoot = useAppRoot()
  const [isMenuOpen, setMenuOpen] = useState(false)

  return (
    <div className="App">
      <Helmet
        title={title + ' | amplify-reactjs-sample'}
        meta={[
          {
            name: 'description',
            content: 'AWS Amplify の学習用サンプルアプリケーションです。',
          },
        ]}
      />
      <Header
        isMenuOpen={isMenuOpen}
        setMenuOpen={setMenuOpen}
        appRoot={appRoot}
      />
      <div>{children}</div>
      <Footer />
      <SideMenu
        isMenuOpen={isMenuOpen}
        setMenuOpen={setMenuOpen}
        appRoot={appRoot}
      />
    </div>
  )
}

export default Layout
