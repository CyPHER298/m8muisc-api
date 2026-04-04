package br.fiap.music.gateways.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "api-spotify", url = "https://api.spotify.com/v1")
public interface SpotifyClient {

    @GetMapping
    String middlewareCall();
}
