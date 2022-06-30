import React from 'react'
import { MemoryRouter } from 'react-router'
import { storiesOf } from '@storybook/react'
import Footer from '@/components/Footer'

storiesOf('commons/Footer', module)
  .addDecorator((getStory) => <MemoryRouter>{getStory()}</MemoryRouter>)
  .add('default', () => <Footer />)
