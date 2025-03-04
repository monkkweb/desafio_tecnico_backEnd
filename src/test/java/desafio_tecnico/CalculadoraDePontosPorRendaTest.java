package desafio_tecnico;

import desafio_tecnico.familia.Familia;
import desafio_tecnico.service.CalculadoraDePontosPorRenda;
import org.instancio.Instancio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.instancio.Select.field;

@ExtendWith(MockitoExtension.class)
class CalculadoraDePontosPorRendaTest {

    @InjectMocks
    private CalculadoraDePontosPorRenda calculadora;

    @Test
    void deve_pontuar_cinco_pontos_caso_renda_total_da_familia_seja_ate_novecentos() {
        var familia = Instancio.of(Familia.class)
                .generate(field(Familia::getRendaTotalDaFamilia), gen -> gen.doubles().min(0d).max(900d))
                .create();

        var resultado = calculadora.calcular(familia);

        Assertions.assertEquals(5, resultado);
    }

    @Test
    void deve_pontuar_tres_pontos_caso_renda_total_da_familia_seja_entre_novecentos_e_um_ah_mil_e_quientos() {
        var familia = Instancio.of(Familia.class)
                .generate(field(Familia::getRendaTotalDaFamilia), gen -> gen.doubles().min(901d).max(1500d))
                .create();

        var pontos = calculadora.calcular(familia);

        Assertions.assertEquals(3, pontos);
    }

    @Test
    void deve_pontuar_zero_pontos_caso_renda_total_da_familia_seja_maior_que_1500() {
        var familia = Instancio.of(Familia.class)
                .generate(field(Familia::getRendaTotalDaFamilia), gen -> gen.doubles().min(1500.01d))
                .create();

        var pontos = calculadora.calcular(familia);

        Assertions.assertEquals(0, pontos);
    }

}
