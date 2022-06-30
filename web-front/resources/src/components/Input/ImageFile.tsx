import React, { useState, VFC } from 'react'
import { Field } from 'formik'
import { CardMedia, Grid } from '@material-ui/core'
import ReactImageBase64 from 'react-image-base64'
import NoImage from '@/assets/images/no_image.png'
import { makeStyles } from '@material-ui/core/styles'

type Props = {
  label: string
  name: string
}

const useStyles = makeStyles(() => ({
  media: {
    backgroundImage: `url(${NoImage})`,
    border: 'solid 1px #666',
    height: '37vh',
    width: '37vh',
    display: 'flex',
    marginLeft: '10px',
    marginTop: '10px',
  },
}))

export const ImageFileInput: VFC<Props> = ({ label, name, ...rest }) => {
  const classes = useStyles()
  const [photoErrors, setPhotoErrors] = useState<string[]>([])

  return (
    <div className="form-control">
      <p>{label}</p>
      <Grid item container spacing={1} justifyContent="center">
        <Grid item xs={12} sm={6} md={6}>
          <Field name={name} {...rest}>
            {
              // @ts-ignore
              ({ form }) => {
                const { setFieldValue, errors } = form
                return (
                  <>
                    <ReactImageBase64
                      maxFileSize={10485760}
                      thumbnail_size={100}
                      drop={true}
                      dropText="写真をドラッグ＆ドロップもしくは"
                      capture="environment"
                      multiple={false}
                      handleChange={(data) => {
                        if (data.result) {
                          setFieldValue('photo', data.fileData)
                        } else {
                          setPhotoErrors([...photoErrors, ...data.messages])
                        }
                      }}
                    />
                    <p className="error">{errors.photo}</p>
                    {photoErrors.map((error, index) => (
                      <p className="error" key={index}>
                        {error}
                      </p>
                    ))}
                  </>
                )
              }
            }
          </Field>
        </Grid>
        <Grid item xs={12} md={6}>
          <Field name={name} {...rest}>
            {
              // @ts-ignore
              ({ form }) => {
                const { values } = form
                return (
                  <CardMedia
                    className={classes.media}
                    image={values.photo || NoImage}
                    title="Contemplative Reptile"
                  />
                )
              }
            }
          </Field>
        </Grid>
      </Grid>
    </div>
  )
}

export default ImageFileInput
