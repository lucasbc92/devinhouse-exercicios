import React from "react";
import PropTypes from "prop-types";
import "./styles.css";
import { RecipeItem } from "./RecipeItem";

export class RecipeList extends React.Component {
  render() {
    return (
      <div className="recipe-list-container">
        {this.props.recipes.map((recipe) => (
          <RecipeItem key={recipe.id} {...recipe} />
        ))}
      </div>
    );
  }
}

RecipeList.propTypes = {
  recipes: PropTypes.arrayOf(
    PropTypes.shape({
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
    })
  ).isRequired,
};
