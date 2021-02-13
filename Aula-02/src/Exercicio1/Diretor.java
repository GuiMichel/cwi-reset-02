package Exercicio1;

public class Diretor {
    private String nome;
    private int idade;
    private int quantidadeDirigidos;


    public Diretor(String nome, int idade, int quantidadeDirigidos) {
        this.nome = nome;
        this.idade = idade;
        this.quantidadeDirigidos = quantidadeDirigidos;
    }

    public String getNome() {
        return nome;
    }
}
