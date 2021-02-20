package com.company.domain;

import com.company.exceptions.EditoraException;

public class Editora {
    private String nome;
    private String localizacao;

    public Editora(String descNome, String localizacao) {
        this.nome = validaNome(descNome);
        this.localizacao = localizacao;
    }

    private String validaNome(String descNome){
        if(descNome.equals("DC Comics")){
            throw new EditoraException("Esse nome aqui não!!!");
        }else{
            return descNome;
        }
    }

    public String getNome() {
        return nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }
}
