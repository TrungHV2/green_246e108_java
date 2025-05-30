import { createReducer, createSlice } from "@reduxjs/toolkit";

// #region Async Thunks cho các operation CRUD
export const fetchPosts = createAsyncThunk('api/fetchPosts', async () => {
  const response = await axios.get(API_URL);
  return response.data;
});

export const addPost = createAsyncThunk('api/addPost', async (post) => {
  const response = await axios.post(API_URL, post);
  return response.data;
});

export const updatePost = createAsyncThunk('api/updatePost', async (post) => {
  const response = await axios.put(`${API_URL}/${post.id}`, post);
  return response.data;
});

export const deletePost = createAsyncThunk('api/deletePost', async (id) => {
  await axios.delete(`${API_URL}/${id}`);
  return id;
});
// #endregion

const initialState = {
    categories: [],
    status: 'idle',
    error: null
}

const categoryReducer = createSlice({
    name: 'category',
    initialState,
    reducers: {},
    extraReducers(builder) {
        builder
      // Fetch Posts
      .addCase(fetchPosts.pending, (state) => {
        state.status = 'loading';
      })
      .addCase(fetchPosts.fulfilled, (state, action) => {
        state.status = 'succeeded';
        state.posts = action.payload;
      })
      .addCase(fetchPosts.rejected, (state, action) => {
        state.status = 'failed';
        state.error = action.error.message;
      })
      
      // Add Post
      .addCase(addPost.fulfilled, (state, action) => {
        state.posts.push(action.payload);
      })
      
      // Update Post
      .addCase(updatePost.fulfilled, (state, action) => {
        const index = state.posts.findIndex(post => post.id === action.payload.id);
        if (index !== -1) {
          state.posts[index] = action.payload;
        }
      })
      
      // Delete Post
      .addCase(deletePost.fulfilled, (state, action) => {
        state.posts = state.posts.filter(post => post.id !== action.payload);
      });
    }
})