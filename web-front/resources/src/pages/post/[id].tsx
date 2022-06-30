import React, { useEffect, VFC } from 'react'

import Layout from '@/components/Layout'
import { Link, useParams } from 'react-router-dom'
import { makeStyles } from '@material-ui/core/styles'
import MainService from '@/services/main'
import { Breadcrumbs, CardMedia, Grid, Typography } from '@material-ui/core'
import NoImage from '@/assets/images/no_image.png'
import { Url } from '@/constants/url'

const useStyles = makeStyles(() => ({
  main: {},
  root: {},
  media: {
    width: '100%',
  },
}))

type Props = {
  appRoot: MainService
}

const PostIndex: VFC<Props> = ({ appRoot }) => {
  const classes = useStyles()
  const { postId } = useParams()

  useEffect(() => {
    if (!postId) {
      return
    }
    // 投稿を取得する
    appRoot.post.getPost(postId)
  }, [postId])

  if (!appRoot.post) return <></>

  const post = appRoot.post.posts[postId + '']
  if (!post) return <></>

  return (
    <Layout title={post.title || ''}>
      <Grid container style={{ padding: '20px' }}>
        <Grid item xs={12} style={{ marginBottom: '20px' }}>
          <Breadcrumbs aria-label="breadcrumb">
            <Link color="inherit" to={Url.Top}>
              TOP
            </Link>
            <Typography color="primary">{post.title}</Typography>
          </Breadcrumbs>
        </Grid>
        <Grid item xs={12}>
          <Typography variant="h1">{post.title}</Typography>
          <CardMedia
            component="img"
            className={classes.media}
            image={post.photo || NoImage}
            title="Contemplative Reptile"
          />
          <Typography style={{ marginBottom: '25px' }}>
            {post.description}
          </Typography>
        </Grid>
      </Grid>
    </Layout>
  )
}

export default PostIndex
