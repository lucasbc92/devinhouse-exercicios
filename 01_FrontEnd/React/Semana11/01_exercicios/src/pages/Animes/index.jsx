import { useState, useEffect } from "react";
import { AnimeList } from "../../components/AnimeList";
import { SearchBar } from "../../components/SearchBar";

export const Animes = () => {
  const [isLoading, setIsLoading] = useState(true);
  const [animes, setAnimes] = useState([]);
  const [allAnimes, setAllAnimes] = useState([]);

  useEffect(() => {
    fetch("https://anime-facts-rest-api.herokuapp.com/api/v1").then(
      (response) =>
        response.json().then((animesData) => {
          console.log(animesData.data);
          setAnimes(animesData.data);
          setAllAnimes(animesData.data);
          setIsLoading(false);
        })
    );
  }, []);

  const handleSearch = (e) => {
    const { value } = e.target;
    const filteredAnimes = allAnimes.filter((anime) =>
      anime.anime_name.includes(value)
    );
    setAnimes(filteredAnimes);
  };

  return (
    <div className="container">
      {isLoading && "Loading..."}
      {!isLoading && (
        <>
          <h1>My Anime List</h1>
          <SearchBar onChange={handleSearch} />
          <AnimeList animes={animes} />
        </>
      )}
    </div>
  );
};
