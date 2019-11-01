package com.uam.poo;
import com.uam.poo.model.*;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        boolean controle = true;
        String escolha;
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        FabricaConta fabricaConta = new FabricaConta();
        while (controle){
            escolha = interfaceUsuario.menu();

            switch (escolha){
                case "1 – Cadastrar Cliente":
                    System.out.println("OPA");
                    //interfaceUsuario.criarCliente();
                    interfaceUsuario.teste();
                    break;
                case "2 – Cadastrar Conta":
                    Object[] tiposDeContas = {"Comum","Especial"};
                    int tipoConta = JOptionPane.showOptionDialog(null, "Escolha um tipo de conta", "Cadastro de conta", JOptionPane.DEFAULT_OPTION, 1,null, tiposDeContas, tiposDeContas[0]);
                    System.out.println(tipoConta);
                    Conta conta = FabricaConta.fabricarConta(tipoConta);
                    break;
                case "3 – Listar Conta":
                    break;
                case "4 – Pesquisar Conta":
                    break;
                case "5 – Depositar":
                    break;
                case "6 – Debitar (Sacar)":
                    break;
                case "7 – Transferir":
                    break;
                case "8 – Remover Conta":
                    break;
                case "9 – Sair":
                    controle = false;
                    break;
            }

        }
    }
}
