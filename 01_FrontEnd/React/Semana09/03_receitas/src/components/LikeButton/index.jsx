import React from "react";
import PropTypes from "prop-types";
import "./styles.css";
import { FaHeart, FaRegHeart } from "react-icons/fa";

export const LikeButton = (props) => {
  return (
    <div className="like-container" onClick={props.onPress}>
      {props.isPressed && <FaHeart />}
      {!props.isPressed && <FaRegHeart />}
    </div>
  );
};

LikeButton.propTypes = {
  isPressed: PropTypes.bool,
  onPress: PropTypes.func.isRequired,
};
