import { http } from "."

export const categoryApi = {
    get: async () => {
        let response  = await http.get('category');
        return response.data;
    },
    post: async (data) => {
        let response  = await http.post('category', data);
        return response.data;
    }
}