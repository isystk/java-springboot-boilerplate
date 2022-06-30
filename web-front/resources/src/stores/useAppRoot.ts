import { useEffect } from 'react'
import { useSelector, useDispatch } from 'react-redux'
import MainService from '@/services/main'
import { forceRender, setAppRoot } from '.'

interface IRootState {
  app: App
}

type App = {
  root: MainService
}

const useAppRoot = () => {
  const dispatch = useDispatch()
  const { root } = useSelector<IRootState, App>((state) => state.app)
  // const [, forceRender] = useReducer((boolean) => !boolean, false)

  const _setAppRoot = async (appRoot: MainService) => {
    await dispatch(setAppRoot(appRoot))
    // forceRender()
    await dispatch(forceRender())
  }

  useEffect(() => {
    const init = async () => {
      const _appRoot = new MainService(_setAppRoot)
      await _appRoot.setAppRoot()
    }
    if (!root) {
      init()
    }
  }, [])

  return root
}

export default useAppRoot
