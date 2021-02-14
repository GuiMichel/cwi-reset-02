public class Casa extends Imovel{
    private boolean patio;

    public Casa(Endereco endereco, double valor, boolean patio) {
        super(endereco, valor);
        this.patio = patio;
    }

    public boolean getAndar() {
        return patio;
    }

    private String descricaoPatio(){
        if(this.patio){
            return "com pátio";
        }else {
            return "sem pátio";
        }
    }

    @Override
    public String apresentacao() {
        return "Casa "+this.descricaoPatio()+" Localizada no endereço: "+
                this.getEndereco().descricaoEndereco()+".\nValor: "+this.getValor();
    }
}
