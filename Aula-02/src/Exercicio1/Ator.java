package Exercicio1;

public class Ator {
    private String nome;
    private int idade;
    private int quantidadeOscar;
    private Genero genero;

    public Ator(String nome, int idade, int quantidadeOscar, Genero genero) {
        this.nome = nome;
        this.idade = idade;
        this.quantidadeOscar = quantidadeOscar;
        this.genero = genero;
    }

    public void imprimir(){
        System.out.println("Nome: "+ this.nome+"\nIdade: "+this.idade+ "\nGênero: "
                + this.genero.getDescricao()+"\n");
    }
}
