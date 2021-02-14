public class PropostaFinanciamento {
    /**
     * Valida a proposta de financiamento e apresenta o resultado para o cliente.
     *
     * A proposta de financiamento é aceita somente se o salário do beneficiário multiplicado pelo prazo de pagamento
     *   for equivalente a pelo menos 50% do valor do imóvel.
     *
     *   Esta regra possui duas exceções: se o imóvel se localiza no estado SP ou RJ,
     *      o salário multiplicado pelo prazo deve ser equivalente a 65% e 60% do valor imóvel (respectivamente).
     */
    private Beneficiario beneficiario;
    private Imovel imovel;
    private int prazo;

    public PropostaFinanciamento(Beneficiario beneficiario, Imovel imovel, int prazo) {
        this.beneficiario = beneficiario;
        this.imovel = imovel;
        this.prazo = prazo;
    }


    public void validarProposta() {
        if((this.beneficiario.getSalario()*this.prazo)<(this.imovel.getValor()*0.5)){
            this.imprimirPropostaNegada();
        }else if((this.imovel.getEndereco().getEstado().equals(UnidadeFederativa.SAO_PAULO))
                    && ((this.beneficiario.getSalario()*this.prazo)>=(this.imovel.getValor()*0.65))){
            this.imprimirPropostaAprovada();
        }else if((this.imovel.getEndereco().getEstado().equals(UnidadeFederativa.RIO_DE_JANEIRO))
                && ((this.beneficiario.getSalario()*this.prazo)>=(this.imovel.getValor()*0.6))){
            this.imprimirPropostaAprovada();
        }else{
            this.imprimirPropostaAprovada();
        }
    }

    private void imprimirPropostaAprovada(){
        System.out.println("Beneficiário: "+this.beneficiario.getNome()+"\nImóvel: "+this.imovel.apresentacao()+
                "\nPrazo: "+this.prazo+" meses.\n Parabéns! sua proposta foi aceita agora é só pagar!");
    }private void imprimirPropostaNegada(){
        System.out.println("Beneficiário: "+this.beneficiario.getNome()+"\nImóvel: "+this.imovel.apresentacao()+
                "\nPrazo: "+this.prazo+" meses.\n Te enxerga chinelo! essa house não é pro teu bico!");
    }



}