package br.com.cwi.resetflix.service;


import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.mapper.AtorEntityMapper;
import br.com.cwi.resetflix.mapper.AtoresResponseMapper;
import br.com.cwi.resetflix.mapper.DetalhesAtorResponseMapper;
import br.com.cwi.resetflix.repository.AtoresRepository;
import br.com.cwi.resetflix.request.CriarAtorRequest;
import br.com.cwi.resetflix.response.AtoresResponse;
import br.com.cwi.resetflix.response.ConsultarDetalhesAtorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtoresService {

    @Autowired
    private AtoresRepository atoresRepository;

    static AtoresResponseMapper MAPPER_RESPONSE = new AtoresResponseMapper();
    static AtorEntityMapper MAPPER_ENTITY = new AtorEntityMapper();
    static DetalhesAtorResponseMapper MAPPER_DETALHES = new DetalhesAtorResponseMapper();

    public List<AtoresResponse> getAtores() {
          final List<AtorEntity> atores = atoresRepository.getAtores();
          return MAPPER_RESPONSE.mapear(atores);
    }


    public Long criarAtor(CriarAtorRequest request) {
        AtorEntity atorSalvar = MAPPER_ENTITY.mapear(request);
        return atoresRepository.criarAtor(atorSalvar);
    }

    public ConsultarDetalhesAtorResponse getDetalhesAtores(Long id) {
        final AtorEntity ator = atoresRepository.encontrarAtorPorId(id);
        return MAPPER_DETALHES.mapear(ator);
    }
}
