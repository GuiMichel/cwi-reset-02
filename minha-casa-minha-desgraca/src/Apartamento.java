public class Apartamento extends Imovel{
    private String andar;

    public Apartamento(Endereco endereco, double valor, String andar) {
        super(endereco, valor);
        this.andar = andar;
    }

    public String getAndar() {
        return andar;
    }

    @Override
    public String apresentacao() {
        return "Apartamento no "+this.andar+" localizado no endereço: "+
                this.getEndereco().descricaoEndereco()+ " \nValor: "+this.getValor();
    }
}
