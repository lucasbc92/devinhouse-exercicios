import React from "react";
import { Header } from "../../components/Header";
import { ContactForm } from "../../components/ContactForm";
import { Footer } from "../../components/Footer";

import logoImg from "../../assets/images/logo.jpg";

import "./styles.css";
import { NavBar } from "../../components/NavBar";

export class Contact extends React.Component {
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
            ]}
          ></NavBar>
        </Header>

        <main>
          <ContactForm title={"Fale conosco"} />
        </main>

        <Footer content={"Contato: palatare@palatare.com"} />
      </div>
    );
  }
}
