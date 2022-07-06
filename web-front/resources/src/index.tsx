import './styles/app.scss'
import { composeWithDevTools } from 'redux-devtools-extension'
import { createStore, applyMiddleware } from 'redux'
import { Provider } from 'react-redux'
import Router from '@/router'
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider'
import React from 'react'
import ReactDOM from 'react-dom/client'
import reducers from '@/stores'
import reportWebVitals from '@/reportWebVitals'
import thunk from 'redux-thunk'
import { Session } from '@/services/auth'
import { API } from '@/utilities/api'
import { API_ENDPOINT } from '@/constants/api'

const render = (session: Session) => {
  // 開発環境の場合は、redux-devtools-extension を利用できるようにする
  const enhancer =
    process.env.NODE_ENV === 'development'
      ? composeWithDevTools(applyMiddleware(thunk))
      : applyMiddleware(thunk)
  const store = createStore(reducers, enhancer)

  console.log('session', session)
  const container = document.getElementById('root')
  if (container) {
    const root = ReactDOM.createRoot(container)
    root.render(
      <MuiThemeProvider>
        <Provider store={store}>
          <Router session={session} />
        </Provider>
      </MuiThemeProvider>
    )
  }
}

const init = () => {
  const url = API_ENDPOINT.SESSION
  const data = {
    _csrf:
      document
        .querySelector('meta[name="csrf-token"]')
        ?.getAttribute('content') || '',
  }
  API.post(url, data).then((response) => {
    render(response.data[0])
  })
}

// start
init()

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals()
