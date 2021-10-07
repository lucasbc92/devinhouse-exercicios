import Joke from "./classes/Joke.js";
import { createCategoriesSelect } from "./categoriesSelect.js";

const divContainer = document.querySelector(".container");
const selectCategories = await createCategoriesSelect();
console.log(selectCategories);
divContainer.appendChild(selectCategories);

document.querySelector(".btnChuck").addEventListener("click", async () => {
  const category = document.querySelector(".categories").value;
  const response =
    //category == 0
    //? await fetch("https://api.chucknorris.io/jokes/random") :
    await fetch(`https://api.chucknorris.io/jokes/random?category=${category}`);
  const responseJSON = await response.json();
  createJoke(responseJSON, category);
  sortJokes();
});

function createJoke(responseJSON, category) {
  const joke = new Joke(responseJSON);
  const divJokes = document.querySelector(".jokes");
  const divJoke = document.createElement("div");
  divJoke.classList.add("joke");
  divJoke.setAttribute("data-category", category);
  const imgIconJoke = document.createElement("img");
  imgIconJoke.setAttribute("src", joke.urlIcon);
  const pCreatedAt = document.createElement("p");
  pCreatedAt.innerHTML = "Joke created at: " + joke.createdAt;
  const pJoke = document.createElement("p");
  pJoke.innerHTML = joke.joke;
  divJoke.appendChild(imgIconJoke);
  divJoke.appendChild(pCreatedAt);
  divJoke.appendChild(pJoke);
  divJokes.appendChild(divJoke);
}

function sortJokes() {
  function sortByCategory(a, b) {
    if (
      a["attributes"]["data-category"]["value"] >
      b["attributes"]["data-category"]["value"]
    ) {
      return 1;
    } else if (
      a["attributes"]["data-category"]["value"] <
      b["attributes"]["data-category"]["value"]
    ) {
      return -1;
    } else return 0;
  }

  let jokes = document.querySelectorAll(".joke");
  jokes = Array.from(jokes);
  console.log(jokes);
  console.log(jokes[0]["attributes"]["data-category"]["value"]);
  jokes.sort(sortByCategory);
  const divJokes = document.querySelector(".jokes");
  divJokes.innerHTML = "";
  for (const joke of jokes) {
    divJokes.appendChild(joke);
  }
}
