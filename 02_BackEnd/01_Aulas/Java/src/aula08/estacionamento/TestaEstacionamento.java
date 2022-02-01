package aula08.estacionamento;

import java.time.LocalTime;
import java.util.Scanner;

import aula08.estacionamento.entities.Estacionamento;
import aula08.estacionamento.entities.Estacionamento.TipoVeiculo;

public class TestaEstacionamento {
    private static Scanner entrada = new Scanner(System.in);

    private static void darEntrada(Estacionamento estacionamento) throws Exception{
        entrada.nextLine();
        System.out.println("Entre com a placa do veículo: ");
        String placa = entrada.nextLine();
        System.out.printf("Entre com o tipo do veículo:%nDigite 'm' para Moto;%nDigite 'c' para Carro;%nDigite 'u' para Utilitário.%n");
        String tipoVeiculoStr = entrada.nextLine();
        TipoVeiculo tipoVeiculo;
        switch(tipoVeiculoStr){
            case "m": tipoVeiculo = TipoVeiculo.MOTO; break;
            case "c": tipoVeiculo = TipoVeiculo.CARRO; break;
            case "u": tipoVeiculo = TipoVeiculo.UTILITARIO; break;
            default: throw new Exception("Tipo de carro inválido.");
        }
        System.out.println("Entre com a hora de entrada no formato hh:mm");
        String horaStr = entrada.nextLine();
        String[] horaMinutos = horaStr.split(":");
        int hora = Integer.parseInt(horaMinutos[0]);
        int minutos = Integer.parseInt(horaMinutos[1]);
        LocalTime horaEntrada = LocalTime.of(hora, minutos);
        estacionamento.darEntrada(placa, tipoVeiculo, horaEntrada);        
    }

    private static double darSaida(Estacionamento estacionamento){
        entrada.nextLine();
        System.out.println("Entre com a placa do veículo: ");
        String placa = entrada.nextLine();
        System.out.println("Entre com a hora de saída no formato hh:mm");
        String horaStr = entrada.nextLine();
        String[] horaMinutos = horaStr.split(":");
        int hora = Integer.parseInt(horaMinutos[0]);
        int minutos = Integer.parseInt(horaMinutos[1]);
        LocalTime horaSaida = LocalTime.of(hora, minutos);
        return estacionamento.darSaida(placa, horaSaida);        
    }

    public static void main(String[] args) {
        int opcao = 1;
        System.out.println("Digite o valor da hora para iniciar o estacionamento:");
        double valorHora = entrada.nextDouble();

        Estacionamento estacionamento = new Estacionamento(valorHora);
        
        do {
            System.out.println("Entre com a opção desejada:");
            System.out.println("1 - Entrada de veículo");
            System.out.println("2 - Saída de veículo");
            System.out.println("3 - Faturamento por moto");
            System.out.println("4 - Faturamento por carro");
            System.out.println("5 - Faturamento por utilitário");
            System.out.println("6 - Faturamento total");
            System.out.println("7 - Sair");
            opcao = entrada.nextInt();
            switch(opcao) {
                case 1: try { 
                    darEntrada(estacionamento);
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    break;
                }
                case 2: System.out.printf("O valor a ser pago é: $%.2f%n", darSaida(estacionamento)); break;
                case 3: System.out.printf("O faturamento total por moto é de $%.2f%n", estacionamento.getTotalFaturamentoMoto()); break;
                case 4: System.out.printf("O faturamento total por carro é de $%.2f%n", estacionamento.getTotalFaturamentoCarro()); break;
                case 5: System.out.printf("O faturamento total por utilitário é de $%.2f%n", estacionamento.getTotalFaturamentoUtilitario()); break;
                case 6: System.out.printf("O faturamento total é de $%.2f%n", estacionamento.getTotalFaturamento()); break;
                case 7: break;
                default: System.out.println("Opção inválida. Entre um número de 1 a 7.");
            }
        } while(opcao != 7);
        System.out.println("Saindo do programa...");
        entrada.close();        
    }
}
