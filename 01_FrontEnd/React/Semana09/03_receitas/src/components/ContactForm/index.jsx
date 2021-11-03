import React from "react";
import PropTypes from "prop-types";

import Loader from "react-loader-spinner";

import "./styles.css";
import "react-loader-spinner/dist/loader/css/react-spinner-loader.css";

export class ContactForm extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      name: "",
      email: "",
      message: "",
      nameValid: false,
      emailValid: false,
      messageValid: false,
      isSubmitEnabled: false,
      isSubmitted: false,
      isLoading: false,
      charactersRemaining: 250,
    };
  }

  handleSubmit = async (e) => {
    e.preventDefault();
    const { name, email, message } = this.state;
    this.setState({ isSubmitEnabled: false, isLoading: true });
    const response = await fetch("/api/messages", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: { name, email, message },
    });
    const createdMessage = await response.json();
    console.log(createdMessage);
    this.setState({
      isLoading: false,
      isSubmitEnabled: true,
      isSubmitted: true,
    });
    this.setState({
      isSubmitted: false,
    });
  };

  handleChange = (e) => {
    const { name, value } = e.target;
    this.setState({ [name]: value });
    const isValid = e.target.checkValidity();
    if (isValid)
      this.setState({
        [`${name}Valid`]: true,
      });
    else
      this.setState({
        [`${name}Valid`]: false,
      });
    if (
      this.state.nameValid &&
      this.state.emailValid &&
      this.state.messageValid
    )
      this.setState({
        isSubmitEnabled: true,
      });
    else
      this.setState({
        isSubmitEnabled: false,
      });
    if (name === "message") {
      this.setState({
        charactersRemaining: 250 - value.length,
      });
    }
  };

  componentDidUpdate() {
    if (this.state.isSubmitted) {
      alert("Mensagem enviada com sucesso!");
    }
  }

  render() {
    return (
      <div className="form-container">
        {this.state.isLoading && (
          <Loader
            type="ThreeDots"
            color="var(--color-text-base)"
            height={50}
            width={50}
          ></Loader>
        )}
        <h2>{this.props.title}</h2>
        <form onSubmit={this.handleSubmit}>
          <label>
            Nome:
            <input
              type="text"
              name="name"
              placeholder="Digite seu nome"
              value={this.state.name}
              onChange={this.handleChange}
              required
            />
          </label>
          <label>
            E-mail:
            <input
              type="text"
              name="email"
              placeholder="example@site.com"
              value={this.state.email}
              onChange={this.handleChange}
              email={"true"}
              pattern=".+@.+\..+"
              required
            />
          </label>
          <label>
            Mensagem:
            <textarea
              name="message"
              value={this.state.message}
              onChange={this.handleChange}
              maxLength="250"
              rows="6"
              cols="50"
              required
            />
          </label>
          <p>{this.state.charactersRemaining} caracteres restantes</p>
          <button type="submit" disabled={!this.state.isSubmitEnabled}>
            Enviar Mensagem
          </button>
        </form>
      </div>
    );
  }
}

ContactForm.propTypes = {
  title: PropTypes.string.isRequired,
};
