import { useNavigate, NavLink } from "react-router-dom";
import { useDispatch, useSeletor } from "react-redux";
import { useState } from "react";
import { decodeJwt } from "../../utils/tokenUtils";

import { callLogoutAPI } from "../../apis/MemberAPICalls";

export default function Header() {

    const navigate = useNavigate();
    const dispatch = useDispatch();

    const isLogin = window.localStorage.getItem('accessToken');
    const [loginModal, setLoginModal] = useState(false);

    const onClickMypageHandler = () => {
        const token = decodeJwt(window.localStorage.getItem('accessToken'));
        console.log("[Header] onClickMypageHandler token : ", token);

        if(token.exp * 1000 < Date.now()) {
            setLoginModal(true);
            return;
        }

        navigate('/mypage', { replace: true });
    };

    const onClickLogoutHandler = () => {
        window.localStorage.removeItem('accessToken');
        dispatch(callLogoutAPI());


        alert('로그아웃이 되어 메인화면으로 이동합니다.');
        navigate('/', { replace: true });
        window.location.reload();
    };

    const onClickLogoHandler = () => {
        navigate('/', { replace: true });
    };

    function BeforeLogin() {
        return (
            <div>
                <NavLink to="/login">로그인</NavLink> | {' '}
                <NavLink to="/register">회원가입</NavLink>
            </div>
        );
    }

    function AfterLogin() {
        return (
            <div>
                <button
                    onClick={onClickMypageHandler}
                >
                    마이페이지
                </button>{' '} | {' '}
                <button
                    onClick={onClickLogoutHandler}
                >
                    로그아웃
                </button>
            </div>
        );
    }

    return(
        <>
            <button
                onClick={onClickLogoHandler}
            >
                Verdi
            </button>

            {isLogin == null || isLogin === undefined ? (
                <BeforeLogin />
            ) : (
                <AfterLogin />
            )}
        </>
    );
}