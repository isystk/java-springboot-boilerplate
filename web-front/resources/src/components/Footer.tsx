import React, { VFC } from 'react'
import { Url } from '@/constants/url'
import { Link } from 'react-router-dom'

const CommonFooter: VFC = () => (
  <footer className="App-footer">
    <strong>
      Copyright &copy; 2021-2022 <Link to={Url.Top}>isystk.com</Link>.
    </strong>{' '}
    All rights reserved.
  </footer>
)

export default CommonFooter
