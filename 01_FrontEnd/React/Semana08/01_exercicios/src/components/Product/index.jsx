import React from "react";
import PropTypes from "prop-types";
import "./styles.css";

class Product extends React.Component {
  render() {
    return (
      <div className="product-container">
        <img
          className="product-image"
          src={this.props.photo}
          alt={this.props.name}
        />
        <p className="product-description">{this.props.name}</p>
        <p className="product-price">{`$${this.props.price.toFixed(2)}`}</p>
      </div>
    );
  }
}

Product.propTypes = {
  photo: PropTypes.string.isRequired,
  name: PropTypes.string.isRequired,
  price: PropTypes.number.isRequired,
};

export default Product;
