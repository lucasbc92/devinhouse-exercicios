import React from "react";
import PropTypes from "prop-types";
import "./styles.css";
import { Link } from "react-router-dom";

export const RecipeItem = (props) => {
  return (
    <div className="recipe-container">
      {this.props.image && <img src={props.image} alt={props.title} />}
      <h4>{props.title}</h4>
      <p>{props.subtitle}</p>
      <Link
        to={{
          pathname: "/recipe",
          state: {
            recipeId: props.id,
          },
        }}
      >
        <button>Veja a receita</button>
      </Link>
    </div>
  );
};

RecipeItem.propTypes = {
  id: PropTypes.string.isRequired,
  image: PropTypes.string,
  title: PropTypes.string.isRequired,
  subtitle: PropTypes.string.isRequired,
};
