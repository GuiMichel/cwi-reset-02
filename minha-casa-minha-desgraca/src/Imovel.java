public class Imovel {
    private Endereco endereco;
    private double valor;

    public Imovel(Endereco endereco, double valor) {
        this.endereco = endereco;
        this.valor = valor;
    }

    public String apresentacao(){
        return "Imóvel localizado endereço: "+this.endereco.descricaoEndereco()+ ".\n Valor: "+this.valor;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public double getValor() {
        return valor;
    }
}
