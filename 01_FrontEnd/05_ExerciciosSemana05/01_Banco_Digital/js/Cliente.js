class Cliente {
  constructor(cliente) {
    this.nome = cliente.nome;
    this.cpf = this.#validarCpf(cliente.cpf);
    this.endereco = cliente.endereco;
    this.celular = cliente.celular;
  }

  #validarCpf(cpf) {
    let soma = 0;
    let resto;

    cpf = cpf.replaceAll(".", "");
    cpf = cpf.replaceAll("-", "");

    console.log(cpf);

    if (cpf == "00000000000") {
      alert("CPF inválido!");
      return "";
    }

    for (let i = 1; i <= 9; i++)
      soma = soma + parseInt(cpf.substring(i - 1, i)) * (11 - i);
    resto = (soma * 10) % 11;

    if (resto == 10 || resto == 11) resto = 0;
    if (resto != parseInt(cpf.substring(9, 10))) {
      alert("CPF inválido!");
      return "";
    }

    soma = 0;
    for (let i = 1; i <= 10; i++)
      soma = soma + parseInt(cpf.substring(i - 1, i)) * (12 - i);
    resto = (soma * 10) % 11;

    if (resto == 10 || resto == 11) resto = 0;
    if (resto != parseInt(cpf.substring(10, 11))) {
      alert("CPF inválido!");
      return "";
    }
    return cpf;
  }
}

{
  const endereco = new Endereco({
    logradouro: "Rua Professora Rosinha Campos",
    numero: "427",
    cidade: "Florianópolis",
    estado: "Santa Catarina",
    pais: "Brasil",
    cep: "88085-160",
  });

  const cliente = new Cliente({
    nome: "Lucas Bueno Cesario",
    cpf: "075.438.889-12",
    endereco,
    celular: "(48)991224064",
  });
}
