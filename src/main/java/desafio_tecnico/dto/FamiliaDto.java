package desafio_tecnico.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class FamiliaDto {
    private Long Id;
    private List<DependenteDto> dependenteDtos;
    private double rendaTotalDaFamilia;
    private Integer pontuacao;

}
