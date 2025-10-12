package br.fiap.music.gateways;

import org.springframework.stereotype.Repository;

import br.fiap.music.domain.Pedido;

@Repository
public interface PedidoRepository extends BaseRepository<Pedido, Long> {}
