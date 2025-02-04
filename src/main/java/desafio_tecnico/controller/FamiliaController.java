package desafio_tecnico.controller;

import desafio_tecnico.cadastroFamilia.Familia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import desafio_tecnico.repositorio.RepositorioDeFamilia;

@RestController
@RequestMapping("/consulta-familia")
public class FamiliaController {
    @Autowired
    private RepositorioDeFamilia repositorioDeFamilia;

    @GetMapping("/{id}")
    public ResponseEntity<Familia> consultaPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(repositorioDeFamilia.findById(id).get());
    }
}
