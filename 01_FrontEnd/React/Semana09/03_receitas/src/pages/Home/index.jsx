import React from "react";
import { Header } from "../../components/Header";
import { NavBar } from "../../components/NavBar";
import { SearchBar } from "../../components/SearchBar";
import { RecipeList } from "../../components/RecipeList";
import { Footer } from "../../components/Footer";

import logoImg from "../../assets/images/logo.jpg";

import "./styles.css";

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
    const response = await fetch("/api/recipes");
    const { recipes } = await response.json();
    const mappedRecipes = recipes.map((recipe) => {
      return {
        id: recipe.id,
        image: recipe.image,
        title: recipe.title,
        subtitle: recipe.subtitle,
      };
    });
    this.allRecipes = mappedRecipes;
    this.setState({
      recipes: mappedRecipes,
      isLoading: false,
    });
  }

  render() {
    return (
      <div className="container">
        <Header
          title="Palatare"
          image={logoImg}
          subtitle={"Economize e ganhe em saúde!"}
        >
          <NavBar
            links={[
              {
                href: "/contact",
                title: "Fale conosco",
              },
            ]}
          ></NavBar>
        </Header>

        {this.state.isLoading && "Loading..."}
        {!this.state.isLoading && (
          <main>
            <SearchBar
              placeholder={"Pesquise uma receita..."}
              onChange={this.handleChange}
            />
            <RecipeList recipes={this.state.recipes} />
          </main>
        )}

        <Footer content={"Contato: palatare@palatare.com"} />
      </div>
    );
  }
}
