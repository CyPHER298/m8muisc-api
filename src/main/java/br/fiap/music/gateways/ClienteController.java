package br.fiap.music.gateways;

import br.fiap.music.domain.Cliente;
import br.fiap.music.gateways.dto.ClienteDTO;
import br.fiap.music.service.ClienteService;
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
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {
    private final ClienteService service;

    @PostMapping
    public ResponseEntity<EntityModel<ClienteDTO>> create(@RequestBody @Valid ClienteDTO body) {

        ClienteDTO cantor = service.create(body);

        EntityModel<ClienteDTO> entityModel = EntityModel.of(cantor,
                linkTo(methodOn(ClienteController.class).get(cantor.id())).withSelfRel());

        return ResponseEntity.created(entityModel.getRequiredLink("self").toUri())
                .body(entityModel);
    }

    @GetMapping
    public ResponseEntity<EntityModel<List<ClienteDTO>>> list() {
        EntityModel<List<ClienteDTO>> response = EntityModel.of(service.list());

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Cliente>> get(@PathVariable Long id) {
        EntityModel<Cliente> response = EntityModel.of(service.get(id),
                linkTo(methodOn(ClienteController.class).get(id)).withSelfRel(),
                linkTo(methodOn(ClienteController.class).list()).withRel("lista-clientes"));

        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<Cliente>> update(@PathVariable Long id, @RequestBody @Valid ClienteDTO body) {
        Cliente cliente = service.update(id, body);

        EntityModel<Cliente> cantorModel = EntityModel.of(cliente,
                linkTo(methodOn(CantorController.class).update(id, null)).withSelfRel(),
                linkTo(methodOn(CantorController.class).list()).withRel("lista-clientes")
        );

        return ResponseEntity.ok(cantorModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
