import React from "react";
import PropTypes from "prop-types";
import "./style.css";

class Search extends React.Component {
  render() {
    return (
      <div className="searchBar">
        <input
          type="text"
          placeholder="Pesquise..."
          onChange={this.props.onChange}
        />
      </div>
    );
  }
}

Search.propTypes = {
  onChange: PropTypes.func.isRequired,
};

export default Search;
