import React from "react";
import { Link } from "react-router-dom";

class Home extends React.Component {
  render() {
    return (
      <div className="container">
        <nav>
          <Link to="/ex04">Ex04 - Button</Link>
          <Link to="/ex05">Ex05 - Contact List</Link>
        </nav>
      </div>
    );
  }
}

export default Home;
