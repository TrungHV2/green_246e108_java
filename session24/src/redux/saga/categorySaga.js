import { put } from 'redux-saga/effects'
import { categoryApi } from '../api/category-api';

export const fetchCategory = function* (action) {
    try {
        let data = yield categoryApi.get();
        yield put({type: 'CATEGORY_FETCH_DONE', payload: data});
    } catch (error) {
        yield put({type: 'FETCH_ERROR'});
    }
} 

export const addCategory = function* (action) {
    try {
        let data = yield categoryApi.post(action.payload);
        yield fetchCategory();
    } catch (error) {
        yield put({type: 'FETCH_ERROR'});
    }
} 