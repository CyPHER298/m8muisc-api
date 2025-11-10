package br.fiap.music.service;

import br.fiap.music.gateways.dto.PedidoDTO;
import br.fiap.music.domain.Pedido;
import br.fiap.music.domain.Cliente;
import br.fiap.music.domain.Musica;
import br.fiap.music.gateways.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoService {
    private final PedidoRepository repo;
    private final ClienteService clienteService;
    private final MusicaService musicaService;

    private PedidoDTO toDTO(Pedido p) {
        return new PedidoDTO(p.getId(), p.getCliente().getId(), p.getMusica().getId());
    }

    private void apply(Pedido p, PedidoDTO d) {
        Cliente c = clienteService.getEntity(d.clienteId());
        Musica m = musicaService.getEntity(d.musicaId());
        p.setCliente(c);
        p.setMusica(m);
    }

    public PedidoDTO create(PedidoDTO dto) {
        Pedido p = new Pedido();
        apply(p, dto);
        return toDTO(repo.save(p));
    }

    public List<PedidoDTO> list() {
        return repo.findAll().stream().map(this::toDTO).toList();
    }

    public PedidoDTO get(Long id) {
        return toDTO(getEntity(id));
    }

    public PedidoDTO update(Long id, PedidoDTO dto) {
        Pedido p = getEntity(id);
        apply(p, dto);
        return toDTO(repo.save(p));
    }

    public void delete(Long id) {
        repo.delete(getEntity(id));
    }

    public Pedido getEntity(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }
}
