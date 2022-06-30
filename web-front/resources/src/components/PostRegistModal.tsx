import * as Yup from 'yup'
import AddCircleIcon from '@material-ui/icons/AddCircle'
import ImageFile from '@/components/Input/ImageFile'
import MainService from '@/services/main'
import React, { VFC } from 'react'
import {
  Button,
  Grid,
  Typography,
  Modal,
  Paper,
  TextField,
  Fade,
  FormGroup,
  Container,
} from '@material-ui/core'
import { Formik, Form } from 'formik'
import { Post } from '@/services/models'
import CloseIcon from '@material-ui/icons/Close'

type Props = {
  open: boolean
  onClose: () => void
  appRoot: MainService
  post: Post | null
}

type Form = {
  title: string
  description: string
  photo: string
}

const PostRegistModal: VFC<Props> = ({ open, onClose, appRoot, post }) => {
  // フォームの初期値
  let initialValues = {
    title: '',
    description: '',
    photo: '',
  }
  if (post) {
    initialValues = {
      title: post.title ?? '',
      description: post.description ?? '',
      photo: post.photo ?? '',
    }
  }
  // フォームのバリデーション
  const validationSchema = Yup.object().shape({
    title: Yup.string().required('タイトルを入力してください。'),
    description: Yup.string().required('本文を入力してください。'),
    photo: Yup.string().required('写真を選択してください。'),
  })
  // フォームの送信
  const onSubmit = async (values: Form) => {
    if (post) {
      const newPost = { ...values, id: post.id } as Post
      await appRoot.post.updatePost(newPost)
    } else {
      const newPost = { ...values } as Post
      await appRoot.post.createPost(newPost)
    }
    onClose()
  }

  return (
    <Modal open={open} onClose={onClose} style={{ overflow: 'scroll' }}>
      <Container maxWidth="md">
        <Fade in={open}>
          <Paper style={{ marginTop: '25px' }}>
            <Formik
              initialValues={initialValues}
              validationSchema={validationSchema}
              onSubmit={onSubmit}
            >
              {({ values, errors, touched, handleChange, handleBlur }) => (
                <Form>
                  <Grid container justifyContent="flex-end">
                    <CloseIcon onClick={onClose} />
                  </Grid>
                  <Grid
                    container
                    spacing={3}
                    style={{ padding: '20px' }}
                    justifyContent="center"
                  >
                    <Grid item xs={12} sm={12} md={12}>
                      <FormGroup style={{ margin: 8 }}>
                        <Typography style={{ marginLeft: 8 }}>
                          タイトル
                        </Typography>
                        <TextField
                          fullWidth
                          margin="normal"
                          variant="outlined"
                          className="red-border"
                          type="text"
                          name="title"
                          value={values.title}
                          onChange={handleChange}
                          onBlur={handleBlur}
                          error={!!(touched.title && errors.title)}
                          helperText={errors.title}
                        />
                        <Typography style={{ marginLeft: 8 }}>本文</Typography>
                        <TextField
                          fullWidth
                          margin="normal"
                          multiline
                          rows={4}
                          InputLabelProps={{ shrink: true }}
                          variant="outlined"
                          type="text"
                          name="description"
                          value={values.description}
                          onChange={handleChange}
                          onBlur={handleBlur}
                          error={!!(touched.description && errors.description)}
                          helperText={errors.description}
                        />
                        <ImageFile label="写真" name="photo" />
                        <Grid
                          container
                          style={{ paddingTop: 30 }}
                          justify="center"
                          direction="row"
                        >
                          <Grid item>
                            <Button
                              variant="contained"
                              color="secondary"
                              type="submit"
                              startIcon={<AddCircleIcon />}
                            >
                              投稿
                            </Button>
                          </Grid>
                        </Grid>
                      </FormGroup>
                    </Grid>
                  </Grid>
                </Form>
              )}
            </Formik>
          </Paper>
        </Fade>
      </Container>
    </Modal>
  )
}

export default PostRegistModal
