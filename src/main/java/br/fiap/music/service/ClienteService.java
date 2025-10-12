package br.fiap.music.service;

import br.fiap.music.gateways.dto.ClienteDTO;
import br.fiap.music.domain.Cliente;
import br.fiap.music.gateways.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository repo;

    private ClienteDTO toDTO(Cliente c){
        return new ClienteDTO(c.getId(), c.getNome());
    }
    private void apply(Cliente c, ClienteDTO d){
        c.setNome(d.nome());
    }

    public ClienteDTO create(ClienteDTO dto){
        Cliente c = new Cliente();
        apply(c, dto);
        return toDTO(repo.save(c));
    }

    public List<ClienteDTO> list(){
        return repo.findAll().stream().map(this::toDTO).toList();
    }

    public ClienteDTO get(Long id){
        return toDTO(getEntity(id));
    }

    public ClienteDTO update(Long id, ClienteDTO dto){
        Cliente c = getEntity(id);
        apply(c, dto);
        return toDTO(repo.save(c));
    }

    public void delete(Long id){
        repo.delete(getEntity(id));
    }

    public Cliente getEntity(Long id){
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }
}
