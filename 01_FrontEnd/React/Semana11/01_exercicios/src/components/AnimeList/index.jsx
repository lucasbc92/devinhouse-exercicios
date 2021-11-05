import { Anime } from "./Anime";
import "./styles.css";

export const AnimeList = (props) => {
  return (
    <div className="anime-list-container">
      {props.animes.map((anime) => (
        <Anime
          key={anime.anime_id}
          img={anime.anime_img}
          name={anime.anime_name}
        />
      ))}
    </div>
  );
};
