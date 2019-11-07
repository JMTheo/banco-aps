package com.uam.poo;

import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;
import com.uam.poo.model.*;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * User: theo
 * Date: 01/11/2019
 * Time: 16:46
 */
//TODO: Desenvolver a criacao da conta
public class FabricaConta {
    public static Conta fabricarConta(int tipoConta){
        if(1 == tipoConta)
            return FabricaConta.criarContaEspecial();
        else
            return FabricaConta.criarConta();
    }

    private static ContaEspecial criarContaEspecial(){

        return new ContaEspecial();
    }
    private static Conta criarConta(){
        //TODO: Adicionar o resto da implementacao da conta simples
        String numeroCliente;
        float saldo;
        LocalDate dia =LocalDate.now();
        Conta c = new Conta();

        System.out.println(dia.toString());
        numeroCliente = JOptionPane.showInputDialog(null,"Digite o cpf do cliente para cadastrar a conta? ","Cadastro de conta", JOptionPane.QUESTION_MESSAGE);
        saldo = Float.parseFloat(JOptionPane.showInputDialog(null,"Digite o saldo inicial para abertura da conta", "Cadastro de conta", JOptionPane.QUESTION_MESSAGE));
        c.setSaldo(saldo);
        c.setDataAbertura(dia);
        return c;
    }

}
