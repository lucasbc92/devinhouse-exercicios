function checkParity() {
  const number = parseInt(document.querySelector("#e03 input").value);
  const parity = number % 2 === 0 ? "par" : "ímpar";
  document.querySelector("#e03 p").innerHTML = `O número é ${parity}.`;
}

checkParity();
