import React from "react";
import PropTypes from "prop-types";
import { FoodInfoTable } from "./FoodInfoTable";

import "./styles.css";

export class FoodInfoTableList extends React.Component {
  render() {
    return (
      <div className="table-list-container">
        {this.props.foodInfos.map((info) => (
          <FoodInfoTable key={info.food} {...info} />
        ))}
      </div>
    );
  }
}

FoodInfoTableList.propTypes = {
  foodInfos: PropTypes.arrayOf(
    PropTypes.shape({
      food: PropTypes.string.isRequired,
      calories: PropTypes.number.isRequired,
      carbs: PropTypes.number.isRequired,
      proteins: PropTypes.number.isRequired,
      lipids: PropTypes.number.isRequired,
      saturatedFat: PropTypes.number.isRequired,
    })
  ).isRequired
};
