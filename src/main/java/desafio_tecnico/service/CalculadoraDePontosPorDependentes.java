package desafio_tecnico.service;

import desafio_tecnico.familia.Familia;
import org.springframework.stereotype.Component;

@Component
public class CalculadoraDePontosPorDependentes {

    public int calcular(Familia familia) {
        var quantidadeDeDependentes = familia.getDependentes().stream()
                .filter(dependente -> dependente.getIdade() < 18)
                .toList().size();
        if (quantidadeDeDependentes >= 3)
            return 3;
        if (quantidadeDeDependentes >= 1)
            return 2;
        return 0;
    }
}
