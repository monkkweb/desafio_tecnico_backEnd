package desafio_tecnico.dto;

import desafio_tecnico.familia.Dependente;
import lombok.Data;

import java.util.List;

//TODO: Ver quais anotações deve ser usadas aqui.
public class FamiliDto {

    private List<DependenteDto> nomeDoMembros;
    private List<DependenteDto> idadeDoMembro;
    private double rendaTotalDaFamilia;
    private Integer pontuacao;

}
