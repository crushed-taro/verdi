import React from 'react';
import { NavLink } from "react-router-dom";
import FooterCss from "./Footer.module.css";

export default function Footer() {
    return (
        <footer className={FooterCss.footer}>
            <div>
                <ul className={FooterCss.footermenu}>
                    <span><NavLink to="/">Home</NavLink></span>
                    <span><NavLink to="/mypage">User</NavLink></span>
                </ul>
            </div>
        </footer>
    );
}