package desafio_tecnico.controller;

import desafio_tecnico.familia.Dependente;
import desafio_tecnico.familia.Familia;
import desafio_tecnico.repositorio.RepositorioDeFamilia;
import org.instancio.Instancio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class FamiliaControllerTest {
    @Mock
    private RepositorioDeFamilia repositorio;
    @InjectMocks
    private FamiliaController cadastro;

    @Test
    void deve_salvar_no_repositorio_os_dependentes_com_ah_renda_da_familia() {
        var dependentes = Instancio.createList(Dependente.class);
        var familia = new Familia(1L, 1200d, dependentes, 1);
        var responseEsperado = ResponseEntity.ok(repositorio.save(familia));

        var response = cadastro.salvar(familia);

        Assertions.assertEquals(responseEsperado, response);
    }

}