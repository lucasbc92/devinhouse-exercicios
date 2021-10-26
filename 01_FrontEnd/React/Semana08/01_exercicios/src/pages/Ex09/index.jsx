import React from "react";
import Table from "../../components/Table";

class Ex09 extends React.Component {
  render() {
    const data = [
      {
        product: "Dell Notebook",
        price: "$1000.00",
        inventory: 100,
      },
      {
        product: "Lenovo Notebook",
        price: "$900.00",
        inventory: 150,
      },
      {
        product: "Samsung Smart TV",
        price: "$1200.00",
        inventory: 75,
      },
    ];

    return (
      <div className="container">
        <Table
          title="My Table"
          description="Products table"
          columns={["Product", "Price", "Inventory"]}
          data={data}
        />
      </div>
    );
  }
}

export default Ex09;
