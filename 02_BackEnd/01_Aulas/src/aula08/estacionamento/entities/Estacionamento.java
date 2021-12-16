package aula08.estacionamento.entities;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
    public enum TipoVeiculo {
        MOTO, CARRO, UTILITARIO    
    }

    private double valorHora;
    private double totalFaturamentoCarro;
    private double totalFaturamentoUtilitario;
    private double totalFaturamentoMoto;
    private double totalFaturamento;
    private List<Veiculo> veiculos;

    public Estacionamento(double valorHora){
        this.valorHora = valorHora;
        this.veiculos = new ArrayList<Veiculo>();
    }

    private Veiculo procuraVeiculo(String placa){
        for(Veiculo veiculo: this.veiculos){
            if(veiculo.getPlaca().equals(placa)){
                return veiculo;
            }
        }
        return null;
    }

    public void darEntrada(String placa, TipoVeiculo tipoVeiculo, LocalTime horaEntrada) throws Exception{
        Veiculo veiculo;

        switch(tipoVeiculo){
            case MOTO: veiculo = new Moto(placa, horaEntrada); break;
            case CARRO: veiculo = new Carro(placa, horaEntrada); break;
            case UTILITARIO: veiculo = new Utilitario(placa, horaEntrada); break;
            default: throw new Exception("O tipo do veículo é inválido"); 
        }

        this.veiculos.add(veiculo);
    }

    public double darSaida(String placa, LocalTime horaSaida){
        Veiculo veiculo = procuraVeiculo(placa);
        veiculo.setHoraSaida(horaSaida);
        veiculo.calcularValor(this.valorHora);
        double valor = veiculo.getTotalEstacionamento();

        if(veiculo instanceof Moto){
            this.totalFaturamentoMoto += valor;
        } else if(veiculo instanceof Carro){
            this.totalFaturamentoCarro += valor;
        } else if(veiculo instanceof Utilitario){
            this.totalFaturamentoUtilitario += valor;
        }
        this.totalFaturamento += valor;

        this.veiculos.remove(veiculo);

        return veiculo.getTotalEstacionamento();
    }

    public double getValorHora(){
        return this.valorHora;
    }

    public void setValorHora(double valorHora){
        this.valorHora = valorHora;
    }

    public double getTotalFaturamentoMoto(){
        return this.totalFaturamentoMoto;
    }

    public double getTotalFaturamentoCarro(){
        return this.totalFaturamentoCarro;
    }

    public double getTotalFaturamentoUtilitario(){
        return this.totalFaturamentoUtilitario;
    }

    public double getTotalFaturamento(){
        return this.totalFaturamento;
    }


}