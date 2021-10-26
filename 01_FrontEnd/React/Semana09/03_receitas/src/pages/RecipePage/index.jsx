import React from "react";
import { Header } from "../../components/Header";
import { NavBar } from "../../components/NavBar";
import { RecipeDetail } from "../../components/RecipeDetail";
import { FoodInfoTableList } from "../../components/FoodInfoTableList";
import { Footer } from "../../components/Footer";

import logoImg from "../../assets/images/logo.jpg";
import "./styles.css";

export class RecipePage extends React.Component {
  constructor(props) {
    super(props);
    this.state = {};
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
                href: "/",
                title: "Página Inicial",
              },
            ]}
          ></NavBar>
        </Header>
        <main>
          <RecipeDetail {...this.props.location.state.recipe} />
          <FoodInfoTableList
            foodInfos={this.props.location.state.recipe.foodInfos}
          />
        </main>
        <Footer content={"Contato: palatare@palatare.com"} />
      </div>
    );
  }
}
