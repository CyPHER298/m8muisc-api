package br.fiap.music.gateways;

import br.fiap.music.gateways.dto.ClienteDTO;
import br.fiap.music.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {
    private final ClienteService service;

    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public ClienteDTO create(@RequestBody @Valid ClienteDTO dto){ return service.create(dto); }

    @GetMapping public List<ClienteDTO> list(){ return service.list(); }

    @GetMapping("/{id}") public ClienteDTO get(@PathVariable Long id){ return service.get(id); }

    @PutMapping("/{id}") public ClienteDTO update(@PathVariable Long id, @RequestBody @Valid ClienteDTO dto){
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){ service.delete(id); }
}
