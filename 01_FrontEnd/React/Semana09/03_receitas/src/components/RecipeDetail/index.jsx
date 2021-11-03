import React from "react";
import PropTypes from "prop-types";
import "./styles.css";

import { LikeButton } from "../LikeButton";
import { FoodInfoTableList } from "../FoodInfoTableList";

export const RecipeDetail = (props) => {
  return (
    <div className="recipe-detail-container">
      <div className="recipe-detail-title-like">
        <h2>{props.title}</h2>
        <div className="recipe-detail-like">
          <span>Gostei</span>
          <LikeButton isPressed={props.isLiked} onPress={props.onPress} />
        </div>
      </div>

      <img src={props.image} alt={props.title} />
      <p>{props.subtitle}</p>
      <p>Autor: {props.author}</p>
      <p className="recipe-detail-text">{props.text}</p>
      <FoodInfoTableList foodInfos={props.foodInfos} />
    </div>
  );
};

RecipeDetail.propTypes = {
  image: PropTypes.string,
  title: PropTypes.string.isRequired,
  subtitle: PropTypes.string.isRequired,
  author: PropTypes.string.isRequired,
  foodInfos: PropTypes.arrayOf(
    PropTypes.shape({
      food: PropTypes.string,
      calories: PropTypes.number,
      carbs: PropTypes.number,
      proteins: PropTypes.number,
      lipids: PropTypes.number,
      saturatedFat: PropTypes.number,
    })
  ).isRequired,
  text: PropTypes.string,
};
