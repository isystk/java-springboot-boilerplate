import {
  ModelInit,
  MutableModel,
  PersistentModelConstructor,
} from '@aws-amplify/datastore'

type UserMetaData = {
  readOnlyFields: 'createdAt' | 'updatedAt'
}

type PostMetaData = {
  readOnlyFields: 'createdAt' | 'updatedAt'
}

export declare class User {
  readonly id: string
  readonly token?: string | null
  readonly created_at?: string | null
  readonly updated_at?: string | null
  readonly Posts?: (Post | null)[] | null
  readonly createdAt?: string | null
  readonly updatedAt?: string | null

  constructor(init: ModelInit<User, UserMetaData>)

  static copyOf(
    source: User,
    mutator: (
      draft: MutableModel<User, UserMetaData>
    ) => MutableModel<User, UserMetaData> | void
  ): User
}

export declare class Post {
  readonly id: string
  readonly title?: string | null
  readonly description?: string | null
  readonly photo?: string | null
  readonly userID: string
  readonly createdAt?: string | null
  readonly updatedAt?: string | null
  readonly _version?: string | null
  readonly _deleted?: string | null

  constructor(init: ModelInit<Post, PostMetaData>)

  static copyOf(
    source: Post,
    mutator: (
      draft: MutableModel<Post, PostMetaData>
    ) => MutableModel<Post, PostMetaData> | void
  ): Post
}
