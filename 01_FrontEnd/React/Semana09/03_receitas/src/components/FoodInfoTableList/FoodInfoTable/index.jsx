import React from "react";
import PropTypes from "prop-types";
import "./styles.css";

export class FoodInfoTable extends React.Component {
  render() {
    return (
      <div className="table-container">
        <h4 className="info-food">{this.props.food}</h4>
        <p className="info-calories">{this.props.calories} Kcal</p>
        <table>
          <tbody>
            <tr>
              <td>Carboidratos</td>
              <td className="info-cell">{this.props.carbs} g</td>
            </tr>
            <tr>
              <td>Proteínas</td>
              <td className="info-cell">{this.props.proteins} g</td>
            </tr>
            <tr>
              <td>Lipídios</td>
              <td className="info-cell">{this.props.lipids} g</td>
            </tr>
            <tr>
              <td>Gorduras Saturadas</td>
              <td className="info-cell">{this.props.saturatedFat} g</td>
            </tr>
          </tbody>
        </table>
      </div>
    );
  }
}

FoodInfoTable.propTypes = {
  food: PropTypes.string.isRequired,
  calories: PropTypes.number.isRequired,
  carbs: PropTypes.number.isRequired,
  proteins: PropTypes.number.isRequired,
  lipids: PropTypes.number.isRequired,
  saturatedFat: PropTypes.number.isRequired,
};
