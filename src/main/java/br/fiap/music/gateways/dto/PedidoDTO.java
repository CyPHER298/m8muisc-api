package br.fiap.music.gateways.dto;

import jakarta.validation.constraints.NotNull;

public record PedidoDTO(
        Long id,
        @NotNull Long clienteId,
        @NotNull Long musicaId
) {}
