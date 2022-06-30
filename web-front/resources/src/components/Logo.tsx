import React, { VFC } from 'react'
import { Link } from 'react-router-dom'
import { Url } from '@/constants/url'

const Logo: VFC = () => {
  const DEAULT_TITLE = 'amplify-reactjs-sample'

  return (
    <div className="App-logo">
      <Link to={Url.Top}>{DEAULT_TITLE}</Link>
    </div>
  )
}

export default Logo
