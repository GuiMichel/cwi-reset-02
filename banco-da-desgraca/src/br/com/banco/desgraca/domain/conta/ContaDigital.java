package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.exception.InstituicaoInvalida;
import br.com.banco.desgraca.exception.ValorAbaixoEsperado;
import br.com.banco.desgraca.exception.ValorInvalidoSaque;

public class ContaDigital extends ContaBase {

    public ContaDigital(Integer numeroConta, InstituicaoBancaria instituicaoBancaria, Double saldo) {

        super(numeroConta, instituicaoBancaria, saldo);

    }
    // Método para teste de Instituição Bancária aqui são permitidos apenas Nubank e Itaú.
    public InstituicaoBancaria validaNome(InstituicaoBancaria banco) {
        if ((banco.equals(InstituicaoBancaria.NUBANK)) ||
                banco.equals(InstituicaoBancaria.ITAU)) {
            return banco;
        } else {
            throw new InstituicaoInvalida("Essa instituição não oferece esse tipo de conta.");
        }
    }
    //método sobrescrevido para implementação de regras. Aqui são permitidos saques apenas acima de R$ 10,00
    //caso o valor solicitado esteja abaixo entra na Exception ValoraAbaixoEsperado.
    @Override
    public void sacar(Double valor) {
        if (valor >= 10) {
            super.sacar(valor);
        } else {
            throw new ValorInvalidoSaque("Saques em contas digitais são permitidos a partir de " +
                    "R$ 10,00");
        }
    }

    @Override
    public String toString() {
        return "Conta Digital " + super.toString();
    }

}
