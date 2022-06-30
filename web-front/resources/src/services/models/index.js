// @ts-check
import { initSchema } from '@aws-amplify/datastore'
import { schema } from './schema'

const { User, Post } = initSchema(schema)

export { User, Post }
