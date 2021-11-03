import React from "react";
import PropTypes from "prop-types";
import "./styles.css";
import { RecipeItem } from "./RecipeItem";

export const RecipeList = (props) => {
  return (
    <div className="recipe-list-container">
      {props.recipes.map((recipe) => (
        <RecipeItem key={recipe.id} {...recipe} />
      ))}
    </div>
  );
};

RecipeList.propTypes = {
  recipes: PropTypes.arrayOf(
    PropTypes.shape({
      id: PropTypes.string.isRequired,
      image: PropTypes.string,
      title: PropTypes.string.isRequired,
      subtitle: PropTypes.string.isRequired,
    })
  ).isRequired,
};
