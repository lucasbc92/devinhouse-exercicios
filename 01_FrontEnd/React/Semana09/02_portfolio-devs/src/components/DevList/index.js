import React from "react";

class DevList extends React.Component {
  render() {
    return <ul>{this.props.children}</ul>;
  }
}

export default DevList;
