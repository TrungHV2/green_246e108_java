
const initState = []

const categoryReducer = (state = initState, action) => {
    switch(action.type) {
        case 'CATEGORY_FETCH_DONE':
            return action.payload;
        default:
            return [...state];
    }
}

export default categoryReducer;