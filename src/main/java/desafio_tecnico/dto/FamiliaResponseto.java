package desafio_tecnico.dto;

import desafio_tecnico.familia.Dependente;
import desafio_tecnico.familia.Familia;

import java.util.List;

public record FamiliaResponseto(Long id, double rendaTotalDaFamilia, List<Dependente> dependentes) {
    public FamiliaResponseto(Familia familia) {
        this(familia.getId(), familia.getRendaTotalDaFamilia(), familia.getDependentes());
    }
}
