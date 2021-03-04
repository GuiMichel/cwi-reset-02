package br.com.cwi.resetflix.mapper;

import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.request.CriarDiretorRequest;
import br.com.cwi.resetflix.request.CriarFilmeRequest;

public class FilmeEntityMapper {

    public FilmeEntity mapear(final CriarFilmeRequest request) {
        return new FilmeEntity(request.getGenero(), request.getNome(),
                request.getIdsAtores(),request.getIdDiretor());
    }
}
