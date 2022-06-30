import React from 'react'
import { MemoryRouter } from 'react-router'
import { storiesOf } from '@storybook/react'
import Logo from '@/components/Logo'

storiesOf('commons/Logo', module)
  .addDecorator((getStory) => <MemoryRouter>{getStory()}</MemoryRouter>)
  .add('default', () => <Logo />)
