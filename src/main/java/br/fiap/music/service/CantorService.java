package br.fiap.music.service;

import br.fiap.music.gateways.dto.CantorDTO;
import br.fiap.music.domain.Cantor;
import br.fiap.music.gateways.CantorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CantorService {
    private final CantorRepository repo;

    private void apply(Cantor c, CantorDTO d) {
        c.setNome(d.nome());
        c.setEmail(d.email());
        c.setSenha(d.senha());
    }

    @Transactional
    public CantorDTO create(CantorDTO dto) {
        if (repo.existsByEmail(dto.email())) throw new RuntimeException("Email já cadastrado");

        Cantor cantor = new Cantor();
        cantor.setNome(dto.nome());
        cantor.setEmail(dto.email());
        cantor.setSenha(dto.senha());
        repo.save(cantor);

        return CantorDTO.builder()
                .nome(cantor.getNome())
                .email(cantor.getEmail())
                .senha(cantor.getSenha()).build();

    }

    public List<CantorDTO> list() {
        List<Cantor> cantores = repo.findAll();

        ArrayList<CantorDTO> list = new ArrayList<>();

        cantores.forEach(cantor -> {
            list.add(CantorDTO.builder()
                    .id(cantor.getId())
                    .nome(cantor.getNome())
                    .email(cantor.getEmail())
                    .build());
        });

        return list;
    }

    public Cantor get(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Cantor update(Long id, CantorDTO dto) {
        Cantor cantor = repo.findById(id).orElse(null);
        assert cantor != null;
        cantor.setNome(dto.nome());
        cantor.setEmail(dto.email());
        cantor.setSenha(dto.senha());
        return repo.save(cantor);
    }

    public void delete(Long id) {
        repo.delete(getEntity(id));
    }

    public Cantor getEntity(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Cantor não encontrado"));
    }
}
