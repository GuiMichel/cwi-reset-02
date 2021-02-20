package com.company;

import com.company.domain.Editora;
import com.company.domain.Filme;
import com.company.enumeradores.Genero;
import com.company.herancas.Diretor;

public class AplicacaoTeste {
    public static void main(String[] args) {
//        Editora teste = new Editora("teste1","blabla");
//        Editora dc = new Editora("DC Comics","bla");
        Filme f1 = new Filme(
                "batmam",
                "teste",
                150,
                2010,
                4,
                new Diretor(
                        "pedro",
                        30,
                        10,
                        Genero.MASCULINO));
        Filme F2 = new Filme("batmam","teste",150,2010,
                6,new Diretor("pedro",30,10, Genero.MASCULINO));

    }

}
