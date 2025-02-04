package desafio_tecnico.service;

import desafio_tecnico.cadastroFamilia.Familia;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CalculadoraDePontosPorDependentes {
    private final Familia familia;

    public int calcular() {
        var quantidadeDeDependentes = familia.getDependentes().stream().filter(dependente -> dependente.getIdade() < 18).toList()
                .size();
        if (quantidadeDeDependentes >= 3)
            return 3;
        if (quantidadeDeDependentes >= 1)
            return 2;
        return 0;
    }
}
