import { useState, useEffect } from "react";
import { CardList } from "../../components/CardList";
import { SearchBar } from "../../components/SearchBar";

export const Cards = () => {
  const [isLoading, setIsLoading] = useState(true);
  const [cards, setCards] = useState([]);
  const [allCards, setAllCards] = useState([]);

  useEffect(() => {
    fetch(
      "https://db.ygoprodeck.com/api/v7/cardinfo.php?cardset=metal%20raiders&num=45&offset=0"
    ).then((response) =>
      response.json().then((cardsData) => {
        const mappedCardsData = cardsData.data.map((card) => {
          return {
            img: card.card_images[0].image_url,
            name: card.name,
            type: card.type,
            race: card.race,
            desc: card.desc,
            stats: {
              atk: card.atk,
              def: card.def,
              level: card.level,
              attribute: card.attribute,
            },
          };
        });
        setCards(mappedCardsData);
        setAllCards(mappedCardsData);
        setIsLoading(false);
      })
    );
  }, []);

  const handleSearch = (e) => {
    const { value } = e.target;
    const filteredCards = allCards.filter((card) => card.name.includes(value));
    setCards(filteredCards);
  };

  return (
    <div className="container">
      {isLoading && "Loading..."}
      {!isLoading && (
        <>
          <h1>My Card List</h1>
          <SearchBar onChange={handleSearch} />
          <CardList cards={cards} />
        </>
      )}
    </div>
  );
};
