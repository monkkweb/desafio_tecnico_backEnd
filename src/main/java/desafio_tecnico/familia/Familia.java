package desafio_tecnico.familia;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(of = "id")
@Table(name = "tb_familias")
public class Familia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double rendaTotalDaFamilia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "familia")
    @JsonManagedReference
    private List<Dependente> dependentes;

}
