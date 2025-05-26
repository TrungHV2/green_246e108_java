import { applyMiddleware, createStore } from "redux";
import { reducers } from "./reducer";
import createSagaMiddleware from "redux-saga";
import { rootSaga } from "./saga";

const sagaMiddleware = createSagaMiddleware();

const store = createStore(reducers, applyMiddleware(sagaMiddleware));

sagaMiddleware.run(rootSaga);

export default store;