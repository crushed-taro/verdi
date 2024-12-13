import React from "react";
import { useNavigate } from "react-router-dom";
import LoginCSS from "./Login.module.css"; // CSS 파일 import

function Login() {
  const navigate = useNavigate();

  const handleLogin = () => {
    console.log("Logged in!");
    navigate("/main");
  };

  const onClickSignupHandler = () => {
    navigate("/signup");
  };

  const onClickFindEmailHandler = () => {
    navigate("/find-email");
  };

  return (
    <div className={LoginCSS.logincontainer}>
      <h1 className={LoginCSS.logintitle}>Verdi</h1>

      <input
        type="text"
        placeholder="Email"
        className={LoginCSS.logininput}
      />

      <input
        type="password"
        placeholder="Password"
        className={LoginCSS.logininput}

      />

      <button onClick={handleLogin} className={LoginCSS.loginbutton}>
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