import "./styles.css";

export const Anime = (props) => {
  return (
    <div className="anime-container">
      <img src={props.img} alt={props.name} />
      <p>{props.name}</p>
    </div>
  );
};
