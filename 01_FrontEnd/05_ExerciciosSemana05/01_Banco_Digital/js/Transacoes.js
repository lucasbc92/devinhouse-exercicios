let id = 0;

class Transacoes {
  constructor(conta, valorDaTransacao, destinatario = null) {
    this.idDeTransferencia = id;
    this.numeroContaDestinatarioTransferencia = destinatario;
    this.conta = conta;
    this.valorDaTransacao = valorDaTransacao;
    this.data = new Date();
  }

  #verificarValor() {
    if (this.valorDaTransacao <= 300) {
      return true;
    } else return false;
  }

  transferir() {
    if (this.#verificarValor()) {
      if (this.conta.saldo >= this.valorDaTransacao) {
        this.conta.saldo -= this.valorDaTransacao;
        this.idDeTransferencia = id;
        id++;
        return this.conta.saldo;
      } else return -2;
    } else return -1;
  }

  depositar() {
    if (this.#verificarValor()) {
      this.conta.saldo += this.valorDaTransacao;
      return this.conta.saldo;
    } else return -1;
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
    cpf: "10465589642",
    endereco,
    celular: "(48)991224064",
  });

  const conta = new Conta({
    numero: "59221-8",
    cliente,
  });

  const transacoes = new Transacoes(conta, 200, "12345-6");
  transacoes.depositar();

  console.log(transacoes);
}
