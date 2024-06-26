import { createBrowserRouter, RouterProvider, Navigate } from 'react-router-dom'

import { Login } from '@/pages/auth/Login'
import { Signin } from '@/pages/auth/Signin'
import { Home } from '@/pages/Home'

import { useAuthStore } from '@/stores/authStore'

export const App = () => {
  const { token } = useAuthStore()

  const router = createBrowserRouter([
    {
      path: '/',
      element: token ? <Home /> : <Navigate replace to="/entrar" />,
    },
    {
      path: '/entrar',
      element: <Login />,
      index: true,
    },
    {
      path: '/cadastrar',
      element: <Signin />,
    },
  ])

  return (
    <>
      <RouterProvider router={router} />
    </>
  )
}
