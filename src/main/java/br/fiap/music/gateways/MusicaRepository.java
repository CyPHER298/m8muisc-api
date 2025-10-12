package br.fiap.music.gateways;

import org.springframework.stereotype.Repository;

import br.fiap.music.domain.Musica;
import br.fiap.music.domain.Cantor;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

@Repository
public interface MusicaRepository extends BaseRepository<Musica, Long> {

    List<Musica> findByTituloContainingIgnoreCase(String titulo);

    @Query("""
        select m from Musica m
        where lower(m.genero) = lower(:genero)
        order by m.titulo asc
    """)
    List<Musica> findByGeneroOrderByTitulo(String genero);
}
