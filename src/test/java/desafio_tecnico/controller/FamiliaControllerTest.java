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

import java.util.Optional;

import static org.instancio.Select.field;
import static org.mockito.Mockito.when;

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

        var response = cadastro.salvar(familia);

        Assertions.assertEquals(ResponseEntity.ok(repositorio.save(familia)), response);
    }

    @Test
    void deve_retornar_a_familia_pelo_id() {
        var familia = Instancio.of(Familia.class).set(field(Familia::getId), 1L).create();
        when(repositorio.findById(1L)).thenReturn(Optional.of(familia));

        var response = cadastro.consultaFamilia(1L);

        Assertions.assertEquals(familia, response.getBody());
    }

}