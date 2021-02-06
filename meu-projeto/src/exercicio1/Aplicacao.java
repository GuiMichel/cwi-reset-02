package exercicio1;

public class Aplicacao {
    public static void main(String[] args) {
        Calculadora cal1 = new Calculadora();

        int resultadoSoma = cal1.soma(2,2);
        int resultadoSubtrai = cal1.subtrai(5,3);
        int resultadoMultiplica = cal1.multiplica(2,2);
        double resultadoDivide = cal1.divide(6,3);

        System.out.println("o resultado da soma é: "+resultadoSoma);
        System.out.println("o resultado da subtração é: "+resultadoSubtrai);
        System.out.println("o resultado da Multiplicação é: "+resultadoMultiplica);
        System.out.println("o resultado da Divisão é: "+resultadoDivide);
    }
}
