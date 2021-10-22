import React from "react";
import { Link } from "react-router-dom";

import "./styles.css";

class Home extends React.Component {
  render() {
    return (
      <div className="container">
        <nav>
          <Link to="/ex04">Ex04 - Button</Link>
          <Link to="/ex05">Ex05 - Contact List</Link>
          <Link to="/ex06">Ex06 - Post</Link>
          <Link to="/ex07">Ex07 - Product</Link>
          <Link to="/ex09">Ex09 - Table</Link>
          <Link to="/ex10">Ex10 - Pokedex</Link>
        </nav>
      </div>
    );
  }
}

export default Home;
