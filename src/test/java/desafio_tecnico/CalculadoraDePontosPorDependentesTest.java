package desafio_tecnico;

import desafio_tecnico.familia.Dependente;
import desafio_tecnico.familia.Familia;
import org.instancio.Instancio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import desafio_tecnico.service.CalculadoraDePontosPorDependentes;

import java.util.List;

import static org.instancio.Select.field;

@ExtendWith(MockitoExtension.class)
class CalculadoraDePontosPorDependentesTest {

    @Mock
    private Familia cadastro;
    @InjectMocks
    private CalculadoraDePontosPorDependentes calculadora;
    private List<Dependente> dependentes;

    @BeforeEach
    void setup() {
        dependentes = Instancio.ofList(Dependente.class).size(3).set(field(Dependente::getIdade), 10).create();
    }

    @Test
    void deve_pontuar_tres_pontos_caso_tenha_mais_de_dois_dependentes() {
        var esperado = 3;
        Mockito.when(cadastro.getDependentes()).thenReturn(dependentes);

        var resultado = calculadora.calcular();

        Assertions.assertEquals(esperado, resultado);
    }

    @Test
    void deve_pontuar_dois_pontos_caso_tenha_um_ou_dois_dependentes() {
        var pontosEsperados = 2;
        dependentes = Instancio.ofList(Dependente.class).size(2).set(field(Dependente::getIdade), 10).create();
        Mockito.when(cadastro.getDependentes()).thenReturn(dependentes);

        var resultado = calculadora.calcular();

        Assertions.assertEquals(pontosEsperados, resultado);
    }

    @Test
    void deve_pontuar_zero_pontos_pois_dependentes_sao_maior_de_idade_e_nao_sao_considerados_dependente() {
        var pontosEsperados = 0;
        dependentes = Instancio.ofList(Dependente.class).set(field(Dependente::getIdade), 18).create();
        Mockito.when(cadastro.getDependentes()).thenReturn(dependentes);

        var resultado = calculadora.calcular();

        Assertions.assertEquals(pontosEsperados, resultado);
    }
}