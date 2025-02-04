package desafio_tecnico.cadastroFamilia;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "tb_familias")
public class Familia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double rendaTotalDaFamilia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "familia")
    @JsonManagedReference
    private List<Dependente> dependentes;

    public Familia() {}
}
