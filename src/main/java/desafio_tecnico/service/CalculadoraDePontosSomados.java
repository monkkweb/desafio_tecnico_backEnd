package desafio_tecnico.service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CalculadoraDePontosSomados {
    private final CalculadoraDePontosPorRenda calculadoraDePontosPorRenda;
    private final CalculadoraDePontosPorDependentes calculadoraDePontosPorDependentes;

    public int calcular() {
        return calculadoraDePontosPorRenda.calcular() + calculadoraDePontosPorDependentes.calcular();

    }
}
