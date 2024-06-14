import axios from 'axios';
import { parseCookies } from 'nookies';

export const axiosInstance = axios.create({
  baseURL: 'http://localhost:8080/api/v1',
});

axiosInstance.interceptors.request.use((config) => {
  const cookies = parseCookies({});
  const token = cookies.token;

  if (token) {
    console.log('token', token)
    config.headers['Authorization'] = 'Bearer ' + token;
  }

  return config;
}, (error) => {
  console.log('erro no interceptador: ', error)
  return Promise.reject(error);
});

export default axiosInstance;
