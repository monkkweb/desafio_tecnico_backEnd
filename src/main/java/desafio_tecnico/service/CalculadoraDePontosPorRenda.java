package desafio_tecnico.service;

import desafio_tecnico.familia.Familia;
import org.springframework.stereotype.Component;

@Component
public class CalculadoraDePontosPorRenda {

    public int calcular(Familia familia) {
        var rendaTotal = familia.getRendaTotalDaFamilia();

        if (rendaTotal < 901)
            return 5;
        if (rendaTotal >= 901 && rendaTotal <= 1500)
            return 3;
        return 0;

    }

}