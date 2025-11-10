package br.fiap.music.gateways.dto;

import jakarta.validation.constraints.*;
import lombok.Builder;

@Builder
public record CantorDTO(
        Long id,
        @NotBlank @Size(min = 2, max = 80) String nome,
        @NotBlank @Email String email,
        @NotBlank @Size(min = 4, max = 60) String senha
) {
}
