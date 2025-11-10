package br.fiap.music.gateways;

import br.fiap.music.domain.Cliente;
import br.fiap.music.domain.Musica;
import br.fiap.music.gateways.dto.ClienteDTO;
import br.fiap.music.gateways.dto.MusicaDTO;
import br.fiap.music.service.MusicaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/musicas")
@RequiredArgsConstructor
public class MusicaController {
    private final MusicaService service;

    @PostMapping
    public ResponseEntity<EntityModel<MusicaDTO>> create(@RequestBody @Valid MusicaDTO body) {

        MusicaDTO musica = service.create(body);

        EntityModel<MusicaDTO> entityModel = EntityModel.of(musica,
                linkTo(methodOn(MusicaController.class).get(musica.id())).withSelfRel());

        return ResponseEntity.created(entityModel.getRequiredLink("self").toUri())
                .body(entityModel);
    }

    @GetMapping
    public ResponseEntity<EntityModel<List<MusicaDTO>>> list() {
        EntityModel<List<MusicaDTO>> response = EntityModel.of(service.list());

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<MusicaDTO>> get(@PathVariable Long id) {
        EntityModel<MusicaDTO> response = EntityModel.of(service.get(id),
                linkTo(methodOn(MusicaController.class).get(id)).withSelfRel(),
                linkTo(methodOn(MusicaController.class).list()).withRel("lista-musicas"));

        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<MusicaDTO>> update(@PathVariable Long id, @RequestBody @Valid MusicaDTO body) {
        MusicaDTO musica = service.update(id, body);

        EntityModel<MusicaDTO> cantorModel = EntityModel.of(musica,
                linkTo(methodOn(MusicaController.class).update(id, null)).withSelfRel(),
                linkTo(methodOn(MusicaController.class).list()).withRel("lista-musicas")
        );

        return ResponseEntity.ok(cantorModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public List<MusicaDTO> search(@RequestParam String q) {
        return service.searchTitulo(q);
    }
}
