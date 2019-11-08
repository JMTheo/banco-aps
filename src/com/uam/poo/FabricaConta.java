package com.uam.poo;

import com.uam.poo.model.*;

import javax.swing.*;
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
        int numeroConta;
        Cliente c;

        numeroConta = Integer.parseInt(JOptionPane.showInputDialog(null,"Para qual cliente deseja cadastrar uma conta? ","Cadastro de conta", JOptionPane.QUESTION_MESSAGE));
        System.out.println(numeroConta);
        return new Conta();
    }
}
