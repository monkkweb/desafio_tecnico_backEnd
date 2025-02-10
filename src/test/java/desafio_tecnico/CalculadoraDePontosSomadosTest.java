package desafio_tecnico;

import desafio_tecnico.familia.Dependente;
import desafio_tecnico.familia.Familia;
import org.instancio.Instancio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import desafio_tecnico.service.CalculadoraDePontosPorDependentes;
import desafio_tecnico.service.CalculadoraDePontosPorRenda;
import desafio_tecnico.service.CalculadoraDePontosSomados;

import static org.instancio.Select.field;

class CalculadoraDePontosSomadosTest {

    @Test
    void deve_somar_os_pontos_por_dependente_e_por_renda() {
        var calculosEsperado = 8;
        var renda = 900;
        var dependentes = Instancio.ofList(Dependente.class).size(3).set(field(Dependente::getIdade), 10).create();
        var cadastro = new Familia(1L, renda, dependentes);
        var calculadora = new CalculadoraDePontosSomados(new CalculadoraDePontosPorRenda(cadastro), new CalculadoraDePontosPorDependentes(cadastro));

        var resultado = calculadora.calcular();

        Assertions.assertEquals(calculosEsperado, resultado);
    }
}