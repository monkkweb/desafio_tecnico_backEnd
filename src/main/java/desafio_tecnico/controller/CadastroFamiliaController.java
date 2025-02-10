package desafio_tecnico.controller;

import desafio_tecnico.dto.FamiliaResponseto;
import desafio_tecnico.familia.Familia;
import desafio_tecnico.repositorio.RepositorioDeFamilia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/familias")
public class CadastroFamiliaController {
    @Autowired
    private RepositorioDeFamilia repositorioDeFamilia;

    @PostMapping("/salvar")
    public ResponseEntity<Familia> salvar(@RequestBody Familia familia) {
        return ResponseEntity.ok(repositorioDeFamilia.save(familia));
    }

    @GetMapping("/lista")
    public List<FamiliaResponseto> listaDeFamilias() {
        return repositorioDeFamilia.findAll().stream().map(FamiliaResponseto::new).toList();
    }
}
