import React from "react";
import PropTypes from "prop-types";
import "./styles.css";
import { Link } from "react-router-dom";

export class RecipeItem extends React.Component {
  render() {
    return (
      <div className="recipe-container">
        <img src={this.props.image} alt={this.props.title} />
        <h4>{this.props.title}</h4>
        <p>{this.props.subtitle}</p>
        <Link
          to={{
            pathname: "/recipe",
            state: {
              recipe: this.props,
            },
          }}
        >
          <button>Veja a receita</button>
        </Link>
      </div>
    );
  }
}

RecipeItem.propTypes = {
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
