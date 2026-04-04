package br.fiap.music.gateways.controller;

import br.fiap.music.domain.Cantor;
import br.fiap.music.domain.Cliente;
import br.fiap.music.gateways.*;
import br.fiap.music.gateways.dto.CantorDTO;
import br.fiap.music.gateways.dto.ClienteDTO;
import br.fiap.music.gateways.dto.MusicaDTO;
import br.fiap.music.gateways.dto.PedidoDTO;
import br.fiap.music.service.CantorService;
import br.fiap.music.service.ClienteService;
import br.fiap.music.service.MusicaService;
import br.fiap.music.service.PedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestCallController {

    private final Middleware middleware;

    @GetMapping
    public ResponseEntity<String> middlewareCall() {
        String endereco = middleware.middlewareCall();

        return ResponseEntity.ok(endereco);
    }

    @RestController
    @RequestMapping("/api/cantores")
    @RequiredArgsConstructor
    public static class CantorController {
        private final CantorService service;

        @PostMapping
        public ResponseEntity<EntityModel<CantorDTO>> create(@RequestBody @Valid CantorDTO body) {

            CantorDTO cantor = service.create(body);

            EntityModel<CantorDTO> entityModel = EntityModel.of(cantor,
                    linkTo(methodOn(CantorController.class).get(cantor.id())).withSelfRel());

            return ResponseEntity.created(entityModel.getRequiredLink("self").toUri())
                    .body(entityModel);
        }

        @GetMapping
        public ResponseEntity<EntityModel<List<CantorDTO>>> list() {
            EntityModel<List<CantorDTO>> response = EntityModel.of(service.list());

            return ResponseEntity.ok(response);
        }

        @GetMapping("/{id}")
        public ResponseEntity<EntityModel<Cantor>> get(@PathVariable Long id) {
            Cantor cantor = service.get(id);

            EntityModel<Cantor> cantorModel = EntityModel.of(cantor,
                    linkTo(methodOn(CantorController.class).get(id)).withSelfRel(),
                    linkTo(methodOn(CantorController.class).list()).withRel("lista-cantores"));

            return ResponseEntity.ok(cantorModel);
        }

        @PutMapping("/{id}")
        public ResponseEntity<EntityModel<Cantor>> update(@PathVariable Long id, @RequestBody @Valid CantorDTO body) {
            Cantor cantor = service.update(id, body);

            EntityModel<Cantor> cantorModel = EntityModel.of(cantor,
                    linkTo(methodOn(CantorController.class).update(id, null)).withSelfRel(),
                    linkTo(methodOn(CantorController.class).list()).withRel("lista-cantores")
                    );

            return ResponseEntity.ok(cantorModel);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable Long id) {
            service.delete(id);
            return ResponseEntity.noContent().build();
        }
    }

    @RestController
    @RequestMapping("/api/clientes")
    @RequiredArgsConstructor
    public static class ClienteController {
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

    @RestController
    @RequestMapping("/api/musicas")
    @RequiredArgsConstructor
    public static class MusicaController {
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

    @RestController
    @RequestMapping("/api/pedidos")
    @RequiredArgsConstructor
    public static class PedidoController {
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
}
