import React from "react";
import Header from "../../components/Header";
import Search from "../../components/Search";
import DevList from "../../components/DevList";
import DevItem from "../../components/DevList/DevItem";
import SubHeader from "../../components/SubHeader";

class Home extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      isLoading: true,
      devsList: [],
      info: {
        title: "",
        description: "",
      },
    };

    this.listData = [];
  }

  handleChange = (evt) => {
    const text = evt.target.value;
    console.log(text);

    const resultFilter = this.listData.filter((dev) => {
      return dev.name.includes(text);
    });

    this.setState({ devsList: resultFilter });
  };

  async componentDidMount() {
    console.log("componentDidMount");

    const response = await fetch("/api/users");
    const responseInfo = await fetch("/api/info");
    const data = await response.json();
    const dataInfo = await responseInfo.json();

    const devsList = data.results.map((result) => {
      return {
        name: `${result.name.first} ${result.name.last}`,
        photo: result.picture.thumbnail,
        expertise: result.email,
      };
    });

    this.listData = devsList;

    this.setState({
      isLoading: false,
      devsList,
      info: {
        title: dataInfo.title,
        description: dataInfo.description,
      },
    });

    // fetch("https://randomuser.me/api/?results=5")
    // .then((response) => response.json())
    // .then((data) => {
    //   const devsList = data.results.map((result) => {
    //     return {
    //       name: `${result.name.first} ${result.name.last}`,
    //       photo: result.picture.thumbnail,
    //       expertise: result.email,
    //     };
    //   });

    //   this.setState({
    //     isLoading: false,
    //     devsList,
    //   });
    // });
  }

  render() {
    console.log("render");
    return (
      <>
        {/* Header */}
        <Header title="DEVS">
          <button onClick={this.props.onChangePageRegister}>Criar</button>
        </Header>

        {/* SubHeader */}
        <SubHeader
          title={this.state.info.title}
          description={this.state.info.description}
        />
        {/* Search */}
        <Search onChange={this.handleChange} />
        {/* List */}
        {this.state.isLoading && "Loading.."}
        {!this.state.isLoading && (
          <DevList>
            {this.state.devsList.map((dev) => (
              <DevItem
                name={dev.name}
                photo={dev.photo}
                expertise={dev.expertise}
                onSelect={(e) => this.props.onChangePagePerfil(dev)}
              />
            ))}
          </DevList>
        )}
      </>
    );
  }
}

export default Home;
