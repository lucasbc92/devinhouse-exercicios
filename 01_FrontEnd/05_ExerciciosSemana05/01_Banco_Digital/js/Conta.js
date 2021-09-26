class Conta {
  constructor(conta) {
    this.numero = conta.numero;
    this.saldo = 0;
    this.cliente = conta.cliente;
  }
}

{
  const endereco = new Endereco({
    logradouro: "Rua Felipe Schmidt",
    numero: "427",
    cidade: "Florianópolis",
    estado: "sdasasda",
    pais: "Brasil",
    cep: "88085-160",
  });

  const cliente = new Cliente({
    nome: "Lucas Bueno Cesario",
    cpf: "123456789012",
    endereco,
    celular: "(48)987654321",
  });

  const conta = new Conta({
    numero: "12345-6",
    cliente,
  });

  console.log(conta);
}
