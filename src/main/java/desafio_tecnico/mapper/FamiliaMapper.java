package desafio_tecnico.mapper;

import desafio_tecnico.dto.FamiliaDto;
import desafio_tecnico.familia.Familia;
import desafio_tecnico.service.CalculadoraDePontosPorDependentes;

public record FamiliaMapper(DependenteMapper dependenteMapper,
                            CalculadoraDePontosPorDependentes calculadoraDePontosPorDependentes) {

    public Familia toEntity(FamiliaDto dto) {
        Familia familia = new Familia();
        familia.setRendaTotalDaFamilia(dto.getRendaTotalDaFamilia());
        if (dto.getDependenteDtos() != null) {
            familia.setDependentes(dependenteMapper.toEntity(dto.getDependenteDtos(), familia));
        }
        familia.setPontuacao(dto.getPontuacao());
        return familia;
    }

    public Familia updateEntity(Familia familia, FamiliaDto familiaDto) {
        familia.setRendaTotalDaFamilia(familiaDto.getRendaTotalDaFamilia());
        if (familiaDto.getDependenteDtos() != null) {
            familia.setDependentes(dependenteMapper.toEntity(familiaDto.getDependenteDtos(), familia));
        }
        familia.setPontuacao(familiaDto.getPontuacao());
        return familia;
    }
}