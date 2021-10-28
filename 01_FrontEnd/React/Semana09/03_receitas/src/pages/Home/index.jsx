import React from "react";
import { Header } from "../../components/Header";
import { Footer } from "../../components/Footer";
import { SearchBar } from "../../components/SearchBar";
import { RecipeList } from "../../components/RecipeList";
//import { RECIPES } from "../../mock/data";

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
    const recipesStream = await fetch("/api/teste");
    console.log(recipesStream);
    debugger;
    const {data: recipes} = await recipesStream.json();
    //const recipes = RECIPES.data;

    this.allRecipes = recipes;
    console.log(recipes);
    this.setState({
      recipes,
      isLoading: false,
    });
    // setTimeout(
    //   () =>
    //     this.setState({
    //       recipes,
    //       isLoading: false,
    //     }),
    //   3000
    // );
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
