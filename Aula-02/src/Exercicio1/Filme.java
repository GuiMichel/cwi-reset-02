package Exercicio1;

public class Filme {
    private String nome;
    private String descricao;
    private double duracao;
    private int anoLancamento;
    private int avaliacao;
    private Diretor diretor;


    public Filme(String nome, String descricao, double duracao, int anoLancamento, int avaliacao, Diretor diretor) {
        defineAvaliacao(avaliacao,nome);
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.anoLancamento = anoLancamento;
        this.diretor = diretor;
    }

    public void reproduzir(){
        System.out.println("Filme: "+ this.nome+"\nDescrição: "+this.descricao+"\nDuração: "+this.duracao+
                "min\nDirigido por: "+this.diretor.getNome()+"\navaliação: "+this.avaliacao+"\n");
    }

    private void defineAvaliacao(int avaliacao, String nome){
        if ("O Clube da Luta".equals(nome)){
            this.avaliacao = 5;
        }else if ("Batman vs Superman".equals(nome)){
            this.avaliacao = 1;
        }else if(avaliacao<1 || avaliacao>5){
            this.avaliacao = 3;
        }
    }

}
