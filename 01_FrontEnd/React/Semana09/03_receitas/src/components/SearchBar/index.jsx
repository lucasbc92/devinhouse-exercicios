import React from "react";
import PropTypes from "prop-types";
import "./styles.css";

export class SearchBar extends React.Component {
  render() {
    return <input type="text" onChange={this.props.onChange}></input>;
  }
}

SearchBar.propTypes = {
  onChange: PropTypes.func,
};
