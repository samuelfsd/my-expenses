
import { create } from 'zustand'

import {setCookie, destroyCookie, parseCookies} from 'nookies'

type AuthStore = {
  token: string;

  setToken: (token: string ) => void;
  clearToken: () => void;
  getToken: () => string;
}

export const useAuthStore = create<AuthStore>((set) => ({
  token: '',

  setToken: (token) => {
    set({ token });
    if (token) {
      // Salva o token no cookie
      setCookie(null, 'token', token, {
        maxAge: 30 * 24 * 60 * 60, // 30 dias de duração do cookie
        path: '/', // Caminho raiz para estar disponível em todo o site
      });
    } else {
      // Remove o cookie se o token for vazio
      destroyCookie(null, 'token', null);
    }
  },

  clearToken: () => {
    // Remove o cookie e reseta o estado para o token vazio
    destroyCookie(null, 'token', null);
    set({ token: '' });
  },

  getToken: () => {
    // Retorna o token do cookie
    const cookies = parseCookies();
    return cookies.token || '';
  },
}));