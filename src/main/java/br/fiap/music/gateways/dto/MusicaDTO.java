package br.fiap.music.gateways.dto;

import jakarta.validation.constraints.*;

public record MusicaDTO(
        Long id,
        @NotBlank @Size(min = 2, max = 100) String titulo,
        @NotBlank @Size(min = 2, max = 100) String artista,
        @NotBlank @Size(min = 2, max = 50) String genero,
        @NotNull Long cantorId
) {
}
