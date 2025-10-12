package br.fiap.music.gateways.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ClienteDTO(
        Long id,
        @NotBlank @Size(min = 2, max = 80) String nome
) {}
