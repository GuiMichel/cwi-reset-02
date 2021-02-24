package br.com.banco.desgraca.domain.conta;


import br.com.banco.desgraca.Data;
import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TipoTransacao;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;
import br.com.banco.desgraca.exception.ValorInvalidoSaque;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;

public class ContaCorrente extends ContaBase{

    public ContaCorrente(Integer numeroConta, InstituicaoBancaria instituicaoBancaria, Double saldo) {
        super(numeroConta, instituicaoBancaria, saldo);
    }

    @Override
    public String toString() {
        return "Conta Corrente "+super.toString();
    }

    @Override
    public void sacar(Double valor) {
        if(valor%5==0) {
            super.sacar(valor);
        }else{
            throw new ValorInvalidoSaque("No momento não temos notas disponíveis para esse valor" +
                    "refaça a operação com valores divisíveis por R$ 5,00");
        }
    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {
        if(this.getInstituicaoBancaria().equals(contaDestino.getInstituicaoBancaria()))
        super.transferir(valor, contaDestino);
        else{
            super.transferir(valor, contaDestino);
            this.setSaldo(this.getSaldo()-(valor*0.01));
        }
    }
}
