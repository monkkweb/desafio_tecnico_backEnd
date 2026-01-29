package desafio_tecnico.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class DependenteDto {
    private Long id;
    private String nome;
    private Integer idade;
}
