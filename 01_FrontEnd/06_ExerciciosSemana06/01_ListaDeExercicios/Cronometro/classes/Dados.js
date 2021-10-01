export default class Dados {
  #chave;
  #dados;
  constructor(chave, dados) {
    this.#chave = chave;
    this.#dados = dados;
  }

  salvar() {
    localStorage.setItem(this.#chave, JSON.stringify(this.#dados));
  }

  carregar() {
    let dadosCarregados = localStorage.getItem(this.#chave);
    if (dadosCarregados === null) {
      //alert("Sem dados para carregar!");
      throw new Error("Sem dados para carregar");
    }
    return JSON.parse(dadosCarregados);
  }
}
