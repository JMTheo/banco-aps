package com.uam.poo;

import com.uam.poo.model.*;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.util.ArrayList;

/**
 * User: theo
 * Date: 01/11/2019
 * Time: 16:46
 */
public class FabricaConta {
    public static Conta fabricarConta(int tipoConta){
        if(1 == tipoConta)
            return FabricaConta.criarContaEspecial();
        else
            return FabricaConta.criarConta();
    }

    private static ContaEspecial criarContaEspecial(){
        ContaEspecial c = new ContaEspecial();
        double limite = 0;
        boolean status = true;
        String vlr;
        while(status){
            try{
                vlr  = JOptionPane.showInputDialog(null, "Digite o valor limite da conta", "Cadastro de conta", JOptionPane.QUESTION_MESSAGE);
                vlr = vlr.replace(',', '.');
                limite = Double.parseDouble(vlr);
                status = false;
            }catch (NumberFormatException  e){
                JOptionPane.showMessageDialog(null, "Digite um numero valido");
            }
        }

        c.setLimite(limite);
        return c;
    }
    private static Conta criarConta(){
        return new Conta();
    }
}
