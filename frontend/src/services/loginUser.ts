import { useAuthStore } from '@/stores/authStore';
import { instance } from './api';
import { toast } from '@/components/ui/use-toast';

interface Credentials {
  email: string;
  password: string;
}

const loginUser = async (credentials: Credentials): Promise<boolean> => {
  try {
    const response = await instance.post('users/login', credentials);
    const { token } = response.data;
    useAuthStore.getState().setToken(token);
    return true;
  } catch (error) {
    toast({variant: "destructive", title: "Erro", description: "Houve um problema ao tentar realizar login."})
    console.error('Erro ao fazer login:', error);
    return false;
  }
};

export default loginUser;
