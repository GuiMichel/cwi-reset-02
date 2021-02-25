package br.com.banco.desgraca.domain.conta;


import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.exception.ValorInvalidoSaque;

public class ContaCorrente extends ContaBase {

    public ContaCorrente(Integer numeroConta, InstituicaoBancaria instituicaoBancaria, Double saldo) {
        super(numeroConta, instituicaoBancaria, saldo);
    }

    @Override
    public InstituicaoBancaria validaNome(InstituicaoBancaria banco) {
        return banco;
    }

    @Override
    public String toString() {
        return "Conta Corrente " + super.toString();
    }

    @Override
    public void sacar(Double valor) {
        if (valor % 5 == 0) {
            super.sacar(valor);
        } else {
            throw new ValorInvalidoSaque("No momento não temos notas disponíveis para esse valor" +
                    "refaça a operação com valores divisíveis por R$ 5,00");
        }
    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {
        if (this.getInstituicaoBancaria().equals(contaDestino.getInstituicaoBancaria()))
            super.transferir(valor, contaDestino);
        else {
            super.transferir(valor, contaDestino);
            this.cobraTaxa(0.01, valor);
        }
    }
}
