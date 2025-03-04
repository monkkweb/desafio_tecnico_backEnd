package desafio_tecnico.controller;

import desafio_tecnico.familia.Familia;
import desafio_tecnico.repositorio.RepositorioDeFamilia;
import desafio_tecnico.service.CalculadoraDePontosSomados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/familias")
public class FamiliaController {
    @Autowired
    private RepositorioDeFamilia repositorioDeFamilia;
    @Autowired
    private CalculadoraDePontosSomados calculadoraDePontos;

    @PostMapping("/salvar")
    public ResponseEntity<?> salvar(@RequestBody Familia familia) {
        return ResponseEntity.ok(repositorioDeFamilia.save(familia));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Familia>> listaDeFamilias() {
        List<Familia> familias = repositorioDeFamilia.findAll();

        familias.forEach(familia -> {
            Integer novaPontuacao = calculadoraDePontos.calcularPara(familia);

            if (familia.getPontuacao() == null || !familia.getPontuacao().equals(novaPontuacao)) {
                familia.setPontuacao(novaPontuacao);
                repositorioDeFamilia.save(familia);
            }
        });
        return ResponseEntity.ok(familias);
    }

    @GetMapping("/consulta-familia/{id}")
    public ResponseEntity<?> consultaFamilia(@PathVariable("id") Long id) {
        return ResponseEntity.ok(repositorioDeFamilia.findById(id).get());
    }

}