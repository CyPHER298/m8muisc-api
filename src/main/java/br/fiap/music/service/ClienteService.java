package br.fiap.music.service;

import br.fiap.music.gateways.dto.ClienteDTO;
import br.fiap.music.domain.Cliente;
import br.fiap.music.gateways.ClienteRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository repo;

    @Transactional
    public ClienteDTO create(ClienteDTO dto) {

        Cliente cliente = new Cliente();
        cliente.setId(dto.id());
        cliente.setNome(dto.nome());

        repo.save(cliente);

        return ClienteDTO.builder().id(cliente.getId()).nome(dto.nome()).build();
    }

    public List<ClienteDTO> list() {
        List<Cliente> clientes = repo.findAll();

        ArrayList<ClienteDTO> list = new ArrayList<>();

        clientes.forEach((cliente) -> {
            list.add(ClienteDTO.builder()
                    .id(cliente.getId())
                    .nome(cliente.getNome())
                    .build());
        });

        return list;
    }

    public Cliente get(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Cliente update(@Valid Long id, @Valid ClienteDTO dto) {
        Cliente cliente = repo.findById(id).orElse(null);
        assert cliente != null;
        cliente.setNome(dto.nome());
        return repo.save(cliente);

    }

    @Transactional
    public Cliente delete(Long id) {
        Cliente cliente = repo.findById(id).orElse(null);

        assert cliente != null;
        repo.delete(cliente);

        return cliente;
    }

    public Cliente getEntity(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }
}
