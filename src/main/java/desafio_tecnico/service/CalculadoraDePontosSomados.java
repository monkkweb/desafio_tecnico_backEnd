package desafio_tecnico.service;

import desafio_tecnico.familia.Familia;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CalculadoraDePontosSomados {
    private final CalculadoraDePontosPorRenda calculadoraDePontosPorRenda;
    private final CalculadoraDePontosPorDependentes calculadoraDePontosPorDependentes;

    public int calcularPara(Familia familia) {
        var pontosPorRenda = calculadoraDePontosPorRenda.calcular(familia);
        var pontosPorDependentes = calculadoraDePontosPorDependentes.calcular(familia);
        return pontosPorRenda + pontosPorDependentes;

    }
}
