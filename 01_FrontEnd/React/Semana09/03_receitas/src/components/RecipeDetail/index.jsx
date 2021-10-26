import React from "react";
import PropTypes from "prop-types";
import "./styles.css";

export class RecipeDetail extends React.Component {
  render() {
    return (
      <div className="recipe-detail-container">
        <h2>{this.props.title}</h2>
        <img src={this.props.image} alt={this.props.title} />
        <p>{this.props.subtitle}</p>
        <p>Autor: {this.props.author}</p>
        <p className="recipe-detail-text">{this.props.text}</p>
      </div>
    );
  }
}

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
