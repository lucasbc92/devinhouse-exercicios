import React from "react";
import PropTypes from "prop-types";
import "./styles.css";

class Button extends React.Component {
  render() {
    return (
      <button style={{ backgroundColor: this.props.background }}>
        {this.props.title}
      </button>
    );
  }
}

Button.propTypes = {
  background: PropTypes.string.isRequired,
  title: PropTypes.string.isRequired,
};

export default Button;
