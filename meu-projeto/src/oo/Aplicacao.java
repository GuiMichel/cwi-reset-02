package oo;

public class Aplicacao {
    public static void main(String[] args) {

        Carro carroVeio = new Carro("Chevrolet", "Chevette", 1990, 4);
        carroVeio.estacionar();
        carroVeio.abastecer( 40);

        System.out.println("O veículo está estacionado ? " + carroVeio.isEstacionado());

        carroVeio.acelerar(30);

        System.out.println("O veículo está estacionado ? " + carroVeio.isEstacionado());
        System.out.println("O veiculo ficou com " + carroVeio.getQuantidadeCombustivel() + " litros de combustível");
    }
}
