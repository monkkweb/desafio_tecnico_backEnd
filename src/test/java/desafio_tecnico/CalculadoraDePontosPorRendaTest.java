package desafio_tecnico;

import desafio_tecnico.familia.Dependente;
import desafio_tecnico.familia.Familia;
import org.instancio.Instancio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import desafio_tecnico.service.CalculadoraDePontosPorRenda;

class CalculadoraDePontosPorRendaTest {
    @Test
    void deve_pontuar_cinco_pontos_caso_renda_total_da_familia_seja_ate_novecentos() {
        var pontosEsperados = 5;
        var renda = 900;
        var dependente = Instancio.ofList(Dependente.class).size(0).create();
        var calculadora = new CalculadoraDePontosPorRenda(new Familia(1L, renda, dependente));

        var resultado = calculadora.calcular();

        Assertions.assertEquals(pontosEsperados, resultado);
    }

    @Test
    void deve_pontuar_tres_pontos_caso_renda_total_da_familia_seja_entre_novecentos_e_um_ah_mil_e_quientos() {
        var pontosEsperados = 3;
        var renda = 1000;
        var dependente = Instancio.ofList(Dependente.class).size(0).create();
        var calculadora = new CalculadoraDePontosPorRenda(new Familia(1L, renda, dependente));

        var resultado = calculadora.calcular();

        Assertions.assertEquals(pontosEsperados, resultado);
    }

}
