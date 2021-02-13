package Exercicio1;

public class Diretor extends Pessoa{

    private int quantidadeDirigidos;



    public Diretor(String nome, int idade, int quantidadeDirigidos, Genero genero) {

        super(nome, idade, genero);
        this.quantidadeDirigidos = quantidadeDirigidos;

    }

}
