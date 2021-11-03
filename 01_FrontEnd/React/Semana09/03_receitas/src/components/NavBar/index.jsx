import React from "react";
import PropTypes from "prop-types";
import { Link } from "react-router-dom";
import "./styles.css";

export const NavBar = (props) => {
  return (
    <nav className="navbar-container">
      {props.links.map((link) => (
        <Link key={link.href} to={link.href}>
          {link.title}
        </Link>
      ))}
    </nav>
  );
};

NavBar.propTypes = {
  links: PropTypes.arrayOf(
    PropTypes.shape({
      href: PropTypes.string,
      title: PropTypes.string,
    }).isRequired
  ).isRequired,
};
