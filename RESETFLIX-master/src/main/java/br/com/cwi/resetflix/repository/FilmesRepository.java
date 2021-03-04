package br.com.cwi.resetflix.repository;


import br.com.cwi.resetflix.entity.FilmeEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FilmesRepository {

    static List<FilmeEntity> filmes = new ArrayList<>();
    static Long contadorIds = 1l;

    public List<FilmeEntity> getFilmes() {
        return filmes;
    }

    public FilmeEntity buscaFilmePorId(Long id) {
        if (id != null) {
            for (FilmeEntity filme : filmes) {
                if (filme.getId().equals(id)) {
                    return filme;
                }
            }
        }
        return null;
    }

    public Long criaFilme(final FilmeEntity filmeSalvar) {
        if (filmeSalvar.getId() == null) {
            filmeSalvar.setId(contadorIds);
            contadorIds++;
        }
        filmes.add(filmeSalvar);

        return filmeSalvar.getId();
    }

}
