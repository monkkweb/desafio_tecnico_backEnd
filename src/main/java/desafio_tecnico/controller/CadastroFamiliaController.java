package desafio_tecnico.controller;

import desafio_tecnico.cadastroFamilia.Familia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import desafio_tecnico.repositorio.RepositorioDeFamilia;

import java.util.List;

@RestController
@RequestMapping("/familias")
public class CadastroFamiliaController {
    @Autowired
    private RepositorioDeFamilia repositorioDeFamilia;

    @GetMapping("/lista")
    public List<Familia> listaDeFamilias() {
        List<Familia> familias = repositorioDeFamilia.findAll();
        return familias;
    }
}
