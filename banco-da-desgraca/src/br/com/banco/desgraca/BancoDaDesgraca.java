package br.com.banco.desgraca;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.conta.ContaBase;
import br.com.banco.desgraca.domain.conta.ContaCorrente;
import br.com.banco.desgraca.domain.conta.ContaDigital;
import br.com.banco.desgraca.domain.conta.ContaPoupanca;
import java.time.LocalDate;

public class BancoDaDesgraca {

    public static void main(String[] args) throws Exception {


        ContaBase teste1 = new ContaDigital(111, InstituicaoBancaria.NUBANK, 0.0);
        ContaBase teste2 = new ContaCorrente(222, InstituicaoBancaria.ITAU, 0.0);
        ContaBase teste3 = new ContaPoupanca(333, InstituicaoBancaria.BANCO_DO_BRASIL, 0.0);
        ContaBase teste4 = new ContaPoupanca(444, InstituicaoBancaria.BRADESCO, 0.0);
        ContaBase teste5 = new ContaPoupanca(555, InstituicaoBancaria.CAIXA, 0.0);


        teste5.depositar(1000.0);
        teste4.depositar(500.00);
        teste3.depositar(200.00);
        teste3.sacar(100.0);
        teste1.depositar(150.00);
        teste2.depositar(100.00);
        teste2.transferir(30.0, teste1);
        teste1.sacar(50.00);
        teste2.sacar(20.0);
        teste5.transferir(200.0,teste3);
        System.out.println(teste2.consultarSaldo());


        teste2.exibirExtrato(null,null);
        teste1.exibirExtrato(LocalDate.of(2020,07,01),null);
        teste3.exibirExtrato(null,LocalDate.of(2020,8,30));
        teste4.exibirExtrato(LocalDate.of(2020,01,01),LocalDate.of(2020,12,30));
        teste5.exibirExtrato(null,null);




    }
}