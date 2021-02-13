package Exercicio1;

public class Filme {
    private String nome;
    private String descricao;
    private double duracao;
    private int anoLancamento;
    private int avaliacao;
    private Diretor diretor;


    public Filme(String nome, String descricao, double duracao, int anoLancamento, int avaliacao, Diretor diretor) {
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.anoLancamento = anoLancamento;
        this.avaliacao = avaliacao;
        this.diretor = diretor;
    }

    public void reproduzir(){
        System.out.println("Filme: "+ this.nome+"\nDescrição: "+this.descricao+"\nDuração: "+this.duracao+
                "min\nDirigido por: "+this.diretor.getNome()+"\n");
    }

    private void defineAvaliacao(int avaliacao){


    }

}
