import React from "react";
import { Header } from "../../components/Header";
import { NavBar } from "../../components/NavBar";
import { RecipeDetail } from "../../components/RecipeDetail";
import { Footer } from "../../components/Footer";

import logoImg from "../../assets/images/logo.jpg";
import "./styles.css";

export class RecipePage extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      isLoading: true,
      isLiked: false,
      recipe: {},
    };
  }

  async componentDidMount() {
    const response = await fetch(
      `/api/recipes/${this.props.location.state.recipeId}`
    );
    const { recipe } = await response.json();
    this.setState({ recipe, isLoading: false });
  }

  handleLike = () => {
    this.setState({
      isLiked: !this.state.isLiked,
    });
  };

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
                href: "/",
                title: "Página inicial",
              },
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
            <RecipeDetail
              {...this.state.recipe}
              isLiked={this.state.isLiked}
              onPress={this.handleLike}
            />
          </main>
        )}
        <Footer content={"Contato: palatare@palatare.com"} />
      </div>
    );
  }
}
