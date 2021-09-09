function carregarPerguntas() {
  const nome = window.prompt("Qual é o seu primeiro nome?");
  if (nome === null) return;
  const sobrenome = window.prompt("Qual é o seu sobrenome?");
  if (sobrenome === null) return;
  const sobrenomeSemEspacos = sobrenome.replace(/ /g, "");
  window.alert(
    `Bem-vindo, ${nome} ${sobrenome.toUpperCase()}! Seu sobrenome contém ${
      sobrenomeSemEspacos.length
    } letras.`
  );
  let anoDeNascimento;
  let anoDeNascimentoEhNumerico = false;
  while (!anoDeNascimentoEhNumerico) {
    anoDeNascimento = window.prompt("Qual é o seu ano de nascimento?");
    if (anoDeNascimento === null) return;
    if (/^[0-9]{1,4}$/.test(anoDeNascimento)) {
      anoDeNascimentoEhNumerico = true;
    } else {
      alert("Valor inválido! Digite novamente.");
    }
  }
  let anoAtual;
  let anoAtualEhNumerico = false;
  while (!anoAtualEhNumerico) {
    anoAtual = window.prompt("Qual é o ano atual?");
    if (anoAtual === null) return;
    if (/^[0-9]{1,4}$/.test(anoAtual)) {
      anoAtualEhNumerico = true;
    } else {
      alert("Valor inválido! Digite novamente.");
    }
  }
  const idade = anoAtual - anoDeNascimento;
  window.alert(`Sua idade é ${idade - 1} ou ${idade}.`);
  const praticaEsporte = window.confirm("Você pratica algum esporte?");
  console.log("*** Nome:", nome);
  console.log("*** Idade:", idade - 1, "ou", idade);
  console.log("*** Pratica esporte:", praticaEsporte);
}

function checarHora() {
  const date = new Date();
  const hours = String(date.getHours()).padStart(2, "0");
  const minutes = String(date.getMinutes()).padStart(2, "0");
  const completeTime = `${hours}:${minutes}`;
  alert(completeTime);
}

function calcular() {
  let operacao = "";
  let operacaoValida = false;
  while (!operacaoValida) {
    operacao = window.prompt(
      `Qual operação você deseja fazer?\nDigite "+" para adição;\nDigite "-" para subtração;\nDigite "*" para multiplicação;\nDigite "/" para divisão.\n`
    );
    if (operacao === null) {
      return;
    }
    if (/^(\+|-|\*|\/)$/.test(operacao)) {
      operacaoValida = true;
    } else {
      alert(`Operação inválida.`);
    }
  }

  let v1 = null;
  let valorValido = false;
  while (!valorValido) {
    v1 = window.prompt("Primeiro valor da operação:");
    if (v1 === null) {
      return;
    }
    v1 = v1.replace(",", ".");
    v1 = parseFloat(v1);
    if (!isNaN(v1)) {
      valorValido = true;
    } else {
      alert("Valor inválido. Digite novamente.");
    }
  }
  let v2 = null;
  valorValido = false;
  while (!valorValido) {
    v2 = window.prompt("Segundo valor da operação:");
    if (v2 === null) {
      return;
    }
    v2 = v2.replace(",", ".");
    v2 = parseFloat(v2);
    if (!isNaN(v2)) {
      valorValido = true;
    } else {
      alert("Valor inválido. Digite novamente.");
    }
  }

  let resultado = null;
  switch (operacao) {
    case "+":
      resultado = v1 + v2;
      break;
    case "-":
      resultado = v1 - v2;
      break;
    case "*":
      resultado = v1 * v2;
      break;
    case "/":
      resultado = v1 / v2;
      break;
    default:
      alert("Operação desconhecida.");
  }
  alert(`${v1} ${operacao} ${v2} = ${resultado}`);
}

function calcularPA() {
  let valorInicial = null;
  let valorValido = false;
  while (!valorValido) {
    valorInicial = window.prompt("Valor inicial:");
    if (valorInicial === null) {
      return;
    }
    valorInicial = valorInicial.replace(",", ".");
    valorInicial = parseFloat(valorInicial);
    if (!isNaN(valorInicial)) {
      valorValido = true;
    } else {
      alert("Valor inválido. Digite novamente.");
    }
  }
  let raiz = null;
  valorValido = false;
  while (!valorValido) {
    raiz = window.prompt("Raiz da P.A:");
    if (raiz === null) {
      return;
    }
    raiz = raiz.replace(",", ".");
    raiz = parseFloat(raiz);
    if (!isNaN(raiz)) {
      valorValido = true;
    } else {
      alert("Raiz inválida. Digite novamente.");
    }
  }

  let valor = valorInicial;
  let arrValores = [];
  for (let i = 0; i < 10; i++) {
    arrValores.push(valor);
    valor += raiz;
  }
  //prettier-ignore
  alert(
    `Valor inicial = ${valorInicial}; Raiz = ${raiz}; P.A = ${arrValores.join(", ")}.`
  );
}
