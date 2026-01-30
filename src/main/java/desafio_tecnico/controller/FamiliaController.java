package desafio_tecnico.controller;

import desafio_tecnico.dto.DependenteDto;
import desafio_tecnico.dto.FamiliaDto;
import desafio_tecnico.familia.Familia;
import desafio_tecnico.service.FamiliaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/familias")
public class FamiliaController {

    @Autowired
    private FamiliaService familiaService;

    @PostMapping("/salvar")
    public ResponseEntity<FamiliaDto> salvar(@RequestBody FamiliaDto familiaDto) {
        Familia familiaSalva = familiaService.criar(familiaDto);
        return ResponseEntity.ok(converterParaDto(familiaSalva));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<FamiliaDto>> listaDeFamilias() {
        List<Familia> familias = familiaService.findAll();
        List<FamiliaDto> familiaDto = familias.stream()
                .map(this::converterParaDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(familiaDto);
    }

    @GetMapping("/consulta-familia/{id}")
    public ResponseEntity<FamiliaDto> consultaFamilia(@PathVariable("id") Integer id) {
        Familia familia = familiaService.findById(id);
        return ResponseEntity.ok(converterParaDto(familia));
    }

    // Método auxiliar privado para não poluir o código e não mexer no Mapper externo
    private FamiliaDto converterParaDto(Familia familia) {
        FamiliaDto dto = new FamiliaDto();
        dto.setId(familia.getId());
        dto.setRendaTotalDaFamilia(familia.getRendaTotalDaFamilia());
        dto.setPontuacao(familia.getPontuacao());

        if (familia.getDependentes() != null) {
            List<DependenteDto> dependentesDto = familia.getDependentes().stream()
                    .map(dep -> new DependenteDto(dep.getId(), dep.getNome(), dep.getIdade()))
                    .collect(Collectors.toList());
            dto.setDependenteDtos(dependentesDto);
        }
        return dto;
    }
}