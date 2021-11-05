import React from "react";
import PropTypes from "prop-types";
import "./styles.css";

export const SearchBar = (props) => {
  return (
    <div className="search-box-container">
      <input
        type="text"
        placeholder={props.placeholder}
        onChange={props.onChange}
      ></input>
    </div>
  );
};

SearchBar.propTypes = {
  placeholder: PropTypes.string.isRequired,
  onChange: PropTypes.func.isRequired,
};
