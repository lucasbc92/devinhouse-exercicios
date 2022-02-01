package aula08.estacionamento.entities;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Veiculo {
    private double fatorEstacionamento;
    private String placa;
    private LocalTime horaEntrada;
    private LocalTime horaSaida;
    private double totalEstacionamento;
    
    public Veiculo(String placa, LocalTime horaEntrada){
        this.placa = placa;
        this.horaEntrada = horaEntrada;
    }

    public void calcularValor(double valorHora) {
        double tempoPermanencia = Math.ceil((double)this.horaEntrada.until(horaSaida, ChronoUnit.MINUTES) / 60);
        this.totalEstacionamento = valorHora * tempoPermanencia * fatorEstacionamento;
    }

    public String getPlaca(){
        return this.placa;
    }

    public double getFatorEstacionamento(){
        return this.fatorEstacionamento;
    }

    public void setHoraSaida(LocalTime horaSaida){
        this.horaSaida = horaSaida;
    }

    public void setFatorEstacionamento(double fatorEstacionamento){
        this.fatorEstacionamento = fatorEstacionamento;
    }

    public double getTotalEstacionamento(){
        return this.totalEstacionamento;
    }

    public void setTotalEstacionamento(double totalEstacionamento){
        this.totalEstacionamento = totalEstacionamento;
    }
}