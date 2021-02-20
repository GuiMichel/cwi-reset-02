package Exercicio1;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Diretor pedro = new Diretor("Pedro",60,10,Genero.MASCULINO);
        Ator caprio = new Ator("Leonardo", 30, 10, Genero.MASCULINO);
        Ator santoro = new Ator("Rodrigo", 30, 10, Genero.MASCULINO);
        Ator smith = new Ator("Will", 30, 10, Genero.MASCULINO);

        List<Pessoa> elenco = new ArrayList<>();
        elenco.add(caprio);
        elenco.add(santoro);
        elenco.add(smith);
        elenco.add(pedro);

        Filme filme1 = new Filme("Titanic", "Barco Afundando", 120,
                2000, 7,elenco)
        ;
        Filme filme2 = new Filme("Batman vs Superman", "Fim do Mundo",90,
                2018,5,elenco);

        filme1.creditos();

//        filme1.reproduzir();
//        filme2.reproduzir();
//
//        pedro.imprimir();
//        caprio.imprimir();
    }
}
