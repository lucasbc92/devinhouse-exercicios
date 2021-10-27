import React from "react";
import Header from "../../components/Header";
import DevItem from "../../components/DevList/DevItem";

class Perfil extends React.Component {
  render() {
    return (
      <>
        {/*Header*/}
        <Header title="Super Dev">
          <button onClick={this.props.onChangePage}>Início</button>
        </Header>
        <DevItem {...this.props.dev} />
      </>
    );
  }
}

export default Perfil;
