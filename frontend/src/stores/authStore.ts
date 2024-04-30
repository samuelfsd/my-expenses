import { create} from 'zustand';
import { setCookie, destroyCookie, parseCookies } from 'nookies';

interface AuthState {
  token: string;
  loggedIn: boolean;

  getToken: () => string;

  signIn: (token: string) => void;
  signOut: () => void;
}

export const useAuthStore = create<AuthState>((set) => ({
  token: '',
  loggedIn: false,

  getToken: () =>{
    const cookies = parseCookies()
    return cookies.token;
  },

  signIn: ( token ) => {
    setCookie(null, 'token', token, {
      maxAge: 30 * 24 * 60 * 60,
      path: '/',
    });
    set({ token: token, loggedIn: true });
  },

  signOut: () => {
    destroyCookie(null, 'token', null);
    set({ token: '', loggedIn: false});
  },
}));

