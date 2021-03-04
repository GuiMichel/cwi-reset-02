package br.com.cwi.resetflix.mapper;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.response.AtoresResponse;
import br.com.cwi.resetflix.response.ConsultarDetalhesAtorResponse;
import br.com.cwi.resetflix.response.FilmeResponse;

import java.util.ArrayList;
import java.util.List;

public class DetalhesAtorResponseMapper {

    public ConsultarDetalhesAtorResponse mapear(AtorEntity ator) {

        List<FilmeResponse> filmeResponseList = new ArrayList<>();





            for(FilmeResponse filmeResponse : filmeResponseList){
                if(ator.getIdsFilmes().equals(filmeResponse.getId())){
                    filmeResponseList.add(filmeResponse);
                }

            }
            ConsultarDetalhesAtorResponse detalhesAtorResponse = new ConsultarDetalhesAtorResponse(ator.getId(),
                    ator.getNome(), filmeResponseList);



        return detalhesAtorResponse;
    }
}
