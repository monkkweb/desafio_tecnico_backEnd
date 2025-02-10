package desafio_tecnico.repositorio;

import desafio_tecnico.familia.Familia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioDeFamilia extends JpaRepository<Familia, Long> {
}