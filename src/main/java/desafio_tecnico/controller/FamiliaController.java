package desafio_tecnico.controller;

import desafio_tecnico.dto.FamiliaDto;
import desafio_tecnico.familia.Familia;
import desafio_tecnico.service.FamiliaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/familias")
public class FamiliaController {

    @Autowired
    private FamiliaService familiaService;

    @PostMapping("/salvar")
    public ResponseEntity<Familia> salvar(@RequestBody FamiliaDto familiaDto) {
        Familia familiaSalva = familiaService.criar(familiaDto);
        return ResponseEntity.ok(familiaSalva);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Familia>> listaDeFamilias() {
        List<Familia> familias = familiaService.findAll();
        return ResponseEntity.ok(familias);
    }

    @GetMapping("/consulta-familia/{id}")
    public ResponseEntity<Familia> consultaFamilia(@PathVariable("id") Integer id) {
        Familia familia = familiaService.findById(id);
        return ResponseEntity.ok(familia);
    }
}
