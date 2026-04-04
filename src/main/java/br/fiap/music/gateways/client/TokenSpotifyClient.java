package br.fiap.music.gateways.client;

import br.fiap.music.gateways.client.dto.TokenResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "apí-spotify-token", url = "https://accounts.spotify.com/api/token")
public interface TokenSpotifyClient {
//
//    @PostMapping(value = "/api/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//    TokenResponseDTO getAuthToken(
//            @RequestParam("grant_type") String grantType,
//            @RequestParam("client_id") String clientId,
//            @RequestParam("client_secret") String clientSecret
//    ) {
//        return null;
//    }
}
