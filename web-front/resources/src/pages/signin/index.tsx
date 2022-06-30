import React, { VFC, useEffect } from 'react'
import { useNavigate, Link } from 'react-router-dom'
import {
  Grid,
  Card,
  CardContent,
  CardActions,
  TextField,
  Button,
  FormGroup,
  InputLabel,
  Breadcrumbs,
  Typography,
} from '@material-ui/core'
import { Formik, Form } from 'formik'
import * as Yup from 'yup'
import { Url } from '@/constants/url'
import MainService from '@/services/main'
import Layout from '@/components/Layout'

type Props = {
  appRoot: MainService
}

type Form = {
  email: string
  password: string
}

const Index: VFC<Props> = ({ appRoot }) => {
  const navigate = useNavigate()

  useEffect(() => {
    if (appRoot.auth.name) {
      navigate(Url.Top)
    }
  }, [appRoot.auth.name])

  // フォームの初期値
  const initialValues = {
    email: '',
    password: '',
  }
  // フォームのバリデーション
  const validationSchema = Yup.object().shape({
    email: Yup.string().required('メールアドレスを入力してください。'),
    password: Yup.string().required('パスワードを入力してください。'),
  })
  // フォームの送信
  const onSubmit = async (values: Form) => {
    const { email, password } = values
    await appRoot.auth.signIn(email, password)
  }

  return (
    <Layout title="ログイン">
      <Grid container style={{ padding: '20px' }}>
        <Grid item xs={12} style={{ marginBottom: '20px' }}>
          <Breadcrumbs aria-label="breadcrumb">
            <Link color="inherit" to={Url.Top}>
              TOP
            </Link>
            <Typography color="primary">ログイン</Typography>
          </Breadcrumbs>
        </Grid>
        <Grid container justifyContent="center" spacing={1}>
          <Grid item xs={12} md={6}>
            <Card>
              <Formik
                initialValues={initialValues}
                validationSchema={validationSchema}
                onSubmit={onSubmit}
              >
                {({
                  isValid,
                  values,
                  errors,
                  touched,
                  handleChange,
                  handleBlur,
                }) => (
                  <Form>
                    <CardContent>
                      <Grid item container spacing={3} justifyContent="center">
                        <Grid item xs={12} sm={12} md={12}>
                          <FormGroup>
                            <InputLabel required>メールアドレス</InputLabel>
                            <TextField
                              type="text"
                              name="email"
                              value={values.email}
                              onChange={handleChange}
                              onBlur={handleBlur}
                              error={!!(touched.email && errors.email)}
                              helperText={errors.email}
                              margin="dense"
                            />
                          </FormGroup>
                        </Grid>
                        <Grid item xs={12} sm={12} md={12}>
                          <FormGroup>
                            <InputLabel required>パスワード</InputLabel>
                            <TextField
                              type="password"
                              name="password"
                              value={values.password}
                              onChange={handleChange}
                              onBlur={handleBlur}
                              error={!!(touched.password && errors.password)}
                              helperText={errors.password}
                              margin="dense"
                            />
                          </FormGroup>
                        </Grid>
                      </Grid>
                    </CardContent>
                    <CardActions>
                      <Grid item xs={12} sm={12} md={12}>
                        <Button
                          color="primary"
                          disabled={!isValid}
                          fullWidth
                          type="submit"
                          variant="contained"
                        >
                          ログインする
                        </Button>
                      </Grid>
                    </CardActions>
                  </Form>
                )}
              </Formik>
              <CardContent>
                <Grid item container spacing={1}>
                  <Grid item xs={12} sm={12} md={12}>
                    <Link to={Url.SignUp}>会員登録はこちら</Link>
                  </Grid>
                </Grid>
              </CardContent>
            </Card>
          </Grid>
        </Grid>
      </Grid>
    </Layout>
  )
}

export default Index
