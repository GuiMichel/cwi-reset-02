package Exercicio1;

public class App {
    public static void main(String[] args) {
        Diretor pedro = new Diretor("Pedro",60,10);
        Filme filme1 = new Filme("Titanic", "Barco Afundando",120,
                2000,5,pedro);
        Filme filme2 = new Filme("vingadores", "Fim do Mundo",90,
                2018,5,pedro);

        filme1.reproduzir();
        filme2.reproduzir();
    }
}
