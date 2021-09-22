class Conta {
  constructor(conta) {
    this.numero = conta.numero;
    this.saldo = 0;
    this.cliente = conta.cliente;
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
    cpf: "123456789012",
    endereco,
    celular: "(48)991224064",
  });

  const conta = new Conta({
    numero: "59221-8",
    cliente,
  });

  console.log(conta);
}
