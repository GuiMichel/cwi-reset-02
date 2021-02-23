package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TipoTransacao;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.Data;

import java.time.LocalDate;

public class ContaDigital extends ContaBase{

    public ContaDigital(Integer numeroConta, InstituicaoBancaria instituicaoBancaria, Double saldo) {
        super(numeroConta, instituicaoBancaria, saldo);
    }
}
