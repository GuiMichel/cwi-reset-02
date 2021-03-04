package br.com.cwi.resetflix.mapper;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.response.AtoresResponse;

import java.util.ArrayList;
import java.util.List;

public class AtoresResponseMapper {

    public List<AtoresResponse> mapear(List<AtorEntity> atores) {

        List<AtoresResponse> atoresResponses = new ArrayList<>();

        for(AtorEntity atorEntity : atores){
            AtoresResponse atorResponse = new AtoresResponse(atorEntity.getId(), atorEntity.getNome());

            atoresResponses.add(atorResponse);
        }
        return atoresResponses;
    }
}
