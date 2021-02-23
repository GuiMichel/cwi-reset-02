package br.com.banco.desgraca.domain.conta;


import br.com.banco.desgraca.Data;
import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TipoTransacao;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;

import java.time.LocalDate;

public class ContaCorrente extends ContaBase{


    public ContaCorrente(Integer numeroConta, InstituicaoBancaria instituicaoBancaria, Double saldo) {
        super(numeroConta, instituicaoBancaria, saldo);
    }

}