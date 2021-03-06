import { Link } from "react-router-dom";

import "./styles.css";

export const Home = () => {
  return (
    <div className="container">
      <nav className="home-navbar">
        <Link to="/login">Ex02 - Login</Link>
        <Link to="/counter">Ex04 - Counter</Link>
        <Link to="/animes">Ex05 - Animes</Link>
        <Link to="/cards">Ex07 - Cards</Link>
        <Link to="/account">Ex09 - Account</Link>
      </nav>
    </div>
  );
};
