import { NavLink } from "react-router-dom";

export default function Navbar() {
    return (
        <div>
            <ul>
                <li><NavLink to="/home">Home</NavLink></li>
                <li><NavLink to="/mypage">User</NavLink></li>
            </ul>
        </div>
    );
}