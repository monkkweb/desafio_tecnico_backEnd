package desafio_tecnico.repositorio;

import desafio_tecnico.familia.Dependente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioDeDependentes extends JpaRepository<Dependente, Long> {
}
