package exercicio3;

public class Aplicacao {
    public static void main(String[] args) {

        Aluno gui = new Aluno("Guilherme",10);

        System.out.println("Aluno: "+gui.getNomeAluno()+"\nNota final: "+gui.getNotaFinal()+"\nSituação: "+gui.situacao());
    }
}
