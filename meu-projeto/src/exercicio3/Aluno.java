package exercicio3;

public class Aluno {
    private String nomeAluno = "";
    private double notaFinal = 0;

    public Aluno(String nomeAluno, double notaFinal){
        this.nomeAluno = nomeAluno;
        this.notaFinal = notaFinal;
    }

    public String situacao(){
        if (this.notaFinal>=7){
            return "Aprovado";
        }else{
            return "Reprovado";
        }
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public double getNotaFinal() {
        return notaFinal;
    }
}
