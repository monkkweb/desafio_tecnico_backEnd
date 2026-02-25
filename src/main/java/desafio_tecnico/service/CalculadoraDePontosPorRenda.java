package desafio_tecnico.service;

import desafio_tecnico.familia.Familia;
import org.springframework.stereotype.Component;

@Component
public class CalculadoraDePontosPorRenda {

    private static final int PONTOS_RENDA_ATE_900 = 5;
    private static final int PONTOS_RENDA_ATE_1500 = 3;
    private static final double LIMITE_RENDA_BAIXA = 900;
    private static final double LIMITE_RENDA_ALTA = 1500;

    public int calcular(Familia familia) {
        var rendaTotal = familia.getRendaTotalDaFamilia();

        if (rendaTotal <= LIMITE_RENDA_BAIXA)
            return PONTOS_RENDA_ATE_900;
        if (rendaTotal <= LIMITE_RENDA_ALTA)
            return PONTOS_RENDA_ATE_1500;
        return 0;
    }
}