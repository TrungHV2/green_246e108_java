import axios from 'axios'

export const http = axios.create({
    baseURL: 'http://localhost:8181/api/',
    headers: {
        'Content-Type': 'application/json'
    }
})