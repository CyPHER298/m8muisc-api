package br.fiap.music.service;

import br.fiap.music.gateways.dto.CantorDTO;
import br.fiap.music.domain.Cantor;
import br.fiap.music.gateways.CantorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CantorService {
    private final CantorRepository repo;

    private CantorDTO toDTO(Cantor c){
        return new CantorDTO(c.getId(), c.getNome(), c.getEmail(), c.getSenha());
    }
    private void apply(Cantor c, CantorDTO d){
        c.setNome(d.nome());
        c.setEmail(d.email());
        c.setSenha(d.senha());
    }

    public CantorDTO create(CantorDTO dto){
        if (repo.existsByEmail(dto.email())) throw new RuntimeException("Email já cadastrado");
        Cantor c = new Cantor();
        apply(c, dto);
        return toDTO(repo.save(c));
    }

    public List<CantorDTO> list(){
        return repo.findAll().stream().map(this::toDTO).toList();
    }

    public CantorDTO get(Long id){
        return toDTO(getEntity(id));
    }

    public CantorDTO update(Long id, CantorDTO dto){
        Cantor c = getEntity(id);
        // Se trocar email, verificar unicidade
        if(!c.getEmail().equalsIgnoreCase(dto.email()) && repo.existsByEmail(dto.email())){
            throw new RuntimeException("Email já cadastrado");
        }
        apply(c, dto);
        return toDTO(repo.save(c));
    }

    public void delete(Long id){
        repo.delete(getEntity(id));
    }

    public Cantor getEntity(Long id){
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Cantor não encontrado"));
    }
}
