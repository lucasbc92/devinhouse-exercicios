import React from "react";
import PropTypes from "prop-types";
import "./style.css";

class SubHeader extends React.Component {
  render() {
    return (
      <section className="subheader-container">
        <h2 className="subheader-title">{this.props.title}</h2>
        <p className="subheader-subtitle">{this.props.description}</p>
      </section>
    );
  }
}

SubHeader.propTypes = {
  title: PropTypes.string.isRequired,
  description: PropTypes.string.isRequired,
};

export default SubHeader;
