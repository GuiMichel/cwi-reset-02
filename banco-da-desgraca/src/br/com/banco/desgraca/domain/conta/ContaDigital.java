package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;

import java.time.LocalDate;

public class ContaDigital extends ContaBase implements ContaBancaria{
    public ContaDigital(String numeroConta, InstituicaoBancaria instituicaoBancaria) {
        super(numeroConta, instituicaoBancaria);
    }

    @Override
    public String toString() {
        return "Conta Digital "+super.toString();
    }

    @Override
    public InstituicaoBancaria getInstituicaoBancaria() {
        return super.getInstituicaoBancaria();
    }

    @Override
    public Double consultarSaldo() {
        return super.getSaldo();
    }

    @Override
    public void depositar(Double valor) {

    }

    @Override
    public void sacar(Double valor) {

    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {

    }

    @Override
    public void exibirExtrato(LocalDate inicio, LocalDate fim) {

    }
}
