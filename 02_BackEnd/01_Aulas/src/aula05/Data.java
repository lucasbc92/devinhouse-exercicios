package aula05;

/*
Crie uma classe chamada Data que inclua três variáveis de instância — mês (tipo int), dia (tipo int) e ano (tipo int).
Apresente um método exibirData que exiba mês, dia e ano separados por barras normais (/).
Escreva um aplicativo de teste chamado TestaData que deve receber o dia, mês e ano via Scanner passar essas informações para objeto Data e posteriormente exibir a data.
*/

public class Data {
    int dia;
    int mes;
    int ano;

    String exibirData() {
        return this.dia + "/" + this.mes + "/" + this.ano;
    }
}
