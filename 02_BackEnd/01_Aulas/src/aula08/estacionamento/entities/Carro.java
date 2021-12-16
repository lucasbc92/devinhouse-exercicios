package aula08.estacionamento.entities;

import java.time.LocalTime;

public class Carro extends Veiculo {
    private final double FATOR_ESTACIONAMENTO = 1;

    public Carro(String placa, LocalTime horaEntrada) {
        super(placa, horaEntrada);
        this.setFatorEstacionamento(FATOR_ESTACIONAMENTO);
    }
}