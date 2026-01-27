package desafio_tecnico.dto;

import desafio_tecnico.familia.Dependente;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

//TODO: Ver quais anotações deve ser usadas aqui.
public class DependenteDto {

    private Long id;
    //mudar essa lista
    private List<Dependente> nomeMembro;
    private Integer idade;
}
