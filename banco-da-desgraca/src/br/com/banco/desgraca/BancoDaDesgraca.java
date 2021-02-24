package br.com.banco.desgraca;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TipoTransacao;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.domain.conta.ContaBase;
import br.com.banco.desgraca.domain.conta.ContaCorrente;
import br.com.banco.desgraca.domain.conta.ContaDigital;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BancoDaDesgraca {

    public static void main(String[] args) throws Exception {




        ContaBase teste1 = new ContaDigital(111, InstituicaoBancaria.NUBANK,0.0);
        ContaBase teste2 = new ContaCorrente(222, InstituicaoBancaria.ITAU,0.0);

        teste1.depositar(150.00);
        teste2.depositar(100.00);
        teste2.transferir(30.0,teste1);
        teste1.sacar(50.00);
        teste2.sacar(20.0);
        System.out.println(teste2.consultarSaldo());



        teste2.exibirExtrato(LocalDate.of(2020,07,01),
                LocalDate.of(2020,07,30));
        teste1.exibirExtrato(LocalDate.of(2020,07,01),
                LocalDate.of(2020,07,30));

//        teste1.exibirExtrato(LocalDate.of(2020,7,1),
//                LocalDate.of(2020,7,14));









    }
}