package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.exception.InstituicaoInvalida;
import br.com.banco.desgraca.exception.ValorAbaixoEsperado;

public class ContaPoupanca extends ContaBase {

    public ContaPoupanca(Integer numeroConta, InstituicaoBancaria instituicaoBancaria, Double saldo) {
        super(numeroConta, instituicaoBancaria, saldo);
    }

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

    @Override
    public void sacar(Double valor) {
        if (valor >= 50.0) {
            this.cobraTaxa(0.02, valor);
            super.sacar(valor);
        } else {
            throw new ValorAbaixoEsperado("Saques são permitidos apartir de R$ 50,00");
        }

    }

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
