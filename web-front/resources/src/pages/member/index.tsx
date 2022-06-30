import React, { useEffect, useState, VFC } from 'react'
import Layout from '@/components/Layout'
import MainService from '@/services/main'
import { Post } from '@/services/models'
import {
  Breadcrumbs,
  Button,
  CardMedia,
  Grid,
  Paper,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Typography,
} from '@material-ui/core'
import PostRegistModal from '@/components/PostRegistModal'
import * as _ from 'lodash'
import NoImage from '@/assets/images/no_image.png'
import AddCircleIcon from '@material-ui/icons/AddCircle'
import EditIcon from '@material-ui/icons/Edit'
import DeleteIcon from '@material-ui/icons/Delete'
import { Link } from 'react-router-dom'
import { Url } from '@/constants/url'
import { makeStyles } from '@material-ui/core/styles'
import Pagination from '@material-ui/lab/Pagination'
import { flushSync } from 'react-dom'

const useStyles = makeStyles((theme) => ({
  list: {
    width: '100%',
    maxWidth: 360,
    backgroundColor: theme.palette.background.paper,
  },
  pagenation: {
    '& > *': {
      marginTop: theme.spacing(2),
      display: 'inline-block',
    },
  },
}))

type Props = {
  appRoot: MainService
}

const Index: VFC<Props> = ({ appRoot }) => {
  const [open, setOpen] = useState(false)
  const [selectPost, setSelectPost] = useState<Post | null>(null)

  const classes = useStyles()

  const [page, setPage] = useState(1) //ページ番号
  const [pageCount, setPageCount] = useState<number>() //ページ数
  const [allItems, setAllItems] = useState<Post[]>([]) //全データ
  const [displayedItems, setDisplayedItems] = useState<Post[]>([]) //表示データ
  const displayNum = 3 //1ページあたりの項目数

  useEffect(() => {
    // 投稿一覧を取得する
    appRoot.post.listPosts()
  }, [])

  useEffect(() => {
    if (!appRoot.post.posts) return
    flushSync(() => {
      const items = appRoot.post.listMyPosts()
      setAllItems(items)
      //ページカウントの計算（今回は3項目/ページなので4ページ）
      setPageCount(Math.ceil(items.length / displayNum))
      //表示データを抽出
      setDisplayedItems(items.slice((page - 1) * displayNum, page * displayNum))
    })
  }, [appRoot.post.posts])

  // 投稿の削除
  const onDeleteSubmit = async (post: Post) => {
    await appRoot.post.deletePost(post.id)
  }

  return (
    <Layout title="マイページ">
      <Grid container style={{ padding: '20px' }}>
        <Grid item xs={12} style={{ marginBottom: '20px' }}>
          <Grid container justify="space-between">
            <Grid item>
              <Breadcrumbs aria-label="breadcrumb">
                <Link color="inherit" to={Url.Top}>
                  TOP
                </Link>
                <Typography color="primary">マイページ</Typography>
              </Breadcrumbs>
            </Grid>
            <Grid item>
              <Button
                color="primary"
                type="button"
                variant="contained"
                startIcon={<AddCircleIcon />}
                onClick={() => setOpen(true)}
              >
                新規登録
              </Button>
              {/* Modal */}
              <PostRegistModal
                open={open}
                onClose={() => {
                  setSelectPost(null)
                  setOpen(false)
                }}
                appRoot={appRoot}
                post={selectPost}
              />
            </Grid>
          </Grid>
        </Grid>
        <Grid item xs={12}>
          <TableContainer component={Paper} style={{ marginBottom: 30 }}>
            {/* componentにライブラリのPaperをつけることで立体感がでてよくなります */}
            <Table>
              <TableHead>
                <TableRow style={{ backgroundColor: '#F2F2F2' }}>
                  <TableCell align="center">タイトル</TableCell>
                  <TableCell align="center">本文</TableCell>
                  <TableCell align="center">写真</TableCell>
                  <TableCell align="center"></TableCell>
                </TableRow>
              </TableHead>
              <TableBody>
                {appRoot.post &&
                  _.map(displayedItems, (row: Post) => (
                    <TableRow key={row.id}>
                      <TableCell>{row.title}</TableCell>
                      <TableCell>{row.description}</TableCell>
                      <TableCell align="center">
                        <CardMedia
                          style={{ width: 100, height: 100, display: 'flex' }}
                          image={row.photo || NoImage}
                          title="Contemplative Reptile"
                        />
                      </TableCell>
                      <TableCell align="center">
                        <Grid container spacing={1}>
                          <Grid item xs={12}>
                            <Button
                              variant="contained"
                              color="primary"
                              type="submit"
                              startIcon={<EditIcon />}
                              onClick={() => {
                                setSelectPost(row)
                                setOpen(true)
                              }}
                            >
                              変更
                            </Button>
                          </Grid>
                          <Grid item xs={12}>
                            <Button
                              variant="contained"
                              color="secondary"
                              type="submit"
                              startIcon={<DeleteIcon />}
                              onClick={async () => {
                                if (confirm('削除します。よろしいですか？'))
                                  await onDeleteSubmit(row)
                              }}
                            >
                              削除
                            </Button>
                          </Grid>
                        </Grid>
                      </TableCell>
                    </TableRow>
                  ))}
              </TableBody>
            </Table>
          </TableContainer>
          <div className={classes.pagenation} style={{ textAlign: 'center' }}>
            <Pagination
              count={pageCount}
              page={page}
              variant="outlined"
              color="primary"
              size="small"
              onChange={(_event, index) => {
                //ページ移動時にページ番号を更新
                setPage(index)
                //ページ移動時に表示データを書き換える
                setDisplayedItems(
                  allItems.slice((index - 1) * displayNum, index * displayNum)
                )
              }}
            />
          </div>
        </Grid>
      </Grid>
    </Layout>
  )
}

export default Index
