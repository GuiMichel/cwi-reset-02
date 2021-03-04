package br.com.cwi.resetflix.service;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.mapper.*;
import br.com.cwi.resetflix.repository.AtoresRepository;
import br.com.cwi.resetflix.repository.DiretoresRepository;
import br.com.cwi.resetflix.repository.FilmesRepository;
import br.com.cwi.resetflix.request.CriarFilmeRequest;
import br.com.cwi.resetflix.response.ConsultarDetalhesFilmeResponse;
import br.com.cwi.resetflix.response.DiretoresResponse;
import br.com.cwi.resetflix.response.FilmeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmesService {

    @Autowired
    private FilmesRepository filmesRepository;
    @Autowired
    private AtoresRepository atoresRepository;
    @Autowired
    private DiretoresRepository diretoresRepository;

    static FilmeResponseMapper MAPPER_RESPONSE = new FilmeResponseMapper();
    static FilmeEntityMapper MAPPER_ENTITY = new FilmeEntityMapper();
    static DetalhesDiretorResponseMapper MAPPER_DETALHES_DIRETOR = new DetalhesDiretorResponseMapper();
    static AtoresResponseMapper MAPPER_RESPONSE_ATOR = new AtoresResponseMapper();

    public List<FilmeResponse> getFilmes() {
        final List<FilmeEntity> filmes = filmesRepository.getFilmes();
        return MAPPER_RESPONSE.mapear(filmes);
    }

    public Long criaFilme(CriarFilmeRequest request) {
        FilmeEntity filmeSalvar = MAPPER_ENTITY.mapear(request);
        return filmesRepository.criaFilme(filmeSalvar);

    }

    public ConsultarDetalhesFilmeResponse buscaFilmePorId(Long id) {
        final FilmeEntity filme = filmesRepository.buscaFilmePorId(id);
        List<AtorEntity> atores = new ArrayList<>();
        if (filme != null) {
            for (Long idsAtores : filme.getIdsAtores()) {
                AtorEntity atorEntity = atoresRepository.encontrarAtorPorId(idsAtores);
                if (atorEntity != null) {
                    atores.add(atorEntity);
                }
            }
        }

        DiretorEntity diretorEntity = diretoresRepository.encontrarDiretorPorId(filme.getIdDiretor());


        return new ConsultarDetalhesFilmeResponse(filme.getId(), filme.getNome(), filme.getGenero(),
                MAPPER_DETALHES_DIRETOR.mapear(diretorEntity), MAPPER_RESPONSE_ATOR.mapear(atores));

    }
}
