import React from 'react'
import { BrowserRouter } from 'react-router-dom'
import renderer from 'react-test-renderer'
import Logo from '@/components/Logo'

test('Logo', () => {
  const component = renderer.create(
    <BrowserRouter>
      <Logo />
    </BrowserRouter>
  )
  expect(component).toMatchSnapshot()
})
