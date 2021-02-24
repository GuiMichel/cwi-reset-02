package br.com.banco.desgraca.exception;

public class ValorInvalidoSaque extends RuntimeException {

    public ValorInvalidoSaque(String mensagemDeErro) {
        super(mensagemDeErro);
    }
}
