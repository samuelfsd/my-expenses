import axios from 'axios'

import { useAuthStore } from '@/stores/authStore';

export const instance =  axios.create({
  baseURL: "http://localhost:8080/api/v1/",
})

instance.interceptors.request.use(
  (config) => {
    const token = useAuthStore.getState().getToken();

    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }
    return config
  },
  (error) => {
    return console.log('erro', error)
  }
)
