import React from "react";
import PokemonList from "../../components/PokemonList";

class Ex10 extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      loading: true,
      pokemons: [],
    };
  }

  async componentDidMount() {
    const fetchedPokemons = [];
    for (let i = 1; i <= 151; i++) {
      const pokemon = await fetch(`https://pokeapi.co/api/v2/pokemon/${i}/`);
      const { name, sprites, stats, types } = await pokemon.json();
      const extractedTypes = [];
      for (const type of types) {
        extractedTypes.push(type["type"]["name"]);
      }
      const pokemonObject = {
        name,
        sprite: sprites["other"]["official-artwork"]["front_default"],
        stats: {
          hp: stats[0]["base_stat"],
          attack: stats[1]["base_stat"],
          defense: stats[2]["base_stat"],
          speed: stats[5]["base_stat"],
        },
        types: extractedTypes,
      };
      fetchedPokemons.push(pokemonObject);
    }
    console.log(fetchedPokemons);
    this.setState({ pokemons: fetchedPokemons, loading: false });
  }

  render() {
    return (
      <div className="container">
        {this.state.loading && "Loading..."}
        {!this.state.loading && <PokemonList pokemons={this.state.pokemons} />}
      </div>
    );
  }
}

export default Ex10;
