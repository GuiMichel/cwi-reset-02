package br.com.cwi.resetflix.service;


import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.mapper.DiretorEntityMapper;
import br.com.cwi.resetflix.mapper.DiretorResponseMapper;
import br.com.cwi.resetflix.mapper.FilmeResponseMapper;
import br.com.cwi.resetflix.repository.DiretoresRepository;
import br.com.cwi.resetflix.repository.FilmesRepository;
import br.com.cwi.resetflix.request.CriarAtorRequest;
import br.com.cwi.resetflix.request.CriarDiretorRequest;
import br.com.cwi.resetflix.response.ConsultarDetalhesAtorResponse;
import br.com.cwi.resetflix.response.ConsultarDetalhesDiretorResponse;
import br.com.cwi.resetflix.response.DiretoresResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiretoresService {

    @Autowired
    private DiretoresRepository diretoresRepository;
    @Autowired
    private FilmesRepository filmesRepository;

    static DiretorResponseMapper MAPPER_RESPONSE = new DiretorResponseMapper();
    static DiretorEntityMapper MAPPER_ENTITY = new DiretorEntityMapper();
    static FilmeResponseMapper MAPPER_RESPONSE_FILME = new FilmeResponseMapper();

    public List<DiretoresResponse> getDiretores(){
        final List<DiretorEntity> diretores = diretoresRepository.getDiretores();
        return MAPPER_RESPONSE.mapear(diretores);
    }

    public ConsultarDetalhesDiretorResponse buscaDiretorPorId(Long id){
        final DiretorEntity diretorEntity = diretoresRepository.encontrarDiretorPorId(id);
        List<FilmeEntity> listaFilmes = new ArrayList<>();
        for (Long idsFilme : diretorEntity.getIdsFilmes()){
            FilmeEntity filme = filmesRepository.buscaFilmePorId(idsFilme);
            if(filme != null){
                listaFilmes.add(filme);
            }
        }

        return new ConsultarDetalhesDiretorResponse(diretorEntity.getId(),diretorEntity.getNome(),
                MAPPER_RESPONSE_FILME.mapear(listaFilmes));
    }



    public Long criarDiretor(CriarDiretorRequest request) {
        DiretorEntity diretorSalvar = MAPPER_ENTITY.mapear(request);
        return diretoresRepository.criarDiretor(diretorSalvar);
    }






}
