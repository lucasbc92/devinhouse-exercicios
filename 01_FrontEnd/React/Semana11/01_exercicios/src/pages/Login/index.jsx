import { LoginForm } from "../../components/LoginForm";

import "./styles.css";

export const Login = () => {
  return (
    <div className="container">
      <h1 className="login-title">Login</h1>
      <LoginForm />
    </div>
  );
};
