import { FaBars } from "react-icons/fa";
import "../assets/css/navbar.css";

function Navbar() {
    return (
        <div className="navbar">
            <button className="menu-icon" >
                <FaBars />   
            </button>
            <div className="nav-links">
                <a href="/Home">Home</a>
                <a href="/review">Review</a>
                <a href="/contact">Contact</a>
                <a href="/profile">Profile</a>
                <a href="/">Logout</a>
            </div>
        </div>
    );
}

export default Navbar;
