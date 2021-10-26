import React from "react";
import PropTypes from "prop-types";
import "./styles.css";

export class Header extends React.Component {
  render() {
    return (
      <header className="header-container">
        <div className="header-wrapper">
          {this.props.title && <h1>{this.props.title}</h1>}
          {this.props.image && (
            <img src={this.props.image} alt={this.props.title} />
          )}
        </div>
        {this.props.subtitle && (
          <p className="header-subtitle">{this.props.subtitle}</p>
        )}
        {this.props.children}
      </header>
    );
  }
}

Header.propTypes = {
  title: PropTypes.string,
  image: PropTypes.string,
  subtitle: PropTypes.string,
};
