
import { Link, redirect } from "react-router-dom"

import { CardTitle, CardDescription, CardHeader, CardContent, CardFooter, Card } from "@/components/ui/card"
import { Label } from "@/components/ui/label"
import { Input } from "@/components/ui/input"
import { Button } from "@/components/ui/button"

import { useForm } from 'react-hook-form'
import { z } from 'zod'
import { zodResolver } from '@hookform/resolvers/zod'
import loginUser from "@/services/loginUser"

const LoginSchema = z.object({
  email: z.string().email(),
  password: z.string().min(4)
})

type LoginUserSchema = z.infer<typeof LoginSchema>

export const Login = () => {
  const { register, handleSubmit } = useForm<LoginUserSchema>({
    resolver: zodResolver(LoginSchema)
  })

  const handleLoginAccount = async (data: LoginUserSchema)  => {
    const loggedIn = await loginUser(data)

    if (loggedIn){
      return redirect("/dashboard")
    }
  }

  return (
    <div className="flex h-screen items-center justify-center bg-gray-100 dark:bg-gray-900">
      <div className="w-full max-w-md space-y-8">
        <div className="text-center">
          <h1 className="text-3xl font-bold tracking-tight text-gray-900 dark:text-gray-50">Bem vindo!</h1>
          <p className="mt-2 text-sm text-gray-600 dark:text-gray-400">Faça login para acessar sua conta!</p>
        </div>
        <Card>
          <form onSubmit={handleSubmit(handleLoginAccount)}>
          <CardHeader>
            <CardTitle className="text-2xl">Login</CardTitle>
            <CardDescription>Informe seu email e senha para entrar.</CardDescription>
          </CardHeader>
          <CardContent className="space-y-4">
            <div className="space-y-2">
              <Label htmlFor="email">Email</Label>
              <Input id="email" placeholder="nome@exemplo.com" required type="email" {...register('email')} />
            </div>
            <div className="space-y-2">
              <div className="flex items-center justify-between">
                <Label htmlFor="password">Senha</Label>
                {/* <Link
                  className="text-sm font-medium text-gray-600 hover:text-gray-900 dark:text-gray-400 dark:hover:text-gray-50"
                  to="#"
                >
                  Esqueceu a senha?
                </Link> */}
              </div>
              <Input id="password" required type="password" {...register('password')} />
            </div>
          </CardContent>
          <CardFooter>
            <Button className="w-full" type="submit">
              Entrar
            </Button>
          </CardFooter>
          </form>
        </Card>
        <p className="text-center text-sm text-gray-600 dark:text-gray-400">
          Não possuí uma conta?
          <Link
            className="font-medium text-gray-900 hover:text-gray-700 dark:text-gray-50 dark:hover:text-gray-300"
            to="/cadastrar"
          >
            Cadastre-se
          </Link>
        </p>
      </div>
    </div>
  )
}