public class Imovel {
    private Endereco endereco;
    private double valor;

    public Imovel(Endereco endereco, double valor) {
        this.endereco = endereco;
        this.valor = valor;
    }

    public String apresentacao(){
        return "Localizado no endereço: "+this.endereco.descricaoEndereco()+ ".\nValor: "+this.valor;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public double getValor() {
        return valor;
    }
}
