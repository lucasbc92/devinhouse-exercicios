import React from "react";
import ContactList from "../../components/ContactList";

class Ex05 extends React.Component {
  render() {
    return (
      <div className="container">
        <ContactList
          contacts={[
            {
              photo: "https://github.com/lucasbc92.png",
              name: "Lucas Bueno Cesario",
              status: "online",
              description: "A typical nerd.",
            },
            {
              photo: "https://github.com/lucasbc92.png",
              name: "Lucas Bueno Cesario",
              status: "offline",
              description: "A typical nerd.",
            },
          ]}
        />
      </div>
    );
  }
}

export default Ex05;
