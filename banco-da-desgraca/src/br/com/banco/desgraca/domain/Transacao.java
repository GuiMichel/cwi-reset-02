package br.com.banco.desgraca.domain;

import br.com.banco.desgraca.domain.conta.ContaBancaria;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transacao {
    private TipoTransacao tipoTransacao;
    private LocalDate dataTransacao;
    private double valorTransacao;
    private ContaBancaria conta;


    public Transacao(TipoTransacao tipoTransacao, LocalDate dataTransacao,
                     double valorTransacao, ContaBancaria conta) {

        this.tipoTransacao = tipoTransacao;
        this.dataTransacao = dataTransacao;
        this.valorTransacao = valorTransacao;
        this.conta = conta;
    }

    public ContaBancaria getConta() {
        return conta;
    }

    @Override
    public String toString() {
        return " " + this.tipoTransacao.getSinal() + "\t\t" + DecimalFormat.getCurrencyInstance().format(this.valorTransacao)
                + "\t\t" + this.getDataTransacao().format(formatter) + "\n";
    }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/y");

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public LocalDate getDataTransacao() {
        return dataTransacao;
    }

    public double getValorTransacao() {
        return valorTransacao;
    }
}
