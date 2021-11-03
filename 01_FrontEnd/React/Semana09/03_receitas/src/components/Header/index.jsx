import React from "react";
import PropTypes from "prop-types";
import "./styles.css";

export const Header = (props) => {
  return (
    <header className="header-container">
      <div className="header-wrapper">
        {props.title && <h1>{props.title}</h1>}
        {props.image && <img src={props.image} alt={props.title} />}
      </div>
      {props.subtitle && <p className="header-subtitle">{props.subtitle}</p>}
      {props.children}
    </header>
  );
};

Header.propTypes = {
  title: PropTypes.string,
  image: PropTypes.string,
  subtitle: PropTypes.string,
};
