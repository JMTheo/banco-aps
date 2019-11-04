package com.uam.poo;
import com.uam.poo.model.*;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        boolean controle = true;
        String escolha;
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        FabricaConta fabricaConta = new FabricaConta();
        GerenciaCliente gerenciaCliente = new GerenciaCliente();
        Object[] tiposDeContas = {"Comum","Especial"};

        while (controle){
            escolha = interfaceUsuario.menu();

            switch (escolha){
                case "1 – Cadastrar Cliente":
                    System.out.println("OPA");
                    interfaceUsuario.setObjGerenciCliente(gerenciaCliente);
                    gerenciaCliente = interfaceUsuario.criarCliente();

                    break;
                case "2 – Cadastrar Conta":
                    String title = "Cadastro de conta";
                    if(!(gerenciaCliente.getListaCliente().isEmpty()))
                    {
                        int tipoConta = JOptionPane.showOptionDialog(null, "Escolha um tipo de conta", title, JOptionPane.DEFAULT_OPTION, 1,null, tiposDeContas, tiposDeContas[0]);
                        System.out.println(tipoConta);
                        Conta conta = FabricaConta.fabricarConta(tipoConta);
                    }else{
                        JOptionPane.showMessageDialog(null,"Vc deve ter clientes cadastrados antes de cadastrar uma conta", title, JOptionPane.WARNING_MESSAGE);
                    }


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
