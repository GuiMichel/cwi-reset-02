package br.com.cwi.resetflix.entity;

import br.com.cwi.resetflix.domain.Genero;

import java.util.List;

public class FilmeEntity {

    private Genero genero;
    private Long id;
    private String nome;
    private List<Long> idsAtores;
    private Long idDiretor;

    public FilmeEntity(Genero genero, Long id, String nome, List<Long> idsAtores, Long idDiretor) {
        this.genero = genero;
        this.id = id;
        this.nome = nome;
        this.idsAtores = idsAtores;
        this.idDiretor = idDiretor;
    }

    public FilmeEntity(Genero genero, String nome, List<Long> idsAtores, Long idDiretor) {
        this.genero = genero;
        this.nome = nome;
        this.idsAtores = idsAtores;
        this.idDiretor = idDiretor;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Long> getIdsAtores() {
        return idsAtores;
    }

    public void setIdsAtores(List<Long> idsAtores) {
        this.idsAtores = idsAtores;
    }

    public Long getIdDiretor() {
        return idDiretor;
    }

    public void setIdDiretor(Long idDiretor) {
        this.idDiretor = idDiretor;
    }
}
