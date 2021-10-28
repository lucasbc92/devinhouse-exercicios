import React from "react";
import Home from "./pages/Home";
import Perfil from "./pages/Perfil";
import Register from "./pages/Register";

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      isHomePage: true,
      isPerfilPage: false,
      isRegisterPage: false,
      selectedDev: null,
    };
  }

  goToHome = () => {
    this.setState({
      isHomePage: true,
      isPerfilPage: false,
      isRegisterPage: false,
    });
  };

  goToPerfil = (selectedDev) => {
    this.setState({
      isHomePage: false,
      isPerfilPage: true,
      isRegisterPage: false,
      selectedDev,
    });
  };

  goToRegister = () => {
    this.setState({
      isHomePage: false,
      isPerfilPage: false,
      isRegisterPage: true,
    });
  };

  render() {
    return (
      <>
        {this.state.isHomePage && (
          <Home
            onChangePagePerfil={this.goToPerfil}
            onChangePageRegister={this.goToRegister}
          />
        )}
        {this.state.isPerfilPage && (
          <Perfil dev={this.state.selectedDev} onChangePage={this.goToHome} />
        )}
        {this.state.isRegisterPage && <Register onChangePage={this.goToHome} />}
      </>
    );
  }
}

export default App;
