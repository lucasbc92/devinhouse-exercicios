import React from "react";
import Home from "./pages/Home";
import Perfil from "./pages/Perfil";

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      isHomePage: true,
    };
  }

  handleChangePage = () => {
    this.setState({ isHomePage: !this.state.isHomePage });
  };

  render() {
    return (
      <>
        {this.state.isHomePage && <Home onChangePage={this.handleChangePage} />}
        {!this.state.isHomePage && (
          <Perfil onChangePage={this.handleChangePage} />
        )}
      </>
    );
  }
}

export default App;
