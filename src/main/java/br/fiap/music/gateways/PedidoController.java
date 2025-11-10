package br.fiap.music.gateways;

import br.fiap.music.domain.Cliente;
import br.fiap.music.gateways.dto.ClienteDTO;
import br.fiap.music.gateways.dto.PedidoDTO;
import br.fiap.music.service.PedidoService;
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
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
public class PedidoController {
    private final PedidoService service;

    @PostMapping
    public ResponseEntity<EntityModel<PedidoDTO>> create(@RequestBody @Valid PedidoDTO body) {

        PedidoDTO pedido = service.create(body);

        EntityModel<PedidoDTO> entityModel = EntityModel.of(pedido,
                linkTo(methodOn(PedidoController.class).get(pedido.id())).withSelfRel());

        return ResponseEntity.created(entityModel.getRequiredLink("self").toUri())
                .body(entityModel);
    }

    @GetMapping
    public ResponseEntity<EntityModel<List<PedidoDTO>>> list() {
        EntityModel<List<PedidoDTO>> response = EntityModel.of(service.list());

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<PedidoDTO>> get(@PathVariable Long id) {
        EntityModel<PedidoDTO> response = EntityModel.of(service.get(id),
                linkTo(methodOn(PedidoController.class).get(id)).withSelfRel(),
                linkTo(methodOn(PedidoController.class).list()).withRel("lista-pedidos"));

        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<PedidoDTO>> update(@PathVariable Long id, @RequestBody @Valid PedidoDTO body) {
        PedidoDTO pedido = service.update(id, body);

        EntityModel<PedidoDTO> cantorModel = EntityModel.of(pedido,
                linkTo(methodOn(PedidoController.class).update(id, null)).withSelfRel(),
                linkTo(methodOn(PedidoController.class).list()).withRel("lista-pedidos")
        );

        return ResponseEntity.ok(cantorModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
