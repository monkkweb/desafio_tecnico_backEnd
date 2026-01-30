package desafio_tecnico.controller;

import desafio_tecnico.dto.FamiliaDto;
import desafio_tecnico.familia.Familia;
import desafio_tecnico.service.FamiliaService;
import org.instancio.Instancio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.instancio.Select.field;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FamiliaControllerTest {
    @Mock
    private FamiliaService familiaService;
    @InjectMocks
    private FamiliaController controller;

    @Test
    void deve_salvar_uma_familia_corretamente() {
        // Cenário
        var familiaDto = Instancio.create(FamiliaDto.class);
        var familiaSalva = Instancio.create(Familia.class);
        
        // O service retorna a entidade
        when(familiaService.criar(any(FamiliaDto.class))).thenReturn(familiaSalva);

        // Ação
        var response = controller.salvar(familiaDto);

        // Verificação
        // O controller deve retornar um DTO com os dados da entidade salva
        Assertions.assertEquals(200, response.getStatusCodeValue());
        Assertions.assertEquals(familiaSalva.getId(), response.getBody().getId());
        Assertions.assertEquals(familiaSalva.getRendaTotalDaFamilia(), response.getBody().getRendaTotalDaFamilia());
    }

    @Test
    void deve_retornar_a_familia_pelo_id() {
        // Cenário
        var familia = Instancio.of(Familia.class).set(field(Familia::getId), 1L).create();
        
        when(familiaService.findById(1)).thenReturn(familia);

        // Ação
        var response = controller.consultaFamilia(1);

        // Verificação
        Assertions.assertEquals(200, response.getStatusCodeValue());
        Assertions.assertEquals(familia.getId(), response.getBody().getId());
    }
}
