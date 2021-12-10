const teclas = document.querySelectorAll(".key");
console.log("*** Teclas:", teclas);

function obterDataKey(event) {
  console.log(event);
  const ehTeclado = event.type === "keydown";
  if (ehTeclado) {
    tocarNota(event.keyCode);
  } else {
    tocarNota(event.target.getAttribute("data-key"));
  }
}

function tocarNota(dataKey) {
  const audio = document.querySelector(`audio[data-key="${dataKey}"]`);
  if (audio !== null) {
    audio.play();
  }
}

for (let tecla of teclas) {
  tecla.addEventListener("click", obterDataKey);
}

document.addEventListener("keydown", obterDataKey);
