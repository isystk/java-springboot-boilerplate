import React, { VFC } from 'react'

import Layout from '@/components/Layout'
import MainService from '@/services/main'
import PostCards from '@/components/PostCards'

type Props = {
  appRoot: MainService
}

const Top: VFC<Props> = ({ appRoot }) => {
  return (
    <Layout title="TOP">
      <PostCards appRoot={appRoot} />
    </Layout>
  )
}

export default Top
