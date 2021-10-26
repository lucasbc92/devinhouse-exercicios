import React from "react";
import Header from "../../components/Header";

class Perfil extends React.Component {
  render() {
    return (
      <>
        {/*Header*/}
        <Header title="Super Dev">
          <button onClick={this.props.onChangePage}>Início</button>
        </Header>
        <div>Sobre</div>
      </>
    );
  }
}

export default Perfil;
