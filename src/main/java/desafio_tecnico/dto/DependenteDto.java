package desafio_tecnico.dto;

import desafio_tecnico.familia.Dependente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DependenteDto {
    private Long id;
    private String nome;
    private Integer idade;
}
