package desafio_tecnico.cadastroFamilia;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "tb_dependente")
public class Dependente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int idade;
    private String nome;
    @ManyToOne
    @JsonBackReference
    private Familia familia;

    public Dependente() {
    }
}