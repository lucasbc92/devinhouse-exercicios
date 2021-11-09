import "./styles.css";

export const Card = (props) => {
  const paintCard = () => {
    switch (props.stats.attribute) {
      case "DARK":
        return "#333333";
      case "LIGHT":
        return "#FFFFFF";
      case "WATER":
        return "aqua";
      case "FIRE":
        return "darkorange";
      case "EARTH":
        return "brown";
      case "WIND":
        return "lime";
      default:
        return "var(--color-background)";
    }
  };

  return (
    <div className="card-container" style={{ backgroundColor: paintCard() }}>
      <img src={props.img} alt={props.name} />
      <div className="card-description">
        <p>
          {props.name} - {props.race}
        </p>
        <p>{props.desc}</p>
        {props.type.includes("Monster") && (
          <div className="card-stats">
            <p className="card-atk">ATK: {props.stats.atk}</p>
            <p className="card-def">DEF: {props.stats.def}</p>
            <p className="card-level">Level: {props.stats.level}</p>
            <p className="card-attribute">{props.stats.attribute}</p>
          </div>
        )}
      </div>
    </div>
  );
};
