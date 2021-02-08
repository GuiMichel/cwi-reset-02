package exercicio3;

import java.util.Scanner;

public class Aplicacao {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        String nome = "";
        double nota = 0;
        System.out.println("===============================");
        System.out.println("Verificando conceito de Alunos:");
        System.out.println("===============================");

        System.out.println("=====Qual o nome do Aluno?=====");

        nome = ler.nextLine();

        System.out.printf("=====Qual sua Nota Final?======");
        nota = ler.nextDouble();


        Aluno a = new Aluno(nome, nota);
        System.out.println("===============================");
        System.out.println("Aluno: " + a.getNomeAluno() +
                "\nNota final: " + a.getNotaFinal() + "\nSituação: " + a.situacao());
        System.out.println("===============================");

    }
}
