package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.exception.InstituicaoInvalida;
import br.com.banco.desgraca.exception.ValorAbaixoEsperado;
import br.com.banco.desgraca.exception.ValorInvalidoSaque;

public class ContaPoupanca extends ContaBase {

    public ContaPoupanca(Integer numeroConta, InstituicaoBancaria instituicaoBancaria, Double saldo) {
        super(numeroConta, instituicaoBancaria, saldo);
    }
    // Método para teste de Instituição Bancária aqui não é permitida a instituição Nubank.
    @Override
    public InstituicaoBancaria validaNome(InstituicaoBancaria banco) {
        if ((banco.equals(InstituicaoBancaria.NUBANK))) {
            throw new InstituicaoInvalida("Essa instituição não oferece esse tipo de conta.");
        } else {
            return banco;
        }
    }

    @Override
    public String toString() {
        return "Conta Poupança " + super.toString();
    }
    //método sobrescrevido para implementação de regras. Aqui são permitidos apenas saques de valores
    //acima de R$ 50,00 e é cobrado uma taxa de 2 % do valor, caso o valor informado esteja abaixo é lançada
    //a Exception ValorAbaixoEsperado.
    @Override
    public void sacar(Double valor) {
        if (valor >= 50.0) {
            super.sacar(valor);
            this.cobraTaxa(0.02, valor);
        } else {
            throw new ValorInvalidoSaque("Saques são permitidos apartir de R$ 50,00");
        }

    }
    //método sobrescrevido para implementação de regras. Aqui se a Instituição de destino for diferente
    // é feita cobraça de uma taxa de 1 % do valor. e se for para a mesma Instituição 0,5% de taxa.
    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {
        super.transferir(valor, contaDestino);
        if (this.getInstituicaoBancaria().equals(contaDestino.getInstituicaoBancaria())) {
            this.cobraTaxa(0.005, valor);
        } else {
            this.cobraTaxa(0.01, valor);
        }
    }
}
