package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TipoTransacao;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.Data;
import br.com.banco.desgraca.exception.InstituicaoInvalida;
import br.com.banco.desgraca.exception.ValorAbaixoEsperado;

import java.time.LocalDate;

public class ContaDigital extends ContaBase{

    public ContaDigital(Integer numeroConta, InstituicaoBancaria instituicaoBancaria, Double saldo) {

        super(numeroConta, instituicaoBancaria, saldo);

    }

    public InstituicaoBancaria validaNome(InstituicaoBancaria banco){
        if((banco.equals(InstituicaoBancaria.NUBANK)) ||
            banco.equals(InstituicaoBancaria.ITAU)){
            return banco;
        }else {
            throw new InstituicaoInvalida("Essa instituição não oferece esse tipo de conta.");
        }
    }

    @Override
    public void sacar(Double valor) {
        if(valor>=10) {
            super.sacar(valor);
        }else{
            throw new ValorAbaixoEsperado("Saques em contas digitais são permitidos a partir de " +
                    "R$ 10,00");
        }
    }

    @Override
    public String toString() {
        return "Conta Digital "+super.toString();
    }

}
