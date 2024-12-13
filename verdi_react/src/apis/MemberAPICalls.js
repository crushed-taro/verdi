import { POST_LOGIN } from '../modules/MemberModule';

export const callLogoutAPI = () => {
    return async (dispatch, getState) => {
        dispatch({ type : POST_LOGIN, payload: '' });
        console.log('[MemberAPICalls] callLogoutAPI RESULT : SUCCESS');
    };
};

export const callLoginAPI = ({ form }) => {
    const requestURL = `http://${process.env.REACT_APP_RESTAPI_IP}:8080/auth/login`;

    return async (dispatch, getState) => {
        const result = await fetch(requestURL, {
            method : 'POST',
            headers : {
                'Content-Type': 'application/json',
                Accept: '*/*',
                'Access-Control-Allow-Origin': '*'
            },
            body: JSON.stringify({
                memberEmail: form.email,
                memberPassword: form.password
            })
        }).then(response => response.json());

        console.log('[MemberAPICalls] callLogin RESULT : ', result);

        if(result.staus === 200) {
            window.localStorage.setItem('accessToken', result.data.accessToken);
        } else if (result.status === 400) {
            alert(result.message);
        }
        dispatch({ type: POST_LOGIN, payload: result });
    };
};