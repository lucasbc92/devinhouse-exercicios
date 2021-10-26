import React from "react";
import PropTypes from "prop-types";
import "./index.css";

class DevItem extends React.Component {
  render() {
    return (
      <li className="devitem-container">
        {this.props.photo && (
          <img
            className="devitem-photo"
            src={this.props.photo}
            alt={this.props.name}
          />
        )}

        <div>
          <p className="devitem-name">{this.props.name}</p>
          <p className="devitem-expertise">{this.props.expertise}</p>
        </div>
      </li>
    );
  }
}

DevItem.propTypes = {
  photo: PropTypes.string,
  name: PropTypes.string.isRequired,
  expertise: PropTypes.string.isRequired,
};

export default DevItem;
