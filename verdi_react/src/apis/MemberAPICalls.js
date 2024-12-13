import { POST_LOGIN } from '../modules/MemberModule';

export const callLogoutAPI = () => {
    return async (dispatch, getState) => {
        dispatch({ type : POST_LOGIN, payload: '' });
        console.log('[MemberAPICalls] callLogoutAPI RESULT : SUCCESS');
    };
};