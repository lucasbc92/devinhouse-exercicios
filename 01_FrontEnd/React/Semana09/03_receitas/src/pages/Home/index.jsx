import React from "react";
import { Header } from "../../components/Header";
import { Footer } from "../../components/Footer";
import { RecipeList } from "../../components/RecipeList";
import { RECIPES } from "../../mock/data";
//import { Link } from "react-router-dom";
import logoImg from "../../assets/images/logo.jpg";

import "./styles.css";
import { SearchBar } from "../../components/SearchBar";
//import { NavBar } from "../../components/NavBar";

export class Home extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      isLoading: true,
      recipes: [],
    };
    this.allRecipes = [];
  }

  handleChange = (e) => {
    const text = e.target.value;
    const filteredRecipes = this.allRecipes.filter((recipe) =>
      `${recipe.title} ${recipe.subtitle}`
        .toLowerCase()
        .includes(text.toLowerCase())
    );
    this.setState({
      recipes: filteredRecipes,
    });
  };

  async componentDidMount() {
    const recipes = RECIPES.data;
    this.allRecipes = recipes;
    console.log(recipes);
    setTimeout(
      () =>
        this.setState({
          recipes,
          isLoading: false,
        }),
      3000
    );
  }

  render() {
    return (
      <div className="container">
        <Header
          title="Palatare"
          image={logoImg}
          subtitle={"Economize e ganhe em saúde!"}
        >
          {/* <NavBar
            links={[
              {
                href: "/receita",
                title: "Receita",
              },
            ]}
          ></NavBar> */}
        </Header>

        {this.state.isLoading && "Loading..."}
        {!this.state.isLoading && (
          <main>
            <SearchBar onChange={this.handleChange} />
            <RecipeList recipes={this.state.recipes} />
          </main>
        )}

        <Footer content={"Contato: palatare@palatare.com"} />
      </div>
    );
  }
}
