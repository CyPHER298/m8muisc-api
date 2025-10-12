package br.fiap.music.gateways;

import br.fiap.music.gateways.dto.PedidoDTO;
import br.fiap.music.service.PedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
public class PedidoController {
    private final PedidoService service;

    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public PedidoDTO create(@RequestBody @Valid PedidoDTO dto){ return service.create(dto); }

    @GetMapping public List<PedidoDTO> list(){ return service.list(); }

    @GetMapping("/{id}") public PedidoDTO get(@PathVariable Long id){ return service.get(id); }

    @PutMapping("/{id}") public PedidoDTO update(@PathVariable Long id, @RequestBody @Valid PedidoDTO dto){
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){ service.delete(id); }
}
