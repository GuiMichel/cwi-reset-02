package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.Data;
import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TipoTransacao;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
/* Esta classe abstrata serve como base para criação dos três tipos de conta.
* aqui estão implementados os métodos básicos das Contas Bancárias
* ficando para cada tipo de conta a implementação das suas particularidades.*/

public abstract class ContaBase implements ContaBancaria {
    private Integer numeroConta;
    private InstituicaoBancaria instituicaoBancaria;
    private Double saldo;
    private ArrayList<Transacao> transacoes = new ArrayList<>();
    private ArrayList<Transacao> extrato = new ArrayList<>();


    public ContaBase(Integer numeroConta, InstituicaoBancaria instituicaoBancaria, Double saldo) {
        this.numeroConta = numeroConta;
        this.instituicaoBancaria = validaNome(instituicaoBancaria);
        this.saldo = saldo;
    }

    //Método abstrato onde cada tipo de conta descreve suas regras para criação de uma nova conta.
    public abstract InstituicaoBancaria validaNome(InstituicaoBancaria banco);

    public String toString() {
        return this.instituicaoBancaria.getNomeInstituição() + " " + this.numeroConta;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }


    @Override
    public InstituicaoBancaria getInstituicaoBancaria() {
        return this.instituicaoBancaria;
    }


    @Override
    public Double consultarSaldo() {
        return this.saldo;
    }

    // Desenvolvi este método para utilizar nas operações onde é necessária a cobrança de taxa.
    public void cobraTaxa(Double taxa, Double valor) {
        this.setSaldo(this.consultarSaldo() - (taxa * valor));
    }

    @Override
    public void depositar(Double valor) {
        Transacao transacao = new Transacao(TipoTransacao.ENTRADA, Data.getDataTransacao(), valor, ContaBase.this);
        this.adicionaTransacao(transacao);
        this.saldo += valor;
        System.out.println("Depositando " + DecimalFormat.getCurrencyInstance().format(valor) +
                " na " + this.toString());
    }

    @Override
    public void sacar(Double valor) {
        if (this.saldo >= valor) {
            Transacao transacao = new Transacao(TipoTransacao.SAIDA, Data.getDataTransacao(), valor, ContaBase.this);
            this.adicionaTransacao(transacao);
            this.saldo -= valor;
            System.out.println("Sacando " + DecimalFormat.getCurrencyInstance().format(valor) +
                    " da " + this.toString());
        } else {
            throw new SaldoInsuficienteException("Saldo insufuciente");
        }
    }

    // Aqui o método para adicionar as transações de uma conta na ArrayList.
    public void adicionaTransacao(Transacao transacao) {
        transacoes.add(transacao);
    }

    /* O método transferir é o mais complexo pois envolve duas transações, aqui temos que salvar a data em
    * uma variável para que possamos utilizar a mesma data nas transações de entrada e saída e instanciar
    * uma conta bancária do tipo ContaBase para podemos utilizar métodos dessa classe.*/
    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {

        if (this.saldo >= valor) {

            LocalDate data = Data.getDataTransacao();

            Transacao transacao = new Transacao(TipoTransacao.SAIDA, data, valor, ContaBase.this);
            this.adicionaTransacao(transacao);
            this.saldo -= valor;

            //Na linha abaixo instancio uma nova Conta base para conseguir utilizar a mesma data,
            //tanto na transação de entrada como na transação de saída.
            ContaBase teste = (ContaBase) contaDestino;

            teste.saldo += valor;

            teste.adicionaTransacao(new Transacao(TipoTransacao.ENTRADA, data, valor, ContaBase.this));
            System.out.println("Transferindo " + DecimalFormat.getCurrencyInstance().format(valor) +
                    " da " + this.toString() + " para " + contaDestino.toString());
        } else {
            throw new SaldoInsuficienteException("Saldo insuficiente para transferir.");
        }

    }

    /*Método para emissão do extrato aqui são feitos todos os testes relacionados ao período desejado
    * para a emissão do mesmo, e após o teste as transações são adiciondas em uma ArrayList para posterior
    * impressão.*/
    @Override
    public void exibirExtrato(LocalDate inicio, LocalDate fim) {
        if ((inicio != null) && (fim != null)) {
            for (Transacao transacao : transacoes) {
                if ((transacao.getDataTransacao().isBefore(fim)) &&
                        (transacao.getDataTransacao().isAfter(inicio))) {
                    extrato.add(transacao);
                }
            }
        } else if (inicio != null) {
            for (Transacao transacao : transacoes) {
                if (transacao.getDataTransacao().isAfter(inicio)) {
                    extrato.add(transacao);

                }
            }
        } else if (fim != null) {
            for (Transacao transacao : transacoes) {
                if (transacao.getDataTransacao().isBefore(fim)) {
                    extrato.add(transacao);
                }
            }
        } else if (inicio == null && fim == null) {
            for (Transacao transacao : transacoes) {
                extrato.add(transacao);
            }
        }
        if (extrato.isEmpty()) {
            System.out.println("----- " + this.toString() + " -----\n" +
                      "Sem lançamentos para o período.\n" +
                    "Saldo atual: " + DecimalFormat.getCurrencyInstance().format(this.consultarSaldo()) +
                    "\n----- Fim do extrato -----\n\n");
        } else {
            System.out.println("----- " + this.toString() + " -----\n" +
                    extratoLista(extrato) + "\n" +
                    "Saldo atual: " + DecimalFormat.getCurrencyInstance().format(this.consultarSaldo()) +
                    "\n----- Fim do extrato -----\n\n");
        }

    }

    //Método utilizado para melhor exibição dos lançamentos.
    private String extratoLista(ArrayList<Transacao> lista) {

        String retorno = "";

        for (Transacao transacao : lista) {
            String x = transacao.toString();
            retorno = retorno.concat(x);

        }
        return retorno;
    }

}
