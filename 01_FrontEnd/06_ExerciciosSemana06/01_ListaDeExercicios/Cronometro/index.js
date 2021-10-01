import Temporizador from "./classes/Temporizador.js";
import Dados from "./classes/Dados.js";

let temporizador = new Temporizador();
let dados = new Dados("temporizador", temporizador);

try {
  console.log("entrou aqui");
  let temporizadorCarregado = dados.carregar();
  temporizador = new Temporizador(
    temporizadorCarregado.segundos,
    temporizadorCarregado.dezenasMilissegundos,
    temporizadorCarregado.interval
  );
  dados = new Dados("temporizador", temporizador);
  console.log(temporizador);
} catch (error) {
  console.log(error);
}

console.log(temporizador);

var btnStart = document.querySelector("#button-start");
var btnStop = document.querySelector("#button-stop");
var btnReset = document.querySelector("#button-reset");

btnStart.addEventListener("click", function () {
  temporizador.iniciar();
  dados.salvar();
});

btnStop.addEventListener("click", function () {
  temporizador.parar();
  dados.salvar();
});

btnReset.addEventListener("click", function () {
  temporizador.reset();
  dados.salvar();
});
