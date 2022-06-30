import React from 'react'
import { Navigate } from 'react-router-dom'
import useAppRoot from '@/stores/useAppRoot'

type Props = {
  component: React.ReactNode
  redirect: string
}

export const RouteAuthGuard: React.VFC<Props> = (props) => {
  const appRoot = useAppRoot()

  if (!appRoot.auth.name) {
    return <Navigate to={props.redirect} />
  }

  return <>{props.component}</>
}
