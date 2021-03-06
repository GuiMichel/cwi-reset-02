package br.com.cwi.resetflix.repository;


import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.DiretorEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DiretoresRepository {

    static List<DiretorEntity> diretores = new ArrayList<>();
    static Long contadorIds = 1l;

    public  List<DiretorEntity> getDiretores() {
        return diretores;
    }

    public Long criarDiretor(final DiretorEntity diretorSalvar) {
        if(diretorSalvar.getId() == null){
            diretorSalvar.setId(contadorIds);
            contadorIds++;
        }
        diretores.add(diretorSalvar);
        return diretorSalvar.getId();

    }

    public DiretorEntity encontrarDiretorPorId(Long id) {
        for (DiretorEntity diretor : diretores) {
            if (diretor.getId().equals(id)) {
                return diretor;
            }
        }
        return null;
    }
}

