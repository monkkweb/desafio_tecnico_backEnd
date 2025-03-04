package desafio_tecnico;

import desafio_tecnico.familia.Dependente;
import desafio_tecnico.familia.Familia;
import desafio_tecnico.service.CalculadoraDePontosPorDependentes;
import org.instancio.Instancio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.instancio.Select.field;

@ExtendWith(MockitoExtension.class)
class CalculadoraDePontosPorDependentesTest {

    private List<Dependente> dependentes;
    @Mock
    private Familia familia;
    @InjectMocks
    private CalculadoraDePontosPorDependentes calculadora;

    @BeforeEach
    void setup() {
        dependentes = Instancio.ofList(Dependente.class).size(3).set(field(Dependente::getIdade), 10).create();
    }

    @Test
    void deve_pontuar_tres_pontos_caso_tenha_mais_de_dois_dependentes() {
        Mockito.when(familia.getDependentes()).thenReturn(dependentes);

        var resultado = calculadora.calcular(familia);

        Assertions.assertEquals(3, resultado);
    }

    @Test
    void deve_pontuar_dois_pontos_caso_tenha_um_ou_dois_dependentes() {
        dependentes = Instancio.ofList(Dependente.class).size(2).set(field(Dependente::getIdade), 10).create();
        Mockito.when(familia.getDependentes()).thenReturn(dependentes);

        var resultado = calculadora.calcular(familia);

        Assertions.assertEquals(2, resultado);
    }

    @Test
    void deve_pontuar_zero_pontos_pois_dependentes_sao_maior_de_idade_e_nao_sao_considerados_dependente() {
        dependentes = Instancio.ofList(Dependente.class).set(field(Dependente::getIdade), 18).create();
        Mockito.when(familia.getDependentes()).thenReturn(dependentes);

        var resultado = calculadora.calcular(familia);

        Assertions.assertEquals(0, resultado);
    }
}