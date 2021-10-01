import { square } from "./funcoes.js";

document.querySelector("#e08 button").addEventListener("click", () => {
  const input = document.querySelector("#e08 input");
  const number = parseFloat(input.value);
  const result = square(number);
  input.value = result;
});
