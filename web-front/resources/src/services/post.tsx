import MainService from '@/services/main'
import { Post } from '@/services/models'
import * as _ from 'lodash'

export type Posts = {
  [id: string]: Post
}

export default class PostService {
  main: MainService

  posts: Posts

  constructor(main: MainService) {
    this.main = main
    this.posts = {}
  }

  async listPosts() {
    //     this.main.auth.useAuthTypeApiKey()
    //     const postData = (await API.graphql(
    //       graphqlOperation(listPosts)
    //     )) as GraphQLResult
    //     const filterPosts = _.filter(
    //       // @ts-ignore
    //       postData.data.listPosts.items,
    //       (post) => !post._deleted
    //     )
    //     this.posts = _.mapKeys(filterPosts, 'id')
    //     await this.main.setAppRoot()
  }

  listMyPosts(): Post[] {
    if (!this.main.auth.id) return []
    return _.filter(this.posts, (post) => post.userID === this.main.auth.id)
  }

  async getPost(id: string) {
    console.log('getPost', id)
    //     this.main.auth.useAuthTypeApiKey()
    //     const postData = await API.graphql(graphqlOperation(getPost, { id }))
    //     // @ts-ignore
    //     this.posts[id] = postData.data.getPost
    //     await this.main.setAppRoot()
  }

  async createPost(post: Post) {
    console.log('createPost', post)
    try {
      //       const input = {
      //         ...post,
      //         userID: this.main.auth.id,
      //       }
      //       this.main.auth.useAuthTypeCognito()
      //       await API.graphql(
      //         graphqlOperation(createPost, { input }, this.main.auth.token)
      //       )
      //       await this.listPosts()
    } catch (error) {
      console.log('error create post', error)
      alert('登録に失敗しました')
    }
  }

  async updatePost(post: Post) {
    console.log('updatePost', post)
    try {
      //       const input = {
      //         ...post,
      //         userID: this.main.auth.id,
      //         _version: this.posts[post.id]._version,
      //       }
      //       this.main.auth.useAuthTypeCognito()
      //       await API.graphql(
      //         graphqlOperation(updatePost, { input }, this.main.auth.token)
      //       )
      //       await this.listPosts()
    } catch (error) {
      console.log('error update post', error)
      alert('更新に失敗しました')
    }
  }

  async deletePost(postId: string) {
    console.log('deletePost', postId)
    try {
      //       const input = {
      //         id: postId,
      //         _version: this.posts[postId]._version,
      //       }
      //       this.main.auth.useAuthTypeCognito()
      //       await API.graphql(
      //         graphqlOperation(deletePost, { input }, this.main.auth.token)
      //       )
      //       await this.listPosts()
    } catch (error) {
      console.log('error delete post', error)
      alert('削除に失敗しました')
    }
  }
}
