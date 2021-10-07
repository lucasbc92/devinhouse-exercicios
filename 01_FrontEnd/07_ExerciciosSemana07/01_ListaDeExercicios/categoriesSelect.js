export async function createCategoriesSelect() {
  const categories = await fetch("https://api.chucknorris.io/jokes/categories");
  const categoriesJSON = await categories.json();
  console.log(categoriesJSON);
  const selectCategories = document.createElement("select");
  selectCategories.classList.add("categories");
  const defaultOption = document.createElement("option");
  //   defaultOption.value = 0;
  //   defaultOption.innerHTML = "any";
  //   defaultOption.selected = true;
  //   selectCategories.appendChild(defaultOption);
  for (const category of categoriesJSON) {
    let optionCategory = document.createElement("option");
    optionCategory.value = category;
    optionCategory.innerHTML = category;
    selectCategories.appendChild(optionCategory);
  }
  console.log(selectCategories);
  return selectCategories;
}
