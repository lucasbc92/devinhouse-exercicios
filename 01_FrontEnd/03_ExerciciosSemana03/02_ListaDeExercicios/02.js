function calculate(operation) {
  const v1 = parseFloat(document.getElementById("v1").value);
  const v2 = parseFloat(document.getElementById("v2").value);
  console.log(v1, v2);
  let result;
  switch (operation) {
    case "+":
      result = v1 + v2;
      break;
    case "-":
      result = v1 - v2;
      break;
    case "*":
      result = v1 * v2;
      break;
    case "/":
      result = v1 / v2;
      break;
  }
  document.getElementById("textOperation").innerHTML = operation;
  document.querySelector("#e02 div textarea").innerHTML = result;
}
