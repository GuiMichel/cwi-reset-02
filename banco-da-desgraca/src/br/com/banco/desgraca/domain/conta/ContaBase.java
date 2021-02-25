package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.Data;
import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TipoTransacao;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.exception.InstituicaoInvalida;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class ContaBase implements ContaBancaria {
    private Integer numeroConta;
    private InstituicaoBancaria instituicaoBancaria;
    private Double saldo;
    private ArrayList<Transacao> transacoes = new ArrayList<>();
    private ArrayList<Transacao> extrato = new ArrayList<>();


    public ContaBase(Integer numeroConta, InstituicaoBancaria instituicaoBancaria, Double saldo) {
        this.numeroConta = numeroConta;
        this.instituicaoBancaria = validaNome(instituicaoBancaria);
        this.saldo = saldo;
    }
    public abstract InstituicaoBancaria validaNome(InstituicaoBancaria banco);

    public String toString() {
        return this.instituicaoBancaria.getNomeInstituição() + " " + this.numeroConta;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }


    @Override
    public InstituicaoBancaria getInstituicaoBancaria() {
        return this.instituicaoBancaria;
    }



    @Override
    public Double consultarSaldo() {
        return this.saldo;
    }

    public Double cobraTaxa(Double taxa, Double valor){
        return this.consultarSaldo()-(taxa * valor);
    }

    @Override
    public void depositar(Double valor) {
        Transacao transacao = new Transacao(TipoTransacao.ENTRADA, Data.getDataTransacao(), valor, ContaBase.this);
        this.adicionaTransacao(transacao);
        this.saldo += valor;
        System.out.println("Depositando " + DecimalFormat.getCurrencyInstance().format(valor) +
                " na " + this.toString());
    }

    @Override
    public void sacar(Double valor) {
        if (this.saldo >= valor) {
            Transacao transacao = new Transacao(TipoTransacao.SAIDA, Data.getDataTransacao(), valor, ContaBase.this);
            this.adicionaTransacao(transacao);
            this.saldo -= valor;
            System.out.println("Sacando " + DecimalFormat.getCurrencyInstance().format(valor) +
                    " da " + this.toString());
        } else {
            throw new SaldoInsuficienteException("Saldo insufuciente");
        }
    }

    public void adicionaTransacao(Transacao transacao){
        transacoes.add(transacao);
    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {

        if (this.saldo >= valor) {
            Transacao transacao = new Transacao(TipoTransacao.SAIDA, Data.getDataTransacao(), valor, ContaBase.this);
            this.adicionaTransacao(transacao);
            this.saldo -= valor;
            contaDestino.depositar(valor);
            System.out.println("Transferindo " + DecimalFormat.getCurrencyInstance().format(valor) +
                    " da " + this.toString() + " para " + contaDestino.toString());
        }else{
            throw new SaldoInsuficienteException("Saldo insuficiente para transferir.");
        }

    }

    @Override
    public void exibirExtrato(LocalDate inicio, LocalDate fim) {
        if((inicio != null) && (fim != null)){
            for (Transacao transacao : transacoes) {
                if ((transacao.getDataTransacao().isBefore(fim)) &&
                        (transacao.getDataTransacao().isAfter(inicio))) {
                    extrato.add(transacao);
                }
            }
        }else if(inicio != null){
            for (Transacao transacao : transacoes) {
                if (transacao.getDataTransacao().isAfter(inicio)) {
                    extrato.add(transacao);

                }
            }
        }else if(fim != null){
            for (Transacao transacao : transacoes) {
                if (transacao.getDataTransacao().isBefore(fim)) {
                    extrato.add(transacao);
                }
            }
        }
        if (extrato.isEmpty()) {
            System.out.println("Sem lançamentos para o período");
        } else {
            System.out.println("-----"+this.toString()+"\n"+
                                extrato.toString()+"\n" +
                                "Saldo atual: "+DecimalFormat.getCurrencyInstance().format(this.consultarSaldo())+
                                "\n----- Fim do extrato -----\n\n");
        }

    }

}
