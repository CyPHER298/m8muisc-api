package br.fiap.music.gateways;

import br.fiap.music.gateways.dto.CantorDTO;
import br.fiap.music.service.CantorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cantores")
@RequiredArgsConstructor
public class CantorController {
    private final CantorService service;

    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public CantorDTO create(@RequestBody @Valid CantorDTO dto){ return service.create(dto); }

    @GetMapping public List<CantorDTO> list(){ return service.list(); }

    @GetMapping("/{id}") public CantorDTO get(@PathVariable Long id){ return service.get(id); }

    @PutMapping("/{id}") public CantorDTO update(@PathVariable Long id, @RequestBody @Valid CantorDTO dto){
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){ service.delete(id); }
}
