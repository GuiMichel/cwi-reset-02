package br.com.banco.desgraca;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TipoTransacao;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.domain.conta.ContaBase;
import br.com.banco.desgraca.domain.conta.ContaCorrente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BancoDaDesgraca {

    public static void main(String[] args) throws Exception {




        ContaBase teste1 = new ContaCorrente(111, InstituicaoBancaria.NUBANK,0.0);
        ContaBase teste2 = new ContaCorrente(222, InstituicaoBancaria.ITAU,0.0);


        teste1.depositar(100.00);

        teste1.sacar(20.0);

        teste1.transferir(20.00,teste2);

//        teste1.exibirExtrato(LocalDate.of(2020,7,1),
//                LocalDate.of(2020,7,14));
        teste1.exibirExtrato(null,LocalDate.of(2020,7,14));








    }
}