import React from "react";
import PropTypes from "prop-types";
import "./styles.css";

export class SearchBar extends React.Component {
  render() {
    return (
      <div className="search-box-container">
        <input
          type="text"
          placeholder={this.props.placeholder}
          onChange={this.props.onChange}
        ></input>
      </div>
    );
  }
}

SearchBar.propTypes = {
  placeholder: PropTypes.string.isRequired,
  onChange: PropTypes.func.isRequired,
};
