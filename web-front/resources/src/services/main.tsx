import Auth from '@/services/auth'
import Post from '@/services/post'

export default class MainService {
  _setAppRoot: (appRoot: MainService) => void

  auth: Auth
  post: Post

  constructor(setAppRoot: (appRoot: MainService) => void) {
    this._setAppRoot = setAppRoot
    this.auth = new Auth(this)
    this.post = new Post(this)
  }

  async setAppRoot() {
    await this._setAppRoot(this)
  }
}
