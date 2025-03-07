package desafio_tecnico.repositorio;

import desafio_tecnico.familia.Dependente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioDeDependentes extends JpaRepository<Dependente, Long> {
    List<Dependente> findByIdadeLessThan(int idade);
}
