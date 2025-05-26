import {combineReducers} from 'redux'
import categoryReducer from './CategoryReducer'

export const reducers = combineReducers({
    categories: categoryReducer
})