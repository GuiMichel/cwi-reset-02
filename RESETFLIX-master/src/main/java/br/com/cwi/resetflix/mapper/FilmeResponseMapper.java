package br.com.cwi.resetflix.mapper;

import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.response.DiretoresResponse;
import br.com.cwi.resetflix.response.FilmeResponse;

import java.util.ArrayList;
import java.util.List;

public class FilmeResponseMapper {
    public List<FilmeResponse> mapear(List<FilmeEntity> filmes){
        List<FilmeResponse> filmesResponse = new ArrayList<>();

        for(FilmeEntity filmeEntity : filmes){
            FilmeResponse filmeResponse = new FilmeResponse(filmeEntity.getId(), filmeEntity.getNome(),filmeEntity.getGenero());

            filmesResponse.add(filmeResponse);
        }
        return filmesResponse;
    }
}
