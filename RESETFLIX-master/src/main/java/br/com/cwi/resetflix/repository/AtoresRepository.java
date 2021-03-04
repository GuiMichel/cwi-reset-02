package br.com.cwi.resetflix.repository;

import br.com.cwi.resetflix.entity.AtorEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AtoresRepository {

    static List<AtorEntity> atores = new ArrayList<>();
    static Long contadorIds = 1l;

    public  List<AtorEntity> getAtores() {
        return atores;
    }

    public Long criarAtor(final AtorEntity atorSalvar) {
        if(atorSalvar.getId() == null){
            atorSalvar.setId(contadorIds);
            contadorIds++;
        }
        atores.add(atorSalvar);
        return atorSalvar.getId();

    }

    public AtorEntity encontrarAtorPorId(Long id) {
        for (AtorEntity ator : atores) {
            if (ator.getId().equals(id)) {
                return ator;
            }
        }
        return null;
    }
}

