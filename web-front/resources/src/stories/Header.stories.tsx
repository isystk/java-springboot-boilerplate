import React from 'react'
import { MemoryRouter } from 'react-router'
import { storiesOf } from '@storybook/react'
import MainService from '@/services/main'
import Header from '@/components/Header'

storiesOf('commons/Header', module)
  .addDecorator((getStory) => <MemoryRouter>{getStory()}</MemoryRouter>)
  .add('Logout', () => {
    const appRoot = {
      auth: {
        name: '',
      },
    } as MainService
    return (
      <Header isMenuOpen={false} setMenuOpen={() => ({})} appRoot={appRoot} />
    )
  })
  .add('Logined', () => {
    const appRoot = {
      auth: {
        name: 'sample',
      },
    } as MainService
    return (
      <Header isMenuOpen={false} setMenuOpen={() => ({})} appRoot={appRoot} />
    )
  })
