package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;

import java.time.LocalDate;

public class ContaPoupanca extends ContaBase{

    public ContaPoupanca(Integer numeroConta, InstituicaoBancaria instituicaoBancaria, Double saldo) {
        super(numeroConta, instituicaoBancaria, saldo);
    }
}
