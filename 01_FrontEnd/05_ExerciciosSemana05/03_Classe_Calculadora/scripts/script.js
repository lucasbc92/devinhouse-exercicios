class Calculadora {
  get #tela() {
    console.log(document.querySelector("#result"));
    return document.querySelector("#result");
  }

  resetar() {
    this.#tela.value = "";
  }

  preencherTela(value) {
    if (value === "=") {
      this.calcular();
      return;
    }
    this.#tela.value += value;
  }

  calcular() {
    try {
      let resultado = eval(this.#tela.value);
      this.resetar();
      this.preencherTela(resultado);
    } catch (e) {
      this.resetar();
      this.preencherTela("Valor inválido!");
      setTimeout(() => this.resetar(), 3000);
    }
  }
}

const calculadora = new Calculadora();

const botoes = document.querySelectorAll("input[type=button]");
console.log(botoes);
for (const botao of botoes) {
  botao.addEventListener("click", function (event) {
    calculadora.preencherTela(event.target.value);
  });
}

document
  .querySelector("#clear")
  .addEventListener("click", () => calculadora.resetar());
