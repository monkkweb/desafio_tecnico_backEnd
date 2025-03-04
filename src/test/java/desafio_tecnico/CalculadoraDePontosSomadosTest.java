package desafio_tecnico;

import desafio_tecnico.familia.Familia;
import desafio_tecnico.service.CalculadoraDePontosPorDependentes;
import desafio_tecnico.service.CalculadoraDePontosPorRenda;
import desafio_tecnico.service.CalculadoraDePontosSomados;
import org.instancio.Instancio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CalculadoraDePontosSomadosTest {
    @Mock
    private CalculadoraDePontosPorRenda calculadoraDePontosPorRenda;
    @Mock
    private CalculadoraDePontosPorDependentes calculadoraDePontosPorDependentes;
    @InjectMocks
    private CalculadoraDePontosSomados calculadora;

    @Test
    void deve_somar_os_pontos_por_dependente_e_por_renda() {
        var familia = Instancio.create(Familia.class);
        Mockito.when(calculadoraDePontosPorRenda.calcular(familia)).thenReturn(5);
        Mockito.when(calculadoraDePontosPorDependentes.calcular(familia)).thenReturn(3);

        var resultado = calculadora.calcularPara(familia);

        Assertions.assertEquals(8, resultado);
    }
}