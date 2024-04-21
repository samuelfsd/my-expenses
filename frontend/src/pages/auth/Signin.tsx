
import { Label } from "@/components/ui/label"
import { Input } from "@/components/ui/input"
import { Button } from "@/components/ui/button"

export const Signin = () => {
  return (
    <div className="flex h-screen items-center justify-center">
      <div className="mx-auto max-w-md space-y-6">
        <div className="space-y-2 text-center">
          <h1 className="text-3xl font-bold">Crie sua conta!</h1>
          <p className="text-gray-500 dark:text-gray-400">Entre com email e senha para se cadastrar.</p>
        </div>
        <div className="space-y-4">
          <div className="space-y-2">
            <Label htmlFor="email">Email</Label>
            <Input id="email" placeholder="nome@gmail.com" required type="email" />
          </div>
          <div className="space-y-2">
            <Label htmlFor="password">Senha</Label>
            <Input id="password" placeholder="Senha" required type="password" />
          </div>
          <div className="space-y-2">
            <Label htmlFor="confirm-password">Confirme a senha</Label>
            <Input id="confirm-password" placeholder="Confirme a senha" required type="password" />
          </div>
          <Button className="w-full" type="submit">
            Cadastre-se
          </Button>
        </div>
      </div>
    </div>
  )
}