import React from "react";
import PropTypes from "prop-types";
import "./styles.css";

class PokemonItem extends React.Component {
  getBackgroundColor = () => {
    const typesStr = this.props.types.join(" ");
    if (typesStr.includes("grass")) {
      return "green";
    }
    if (typesStr.includes("poison")) {
      return "lime";
    }
    if (typesStr.includes("fire")) {
      return "red";
    }
    if (typesStr.includes("water")) {
      return "blue";
    }
    if (typesStr.includes("ice")) {
      return "#9EE4D9";
    }
    if (typesStr.includes("rock")) {
      return "brown";
    }
    if (typesStr.includes("fairy")) {
      return "pink";
    }
    if (typesStr.includes("electric")) {
      return "yellow";
    }
    return "#F0F0F0";
  };

  render() {
    return (
      <div
        className="pokemon-container"
        style={{ backgroundColor: this.getBackgroundColor() }}
      >
        <img className="pokemon-sprite" src={this.props.sprite} alt="" />
        <p className="pokemon-name">{this.props.name}</p>
        <div className="pokemon-stats">
          <p>HP: {this.props.stats.hp}</p>
          <p>Attack: {this.props.stats.attack}</p>
          <p>Defense: {this.props.stats.defense}</p>
          <p>Speed: {this.props.stats.speed}</p>
        </div>
        <p className="pokemon-types">{this.props.types.join(" ")}</p>
      </div>
    );
  }
}

PokemonItem.propTypes = {
  name: PropTypes.string.isRequired,
  sprite: PropTypes.string,
  stats: PropTypes.shape({
    hp: PropTypes.number.isRequired,
    attack: PropTypes.number.isRequired,
    defense: PropTypes.number.isRequired,
    speed: PropTypes.number.isRequired,
  }).isRequired,
  types: PropTypes.arrayOf(PropTypes.string).isRequired,
};

export default PokemonItem;
