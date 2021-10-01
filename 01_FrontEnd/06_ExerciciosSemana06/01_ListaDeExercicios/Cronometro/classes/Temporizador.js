export default class Temporizador {
  constructor(segundos = 0, dezenasMilissegundos = 0, interval) {
    this.segundos = segundos;
    this.dezenasMilissegundos = dezenasMilissegundos;
    this.interval = interval;
    this.spanSegundos.innerHTML = segundos.toString().padStart(2, "0");
    this.spanDezenasMilissegundos.innerHTML = dezenasMilissegundos
      .toString()
      .padStart(2, "0");
    if (interval) {
      this.iniciar();
    }
  }

  get spanDezenasMilissegundos() {
    return document.querySelector("#tens");
  }

  get spanSegundos() {
    return document.querySelector("#seconds");
  }

  iniciar() {
    //let that = this;
    clearInterval(this.interval);
    this.interval = setInterval(() => this.#incrementar(), 10);
  }

  parar() {
    //let that = this;
    clearInterval(this.interval);
    this.interval = false;
  }

  reset() {
    //let that = this;
    clearInterval(this.interval);
    this.interval = false;
    this.dezenasMilissegundos = 0;
    this.segundos = 0;
    this.spanDezenasMilissegundos.innerHTML = "00";
    this.spanSegundos.innerHTML = "00";
  }

  #incrementar() {
    this.dezenasMilissegundos += 1;

    if (this.dezenasMilissegundos >= 9) {
      this.spanDezenasMilissegundos.innerHTML = "0" + this.dezenasMilissegundos;
    }

    if (this.dezenasMilissegundos > 9) {
      this.spanDezenasMilissegundos.innerHTML = this.dezenasMilissegundos;
    }

    if (this.dezenasMilissegundos > 99) {
      this.segundos++;
      this.spanSegundos.innerHTML = "0" + this.segundos;

      this.dezenasMilissegundos = 0;

      this.spanDezenasMilissegundos.innerHTML = "0" + this.dezenasMilissegundos;
    }

    if (this.segundos > 9) {
      this.spanSegundos.innerHTML = this.segundos;
    }
  }
}
