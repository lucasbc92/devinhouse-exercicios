import { useState } from "react";
import { Link } from "react-router-dom";

import "./styles.css";

export const LoginForm = () => {
  const [user, setUser] = useState("");
  const [password, setPassword] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    if (user.length === 0) {
      alert("Please fill your username.");
      return;
    }
    if (password.length === 0) {
      alert("Please fill your password.");
      return;
    }
    alert("Login successfully!");
  };

  return (
    <form onSubmit={handleSubmit} className="login-form-container">
      <input
        type="text"
        name="user"
        placeholder="Username"
        value={user}
        onChange={(e) => setUser(e.target.value)}
      ></input>
      <input
        type="password"
        name="password"
        placeholder="Password"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
      ></input>
      <button type="submit">Login</button>
      <p>
        Not registered? <Link to="/account">Create an account</Link>
      </p>
    </form>
  );
};
