import React from "react";
import { useState } from "react";
import { useDispatch } from "react-redux";
import { useNavigate } from "react-router-dom";
import LoginCSS from "./Login.module.css"; // CSS 파일 import
import { callLoginAPI } from "../../apis/MemberAPICalls";

function Login() {
  const navigate = useNavigate();
  const dispatch = useDispatch();

  const [form, setForm] = useState({});

  const onClickLoginHandler = () => {
    console.log("[Login] onClickLoginHandler Called");

    dispatch(callLoginAPI({
      form: form
    }));
    
    // navigate("/main");
  };

  const onClickSignupHandler = () => {
    navigate("/register", { replace: true });
  };

  const onClickFindEmailHandler = () => {
    navigate("/find-email");
  };

  const onChangeHandler = (e) => {
    setForm({
      ...form,
      [e.target.name]: e.target.value
    });
    // console.log(e.target.name + " : " + e.target.value);
  };

  return (
    <div className={LoginCSS.logincontainer}>
      <h1 className={LoginCSS.logintitle}>Verdi</h1>

      <input
        type="text"
        placeholder="Email"
        autoComplete="off"
        name="Email"
        className={LoginCSS.logininput}
        onChange={onChangeHandler}
      />

      <input
        type="password"
        placeholder="Password"
        autoComplete="off"
        name="password"
        className={LoginCSS.logininput}
        onChange={onChangeHandler}
      />

      <button onClick={onClickLoginHandler} className={LoginCSS.loginbutton}>
        로그인
      </button>

      <div className={LoginCSS.loginlinks}>
        <span onClick={onClickSignupHandler} className={LoginCSS.loginlink}>
          회원가입
        </span>
        <span className={LoginCSS.loginseparator}>|</span>
        <span onClick={onClickFindEmailHandler} className={LoginCSS.loginlink}>
          이메일찾기
        </span>
      </div>
    </div>
  );
}

export default Login;