import { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'

import { z } from 'zod'
import { zodResolver } from '@hookform/resolvers/zod'
import { useForm } from 'react-hook-form'

import { Label } from '@/components/ui/label'
import { Input } from '@/components/ui/input'
import { Button } from '@/components/ui/button'
import { toast } from '@/components/ui/use-toast'
import { Spinner } from '@/components/ui/spinner'

import { userRegister } from '@/services/userAuth'
import { Card, CardContent } from '@/components/ui/card'

const SigninSchema = z
  .object({
    email: z.string().email(),
    password: z.string().min(4),
    passwordConfirm: z.string().min(4),
  })
  .superRefine(({ password, passwordConfirm }, ctx) => {
    if (passwordConfirm !== password) {
      ctx.addIssue({
        code: 'custom',
        message: 'As senhas não coincidem.',
        path: ['passwordConfirm'],
      })
    }
  })

type SigninUserSchema = z.infer<typeof SigninSchema>

export const Signin = () => {
  const [loading, setLoading] = useState<boolean>(false)
  const navigate = useNavigate()

  const { register, handleSubmit } = useForm<SigninUserSchema>({
    resolver: zodResolver(SigninSchema),
  })

  const handleSignIn = async (data: SigninUserSchema) => {
    setLoading(true)
    const success = await userRegister(data)
    setLoading(false)

    if (!success) {
      toast({
        variant: 'destructive',
        title: 'Erro',
        description: 'Aconteceu algo inesperado...',
      })
      return
    }

    toast({ title: 'Sucesso.', description: 'Cadastro realizado com sucesso!' })

    navigate('/entrar')
  }

  return (
    <div className="flex h-screen items-center justify-center  bg-gray-100 dark:bg-gray-900">
      <div className="mx-auto max-w-md space-y-8">
        <div className="space-y-2 text-center">
          <h1 className="text-3xl font-bold">Crie sua conta!</h1>
          <p className="text-gray-500 dark:text-gray-400">
            Entre com email e senha para se cadastrar.
          </p>
        </div>
        <Card>
          <form onSubmit={handleSubmit(handleSignIn)}>
            <CardContent className="space-y-4">
              <div className="space-y-4">
                <div className="space-y-2  mt-4">
                  <Label htmlFor="email">Email</Label>
                  <Input
                    {...register('email')}
                    id="email"
                    placeholder="nome@gmail.com"
                    required
                    type="email"
                  />
                </div>
                <div className="space-y-2">
                  <Label htmlFor="password">Senha</Label>
                  <Input
                    {...register('password')}
                    id="password"
                    placeholder="Senha"
                    required
                    type="password"
                  />
                </div>
                <div className="space-y-2">
                  <Label htmlFor="confirm-password">Confirme a senha</Label>
                  <Input
                    {...register('passwordConfirm')}
                    id="confirm-password"
                    placeholder="Confirme a senha"
                    required
                    type="password"
                  />
                </div>
                {loading ? (
                  <Spinner size="medium">Carregando...</Spinner>
                ) : (
                  <Button className="w-full" type="submit">
                    Cadastre-se
                  </Button>
                )}
              </div>
            </CardContent>
          </form>
        </Card>

        <p className="text-center text-sm text-gray-600 dark:text-gray-400">
          Já possuí uma conta? {''}
          <Link
            className="font-medium text-gray-900 hover:text-gray-700 dark:text-gray-50 dark:hover:text-gray-300"
            to="/entrar"
          >
            Entre
          </Link>
        </p>
      </div>
    </div>
  )
}
