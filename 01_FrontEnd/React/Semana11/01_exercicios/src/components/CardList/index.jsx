import { Card } from "./Card";
import "./styles.css";

export const CardList = (props) => {
  return (
    <div className="card-list-container">
      {props.cards.map((card) => (
        <Card {...card} />
      ))}
    </div>
  );
};
