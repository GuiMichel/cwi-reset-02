package br.com.banco.desgraca.exception;

public class InstituicaoInvalida extends RuntimeException {

    public InstituicaoInvalida(String mensagemDeErro) {
        super(mensagemDeErro);
    }
}