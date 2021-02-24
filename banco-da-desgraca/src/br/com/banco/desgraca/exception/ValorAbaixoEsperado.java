package br.com.banco.desgraca.exception;

public class ValorAbaixoEsperado extends RuntimeException {

    public ValorAbaixoEsperado(String mensagemDeErro) {
        super(mensagemDeErro);
    }
}