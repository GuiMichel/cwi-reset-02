package Exercicio1;

public class Diretor extends Pessoa{

    private int quantidadeDirigidos;



    public Diretor(String nome, int idade, int quantidadeDirigidos, Genero genero) {

        super(nome, idade, genero);
        this.quantidadeDirigidos = quantidadeDirigidos;

    }
    public void imprimir(){
        System.out.println("Nome: "+ super.getNome()+"\nIdade: "+super.getIdade()+ "\nGênero: "
                + super.getGenero().getDescricao()+"\nDiretor de "+this.quantidadeDirigidos+" filmes.");
    }

}
