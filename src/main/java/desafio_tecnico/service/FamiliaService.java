package desafio_tecnico.service;

import desafio_tecnico.dto.FamiliaDto;
import desafio_tecnico.familia.Familia;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FamiliaService {
    Familia findById(Integer id);

    List<Familia> findAll();

    Familia criar(FamiliaDto obj);

    Familia atualizar(Integer id, FamiliaDto obj);
}
