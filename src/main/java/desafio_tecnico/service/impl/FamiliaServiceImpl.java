package desafio_tecnico.service.impl;

import desafio_tecnico.dto.FamiliaDto;
import desafio_tecnico.familia.Familia;
import desafio_tecnico.mapper.DependenteMapper;
import desafio_tecnico.repositorio.RepositorioDeFamilia;
import desafio_tecnico.service.CalculadoraDePontosSomados;
import desafio_tecnico.service.FamiliaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamiliaServiceImpl implements FamiliaService {
    @Autowired
    private RepositorioDeFamilia repositorioDeFamilia;
    @Autowired
    private CalculadoraDePontosSomados calculadoraDePontosSomados;

    @Autowired
    private DependenteMapper dependenteMapper;


    @Override
    public Familia findById(Integer id) {
        return repositorioDeFamilia.findById(Long.valueOf(id))
                .orElseThrow(() -> new RuntimeException("Familia não encontrada"));
    }

    @Override
    public List<Familia> findAll() {
        return repositorioDeFamilia.findAll();
    }

    @Override
    public Familia criar(FamiliaDto obj) {
        Familia familia = new Familia();
        familia.setRendaTotalDaFamilia(obj.getRendaTotalDaFamilia());
        familia.setDependentes(dependenteMapper.toEntity(obj.getDependenteDtos(), familia));
        familia.setPontuacao(calculadoraDePontosSomados.calcularPara(familia));
        return repositorioDeFamilia.save(familia);
    }

    @Override
    public Familia atualizar(Integer id, FamiliaDto obj) {
        return null;
    }
}
