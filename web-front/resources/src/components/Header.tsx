import React, { Dispatch, SetStateAction, useState, VFC } from 'react'
import {
  AppBar,
  Button,
  Grid,
  IconButton,
  Menu,
  MenuItem,
  Toolbar,
} from '@material-ui/core'
import MenuIcon from '@material-ui/icons/Menu'
import { makeStyles } from '@material-ui/core/styles'
import MainService from '@/services/main'
import Logo from '@/components/Logo'
import { useNavigate } from 'react-router-dom'
import { Url } from '@/constants/url'

type Props = {
  isMenuOpen: boolean
  setMenuOpen: Dispatch<SetStateAction<boolean>>
  appRoot: MainService
}

const useStyles = makeStyles(() => ({
  noTransform: {
    textTransform: 'none', // #1
  },
}))

const CommonHeader: VFC<Props> = ({ isMenuOpen, setMenuOpen, appRoot }) => {
  const navigate = useNavigate()
  const [anchorEl, setAnchorEl] = useState<
    (EventTarget & HTMLButtonElement) | null
  >(null)
  const classes = useStyles()

  return (
    <AppBar position="fixed" className="App-header">
      <Toolbar style={{ padding: 0 }}>
        <Grid container>
          <Logo />
        </Grid>

        <Grid container justifyContent="flex-end">
          {appRoot.auth.name && (
            <>
              <Button
                color="inherit"
                aria-owns={anchorEl ? 'user-menu' : undefined}
                aria-haspopup="true"
                onClick={(e) => setAnchorEl(e.currentTarget)}
                className={classes.noTransform}
              >
                {appRoot.auth.name} さん
              </Button>
              <Menu
                id="user-menu"
                anchorEl={anchorEl}
                open={Boolean(anchorEl)}
                onClick={() => setAnchorEl(null)}
              >
                <MenuItem
                  onClick={async () => {
                    await appRoot.auth.signOut()
                    navigate(Url.SignIn)
                  }}
                >
                  ログアウト
                </MenuItem>
              </Menu>
            </>
          )}
          <IconButton color="inherit" onClick={() => setMenuOpen(!isMenuOpen)}>
            <MenuIcon />
          </IconButton>
        </Grid>
      </Toolbar>
    </AppBar>
  )
}

export default CommonHeader
