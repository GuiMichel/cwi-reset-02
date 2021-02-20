package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;

import java.time.LocalDate;

public abstract class ContaBase implements ContaBancaria{
    private String numeroConta;

    private InstituicaoBancaria instituicaoBancaria;
    private double saldo= 0;


    public ContaBase(String numeroConta, InstituicaoBancaria instituicaoBancaria) {
        this.numeroConta = numeroConta;
        this.instituicaoBancaria = instituicaoBancaria;
    }

    public String getNumeroConta() {
        return numeroConta;
    }
    public InstituicaoBancaria getInstituicaoBancaria() {
        return instituicaoBancaria;
    }

    public double getSaldo() {
        return saldo;
    }



    @Override
    public Double consultarSaldo() {
        return this.getSaldo();
    }

    @Override
    public abstract  void  depositar(Double valor);

    @Override
    public abstract void sacar(Double valor);

    @Override
    public abstract void transferir(Double valor, ContaBancaria contaDestino);

    @Override
    public abstract void exibirExtrato(LocalDate inicio, LocalDate fim);

    @Override
    public String toString() {
        return  instituicaoBancaria+ ", número: "+ numeroConta ;
    }
}
