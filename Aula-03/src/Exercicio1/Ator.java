package Exercicio1;

public class Ator extends Pessoa{

    private int quantidadeOscar;


    public Ator(String nome, int idade, int quantidadeOscar, Genero genero) {

        super(nome, idade, genero);
        this.quantidadeOscar = quantidadeOscar;

    }

    public void imprimir(){
        System.out.println("Nome: "+ super.getNome()+"\nIdade: "+super.getIdade()+ "\nGênero: "
                + super.getGenero().getDescricao()+"\nDono de "+this.quantidadeOscar+" estatuetas do Oscar.");
    }

}
