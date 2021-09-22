const enumEstados = Object.freeze({
  AC: "Acre",
  AL: "Alagoas",
  AP: "Amapá",
  AM: "Amazonas",
  BA: "Bahia",
  CE: "Ceará",
  DF: "Distrito Federal",
  ES: "Espírito Santo",
  GO: "Goiás",
  MA: "Maranhão",
  MT: "Mato Grosso",
  MS: "Mato Grosso do Sul",
  MG: "Minas Gerais",
  PA: "Pará",
  PB: "Paraíba",
  PR: "Paraná",
  PE: "Pernambuco",
  PI: "Piauí",
  RJ: "Rio de Janeiro",
  RN: "Rio Grande do Norte",
  RS: "Rio Grande do Sul",
  RO: "Rondônia",
  RR: "Roraima",
  SC: "Santa Catarina",
  SP: "São Paulo",
  SE: "Sergipe",
  TO: "Tocantins",
});

class Endereco {
  constructor(endereco) {
    this.logradouro = endereco.logradouro;
    this.numero = endereco.numero;
    this.cidade = endereco.cidade;
    this.estado = this.#validarEstado(endereco.estado);
    this.pais = endereco.pais;
    this.cep = endereco.cep;
  }

  #validarEstado(estado) {
    const exists = Object.values(enumEstados).some(function (k) {
      return k === estado;
    });
    if (exists) return estado;
    else {
      alert("Estado inválido!");
      return false;
    }
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
}

{
  const endereco = new Endereco({
    logradouro: "Rua Professora Rosinha Campos",
    numero: "427",
    cidade: "Florianópolis",
    estado: "sdsads",
    pais: "Brasil",
    cep: "88085-160",
  });
  console.log(endereco);
}
