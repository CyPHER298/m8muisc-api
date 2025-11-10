package br.fiap.music.gateways;

import br.fiap.music.domain.Cliente;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente, Long> {
}
