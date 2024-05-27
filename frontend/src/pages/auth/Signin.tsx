import { useState } from "react"
import { useNavigate } from "react-router-dom"

import { z } from "zod"
import { zodResolver } from "@hookform/resolvers/zod"
import { useForm } from "react-hook-form"

import { Label } from "@/components/ui/label"
import { Input } from "@/components/ui/input"
import { Button } from "@/components/ui/button"
import { toast } from "@/components/ui/use-toast"
import { Spinner } from "@/components/ui/spinner"

import { userRegister } from "@/services/userAuth"

const SigninSchema = z.object({
  email: z.string().email(),
  password: z.string().min(4),
  passwordConfirm: z.string().min(4)
}).superRefine(({password, passwordConfirm}, ctx) => {
  if (passwordConfirm !== password) {
    ctx.addIssue({
      code: 'custom',
      message: 'As senhas não coincidem.',
      path: ['passwordConfirm']
    })
  }
})

type SigninUserSchema = z.infer<typeof SigninSchema>

export const Signin = () => {
  const [loading, setLoading] = useState<boolean>(false)
  const navigate  = useNavigate()

  const { register, handleSubmit } = useForm<SigninUserSchema>({
    resolver: zodResolver(SigninSchema)
  })

  const handleSignIn = async (data: SigninUserSchema) => {
    setLoading(true)
    const success = await userRegister(data)
    setLoading(false)

    if (!success) {
      toast({ variant: "destructive", title: "Erro", description: "Aconteceu algo inesperado..."})
    }

    toast({title: "Sucesso.", description: "Cadastro realizado com sucesso!"})

    navigate("/entrar")
  }

  return (
    <div className="flex h-screen items-center justify-center">
      <div className="mx-auto max-w-md space-y-6">
        <div className="space-y-2 text-center">
          <h1 className="text-3xl font-bold">Crie sua conta!</h1>
          <p className="text-gray-500 dark:text-gray-400">Entre com email e senha para se cadastrar.</p>
        </div>
        <form onSubmit={handleSubmit(handleSignIn)}>
          <div className="space-y-4">
            <div className="space-y-2">
              <Label htmlFor="email">Email</Label>
              <Input {...register('email')} id="email" placeholder="nome@gmail.com" required type="email" />
            </div>
            <div className="space-y-2">
              <Label htmlFor="password">Senha</Label>
              <Input {...register('password')} id="password" placeholder="Senha" required type="password" />
            </div>
            <div className="space-y-2">
              <Label htmlFor="confirm-password">Confirme a senha</Label>
              <Input {...register('passwordConfirm')} id="confirm-password" placeholder="Confirme a senha" required type="password" />
            </div>
            {loading ?
              <Spinner size="medium" >Carregando...</Spinner>
              :
              <Button className="w-full" type="submit">
                  Cadastre-se
                </Button>
              }
          </div>
        </form>
      </div>
    </div>
  )
}