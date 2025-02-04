package desafio_tecnico.repositorio;

import desafio_tecnico.cadastroFamilia.Dependente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioDeDependente extends JpaRepository<Dependente, Long> {
}
