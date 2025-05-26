import {all, takeLatest} from 'redux-saga/effects'
import * as categorySaga from '../saga/categorySaga'

export const rootSaga = function* () {
    yield all([
        takeLatest("CATEGORY_FECTH", categorySaga.fetchCategory),
        takeLatest("CATEGORY_ADD", categorySaga.addCategory),
    ])
}