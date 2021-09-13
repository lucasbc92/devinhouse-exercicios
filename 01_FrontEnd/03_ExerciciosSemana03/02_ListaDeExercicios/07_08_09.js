let items = [];

function createOption(item) {
  const option = document.createElement("option");
  option.innerHTML = item;
  const select = document.querySelector("#e07e08e09 select");
  select.appendChild(option);
}

function addItem() {
  const itemElement = document.getElementById("marketItem");

  const item = itemElement.value;

  // if(item.length === 0){
  //     alert("Digite o nome do item.")
  //     return;
  // }

  createOption(item);

  itemElement.value = "";

  items.push(item);
}

function saveItems() {
  if (items.length === 0) {
    alert("Não há itens a serem salvos.");
    return;
  }
  localStorage.setItem("@s03:items", JSON.stringify(items));
  alert("Lista salva com sucesso.");
}

function retrieveItems() {
  const retrievedItems = localStorage.getItem("@s03:items");
  if (retrievedItems === null) {
    alert("Não há itens salvos.");
    return;
  }
  items = JSON.parse(retrievedItems);
  //document.querySelector("#e07e08e09 select").innerHTML = "";
  const list = document.querySelector("#e07e08e09 select");
  const options = list.options;
  while (options.length > 0) {
    list.removeChild(options[0]);
  }
  for (let item of items) {
    createOption(item);
  }
  alert("Lista carregada com sucesso.");
}
