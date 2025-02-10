package desafio_tecnico.controller;

import desafio_tecnico.familia.Familia;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import desafio_tecnico.service.CalculadoraDePontosPorDependentes;
import desafio_tecnico.service.CalculadoraDePontosPorRenda;
import desafio_tecnico.service.CalculadoraDePontosSomados;

@RestController
@RequestMapping("/pontos-somados")
public class CalculadoraDePontosSomadosController {

    @PostMapping("/calcular")
    public int calcular(@RequestBody Familia familia) {
        var calculadoraPorDependentes = new CalculadoraDePontosPorDependentes(familia);
        var calculadoraPorRenda = new CalculadoraDePontosPorRenda(familia);
        var calculadoraDePontosSomados = new CalculadoraDePontosSomados(calculadoraPorRenda, calculadoraPorDependentes);
        return calculadoraDePontosSomados.calcular();
    }
}