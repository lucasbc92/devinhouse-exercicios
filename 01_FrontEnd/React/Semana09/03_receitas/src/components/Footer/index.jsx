import React from "react";
import PropTypes from "prop-types";
import "./styles.css";

export const Footer = (props) => {
  return (
    <footer className="footer-container">
      <p>{props.content}</p>
    </footer>
  );
};

Footer.propTypes = {
  content: PropTypes.string,
};
