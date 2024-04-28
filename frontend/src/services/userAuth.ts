import { useAuthStore } from '@/stores/authStore';
import { toast } from '@/components/ui/use-toast';
import axiosInstance from './api';

interface Credentials {
  email: string;
  password: string;
}

export const userRegister = async (credentials: Credentials): Promise<boolean> => {
  try {
    await axiosInstance.post('/users', credentials);
    toast({title: "Sucesso", description: "Sucesso ao cadastrar um usuário!"})
    return true;
  } catch (error) {
    toast({
      variant: "destructive",
      title: "Erro",
      description: "Erro ao fazer cadastro"
    })
    console.error('Erro ao fazer cadastro:', error);
    return false;
  }
};

export const userLogin = async (credentials: Credentials): Promise<boolean> => {
  try {
    const response = await axiosInstance.post('/auth', credentials);
    const { token } = response.data;
    useAuthStore.getState().signIn(token)
    toast({ title: "Sucesso", description: "Login bem-sucedido!" });
    return true;
  } catch (error) {
    toast({
      variant: "destructive",
      title: "Erro",
      description:"Erro ao fazer login"
    })
    console.error('Erro ao fazer login:', error);
    return false;
  }
}