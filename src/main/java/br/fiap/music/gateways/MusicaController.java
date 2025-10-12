package br.fiap.music.gateways;

import br.fiap.music.gateways.dto.MusicaDTO;
import br.fiap.music.service.MusicaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/musicas")
@RequiredArgsConstructor
public class MusicaController {
    private final MusicaService service;

    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public MusicaDTO create(@RequestBody @Valid MusicaDTO dto){ return service.create(dto); }

    @GetMapping public List<MusicaDTO> list(){ return service.list(); }

    @GetMapping("/{id}") public MusicaDTO get(@PathVariable Long id){ return service.get(id); }

    @PutMapping("/{id}") public MusicaDTO update(@PathVariable Long id, @RequestBody @Valid MusicaDTO dto){
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){ service.delete(id); }

    @GetMapping("/search") public List<MusicaDTO> search(@RequestParam String q){ return service.searchTitulo(q); }
}
