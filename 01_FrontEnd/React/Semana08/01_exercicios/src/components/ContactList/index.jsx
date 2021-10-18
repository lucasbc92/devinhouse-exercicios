import React from "react";
//import PropTypes from "prop-types";

import Contact from "./Contact";
import "./styles.css";

class ContactList extends React.Component {
  render() {
    return (
      <div className="contacts-list-container">
        {this.props.contacts ? (
          this.props.contacts.map((contact) => (
            <Contact
              photo={contact.photo}
              name={contact.name}
              status={contact.status}
              description={contact.description}
            />
          ))
        ) : (
          <p>Contact list is empty!</p>
        )}
      </div>
    );
  }
}

//ContactList.propTypes = {};

export default ContactList;
