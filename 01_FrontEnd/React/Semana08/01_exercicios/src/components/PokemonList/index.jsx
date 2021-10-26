import React from "react";
import PropTypes from "prop-types";
import PokemonItem from "./PokemonItem";
import "./styles.css";

class PokemonList extends React.Component {
  render() {
    return (
      <div className="list-container">
        {this.props.pokemons.map(({ name, sprite, stats, types }) => (
          <PokemonItem
            key={name}
            name={name}
            sprite={sprite}
            stats={stats}
            types={types}
          />
        ))}
      </div>
    );
  }
}

PokemonList.propTypes = {
  pokemons: PropTypes.arrayOf(
    PropTypes.shape({
      name: PropTypes.string.isRequired,
      sprite: PropTypes.string,
      stats: PropTypes.shape({
        hp: PropTypes.number.isRequired,
        attack: PropTypes.number.isRequired,
        defense: PropTypes.number.isRequired,
        speed: PropTypes.number.isRequired,
      }).isRequired,
      types: PropTypes.arrayOf(PropTypes.string).isRequired,
    })
  ),
};

export default PokemonList;
