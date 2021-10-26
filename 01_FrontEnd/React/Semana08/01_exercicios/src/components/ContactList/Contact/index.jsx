import React from "react";
import PropTypes from "prop-types";
import "./styles.css";

class Contact extends React.Component {
  render() {
    return (
      <div className="contact-container">
        <div className="photo-container">
          <img className="photo" src={this.props.photo} alt={this.props.name} />
          {this.props.status && (
            <div className={`circle ${this.props.status}`}></div>
          )}
        </div>
        <div className="name-container">
          <strong>{this.props.name}</strong>
          <p>{this.props.description}</p>
        </div>
      </div>
    );
  }
}

Contact.propTypes = {
  photo: PropTypes.string.isRequired,
  name: PropTypes.string.isRequired,
  status: PropTypes.oneOf(["online", "busy", "offline"]),
  description: PropTypes.string.isRequired,
};

export default Contact;
