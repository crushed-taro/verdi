import { useEffect, useState } from "react"; 

export default function Register() {

    const [ form, setForm ] = useState({});
    const [ isPasswordMatch, setIsPasswordMatch ] = useState("");

    const onChangeHandler = (e) => {
        setForm({
            ...form,
            [e.target.name]: e.target.value
        });

        console.log(e.target.name + " : " + e.target.value);
    };

    useEffect(() => {
        if(form.confirmPassword) {
            if(form.confirmPassword !== form.password) {
                setIsPasswordMatch("비밀번호가 일치하지 않습니다.");
            } else {
                setIsPasswordMatch("비밀번호가 일치합니다.");
            }
        } else {
            setIsPasswordMatch("");
        }
    }, [form.password, form.confirmPassword])

    return(
        <>
            <h1>회원가입</h1>
            <input
                type="text"
                placeholder="Email"
                name="email"
                onChange={ onChangeHandler }
            />
            <input
                type="password"
                placeholder="password"
                name="password"
                onChange={ onChangeHandler }
            />
            <input
                type="password"
                placeholder="password"
                name="confirmPassword"
                onChange={ onChangeHandler }
            />
            {isPasswordMatch && (
                <p>
                    {isPasswordMatch}
                </p>
            )}
        </>
    )

}