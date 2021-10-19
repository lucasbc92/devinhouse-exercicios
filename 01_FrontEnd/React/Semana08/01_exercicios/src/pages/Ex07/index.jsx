import React from "react";

import Product from "../../components/Product";

class Ex07 extends React.Component {
  render() {
    return (
      <div className="container">
        <Product
          photo="https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/MX472?wid=572&hei=572&fmt=jpeg&qlt=95&.v=1570119347612"
          name="Fones de ouvido Beats Solo3 Wireless – (PRODUCT)RED Vermelho cítrico"
          price={1599}
        />
      </div>
    );
  }
}

export default Ex07;
