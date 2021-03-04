package br.com.cwi.resetflix.mapper;

import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.response.DiretoresResponse;

public class DetalhesDiretorResponseMapper {

    public DiretoresResponse mapear(DiretorEntity diretorEntity){
        DiretoresResponse diretorResponse = new DiretoresResponse(diretorEntity.getId(), diretorEntity.getNome());
        return diretorResponse;
    }

}
