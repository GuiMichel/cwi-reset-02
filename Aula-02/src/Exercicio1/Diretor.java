package Exercicio1;

public class Diretor {
    private String nome;
    private int idade;
    private int quantidadeDirigidos;
    private Genero genero;


    public Diretor(String nome, int idade, int quantidadeDirigidos, Genero genero) {
        this.nome = nome;
        this.idade = idade;
        this.quantidadeDirigidos = quantidadeDirigidos;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void imprimir(){
        System.out.println("Nome: "+ this.nome+"\nIdade: "+this.idade+ "\nGênero: "
                + this.genero.getDescricao()+"\n");
    }
}
