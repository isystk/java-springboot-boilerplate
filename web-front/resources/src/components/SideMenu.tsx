import React, { Dispatch, SetStateAction, VFC } from 'react'
import {
  Divider,
  Drawer,
  IconButton,
  List,
  ListItem,
  ListItemIcon,
  ListItemText,
} from '@material-ui/core'
import ChevronLeftIcon from '@material-ui/icons/ChevronLeft'
import LockOpenIcon from '@material-ui/icons/LockOpen'
import AccountCircleIcon from '@material-ui/icons/AccountCircle'
import { useNavigate } from 'react-router-dom'
import MainService from '@/services/main'
import { Url } from '@/constants/url'

type Props = {
  isMenuOpen: boolean
  setMenuOpen: Dispatch<SetStateAction<boolean>>
  appRoot: MainService
}

type Menus = {
  [text: string]: Menu
}

type Menu = [React.ReactNode, () => void, boolean]

const SideMenu: VFC<Props> = ({ isMenuOpen, setMenuOpen }) => {
  const navigate = useNavigate()

  const menu = {
    ログイン: [
      <LockOpenIcon key={0} />,
      () => {
        navigate(Url.SignIn)
        setMenuOpen(!isMenuOpen)
      },
      false,
    ],
    マイページ: [
      <AccountCircleIcon key={0} />,
      () => {
        navigate(Url.Member)
        setMenuOpen(!isMenuOpen)
      },
      false,
    ],
  } as Menus
  return (
    <Drawer
      anchor="right"
      open={isMenuOpen}
      onClose={() => setMenuOpen(!isMenuOpen)}
    >
      <div style={{ marginLeft: 'auto' }}>
        <IconButton onClick={() => setMenuOpen(!isMenuOpen)}>
          <ChevronLeftIcon />
        </IconButton>
      </div>
      <Divider />
      <List>
        {Object.keys(menu).map((key, index) => {
          const [icon, func, disabled] = menu[key]
          return (
            <ListItem button key={index} onClick={func} disabled={disabled}>
              <ListItemIcon>{icon}</ListItemIcon>
              <ListItemText primary={key} />
            </ListItem>
          )
        })}
      </List>
    </Drawer>
  )
}

export default SideMenu
