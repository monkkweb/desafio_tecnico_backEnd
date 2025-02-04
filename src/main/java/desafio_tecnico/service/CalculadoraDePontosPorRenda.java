package desafio_tecnico.service;

import desafio_tecnico.cadastroFamilia.Familia;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CalculadoraDePontosPorRenda {

    private final Familia familia;

    public int calcular() {
        var rendaTotal = familia.getRendaTotalDaFamilia();

        if (rendaTotal <= 900)
            return 5;
        else if (rendaTotal > 901 && rendaTotal <= 1500)
            return 3;
        else return 0;
    }
}