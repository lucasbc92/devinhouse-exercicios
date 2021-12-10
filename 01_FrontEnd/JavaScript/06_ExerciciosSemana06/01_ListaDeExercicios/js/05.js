import { divideByTwo } from "./funcoes.js";

document.querySelector("#e05 button").addEventListener("click", () => {
  const input = document.querySelector("#e05 input");
  const number = parseFloat(input.value);
  const result = divideByTwo(number);
  input.value = result;
});
