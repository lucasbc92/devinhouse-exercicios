import React from "react";
import PropTypes from "prop-types";
import "./styles.css";

class Table extends React.Component {
  render() {
    return (
      <div className="table-container">
        <h2>{this.props.title}</h2>
        <p>{this.props.description}</p>
        <table>
          <thead>
            <tr>
              {this.props.columns.map((column) => (
                <th key={column}>{column}</th>
              ))}
            </tr>
          </thead>
          <tbody>
            {this.props.data.map((row, i) => {
              const columnValues = this.props.columns.map((column, j) => (
                <td key={j}>{row[column.toLowerCase()]}</td>
              ));
              return <tr key={i}>{columnValues}</tr>;
            })}
          </tbody>
        </table>
      </div>
    );
  }
}

Table.propTypes = {
  title: PropTypes.string.isRequired,
  description: PropTypes.string.isRequired,
  columns: PropTypes.arrayOf(PropTypes.string).isRequired,
  data: PropTypes.arrayOf(PropTypes.object).isRequired,
};

export default Table;
