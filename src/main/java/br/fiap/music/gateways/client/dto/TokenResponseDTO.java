package br.fiap.music.gateways.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TokenResponseDTO(
        @JsonProperty("access_token") String accessToken,
        @JsonProperty("token_type") String tokenType,
        @JsonProperty("expires_in") Integer expiresIn
) {
}
