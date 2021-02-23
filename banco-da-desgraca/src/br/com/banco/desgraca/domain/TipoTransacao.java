
package br.com.banco.desgraca.domain;

public enum TipoTransacao {

    ENTRADA("+"),
    SAIDA("-");

    TipoTransacao(String sinal){
        this.sinal = sinal;
    }

    private String sinal;

    public String getSinal() {
        return sinal;
    }
}