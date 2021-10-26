import React from "react";
import PropTypes from "prop-types";
import "./styles.css";

export class Footer extends React.Component {
  render() {
    return (
      <footer className="footer-container">
        <p>{this.props.content}</p>
      </footer>
    );
  }
}

Footer.propTypes = {
  content: PropTypes.string,
};
