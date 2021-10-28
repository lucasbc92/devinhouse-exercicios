import React from "react";
import PropTypes from "prop-types";
import "./styles.css";
import { FaHeart, FaRegHeart } from "react-icons/fa";

export class LikeButton extends React.Component {
  render() {
    return (
      <div className="like-container" onClick={this.props.onPress}>
        {this.props.isPressed && <FaHeart />}
        {!this.props.isPressed && <FaRegHeart />}
      </div>
    );
  }
}

LikeButton.propTypes = {
  isPressed: PropTypes.bool.isRequired,
  onPress: PropTypes.func.isRequired,
};
