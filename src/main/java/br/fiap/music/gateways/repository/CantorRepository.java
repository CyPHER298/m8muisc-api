package br.fiap.music.gateways.repository;

import br.fiap.music.domain.Cantor;
import org.springframework.stereotype.Repository;

@Repository
public interface CantorRepository extends BaseRepository<Cantor, Long> {
    boolean existsByEmail(String email);
}
