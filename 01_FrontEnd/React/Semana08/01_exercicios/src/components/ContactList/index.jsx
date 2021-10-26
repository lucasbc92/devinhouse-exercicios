import React from "react";
import PropTypes from "prop-types";

import Contact from "./Contact";
import "./styles.css";

class ContactList extends React.Component {
  render() {
    return (
      <div className="contacts-list-container">
        {this.props.contacts.length !== 0 ? (
          this.props.contacts.map((contact, i) => (
            <Contact
              key={i}
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

ContactList.propTypes = {
  contacts: PropTypes.arrayOf(
    PropTypes.shape({
      photo: PropTypes.string.isRequired,
      name: PropTypes.string.isRequired,
      status: PropTypes.oneOf(["online", "busy", "offline"]),
      description: PropTypes.string.isRequired,
    })
  ).isRequired,
};

export default ContactList;
