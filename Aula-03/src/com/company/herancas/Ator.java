package com.company.herancas;

import com.company.enumeradores.Genero;

public class Ator extends Pessoa {
    private int quantidadeOscarsVencidos;

    public Ator(String nome, int idade, int quantidadeOscarsVencidos, Genero genero) {
        super(nome, idade, genero);
        this.quantidadeOscarsVencidos = quantidadeOscarsVencidos;
    }

}
