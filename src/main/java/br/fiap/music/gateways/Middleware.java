package br.fiap.music.gateways;

import br.fiap.music.gateways.client.SpotifyClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Middleware {

    private final SpotifyClient spotifyClient;

    @CircuitBreaker(name = "m8music-api")
    @Retry(name = "m8music-api")
    public String middlewareCall() {
        String test = spotifyClient.middlewareCall();

        return test;
    }
}
