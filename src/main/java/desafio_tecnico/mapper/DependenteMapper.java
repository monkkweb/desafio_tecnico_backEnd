package desafio_tecnico.mapper;

import desafio_tecnico.dto.DependenteDto;
import desafio_tecnico.familia.Dependente;
import desafio_tecnico.familia.Familia;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DependenteMapper {
    public List<Dependente> toEntity(List<DependenteDto> dependentesDto, Familia familia) {
        return dependentesDto.stream().map(dto -> {
            Dependente dependente = new Dependente();
            dependente.setNome(dto.getNome());
            dependente.setIdade(dto.getIdade());
            dependente.setFamilia(familia);
            return dependente;
        }).collect(Collectors.toList());
    }
}