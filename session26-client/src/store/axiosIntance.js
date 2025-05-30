import axios from "axios";

let isRefreshing = false;
let failedRequestsQueue = [];

const axiosInstance  = axios.create({
    baseURL: 'localhost:8080/api/',
    headers: {
        'Content-Type': 'application/json'
    }
});

axiosInstance .interceptors.request.use(config => {
    const token = localStorage.getItem('token');
    if (token) {
        config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
}, error => Promise.reject(error));

axiosInstance.interceptors.response.use(
    (response) => response,
    async (error) => {
        const originalRequest = error.config;
        const refreshTokenValue = localStorage.getItem('refreshToken');
        if (error.response?.status === 401 && 
            !originalRequest._retry && 
            // originalRequest.url !== '/auth/refresh' && 
            refreshTokenValue) {
            // Xử lý khi token hết hạn hoặc không hợp lệ
            // Ví dụ: logout user, refresh token, v.v.
            if (isRefreshing) {
                // Nếu đang refresh token, thêm request vào hàng đợi
                return new Promise((resolve, reject) => {
                    failedRequestsQueue.push({ resolve, reject });
                }).then(token => {
                    originalRequest.headers.Authorization = `Bearer ${token}`;
                    return axiosInstance(originalRequest);
                }).catch(err => Promise.reject(err));
            }

            originalRequest._retry = true;
            isRefreshing = true;

            try {
                // Gọi action refreshToken từ Redux
                //const { accessToken } = await store.dispatch(refreshToken()).unwrap();
                
                // Cập nhật header và thử lại request ban đầu
                originalRequest.headers.Authorization = `Bearer ${accessToken}`;
                
                // Xử lý các request đang chờ trong hàng đợi
                processQueue(null, accessToken);
                
                return axiosInstance(originalRequest);
            } catch (refreshError) {
                // Nếu refresh token thất bại
                processQueue(refreshError, null);
                //store.dispatch(logout());
                window.location.href = '/login';
                return Promise.reject(refreshError);
            } finally {
                isRefreshing = false;
            }
        }
        return Promise.reject(error);
    }
);

export default http;