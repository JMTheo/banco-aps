package com.uam.poo;

import com.uam.poo.model.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;


/**
 * User: theo
 * Date: 20/10/2019
 * Time: 15:38
 */
public class InterfaceUsuario {
    public ArrayList<Cliente> testarCliente(){
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        Cliente c = new Cliente("Joao M", "000.000.000-07", "11 95127-6174");
        Cliente cc = new Cliente("Alessandra S", "111.114.111-07", "11 12121-6174");
        clientes.add(c);
        clientes.add(cc);
        return clientes;
    }
    public ArrayList<Cliente> criarCliente(){
        String nome, cpf, telefone;
        int controleLoop;
        boolean controle = true;
        ArrayList<Cliente> clientes = new ArrayList<>();
        while(controle){
            nome = JOptionPane.showInputDialog(null,"Qual é o seu nome ? ","Cadastro de cliente", JOptionPane.QUESTION_MESSAGE);
            cpf = JOptionPane.showInputDialog(null,"Qual é o seu cpf ?","Cadastro de cliente", JOptionPane.QUESTION_MESSAGE);
            telefone = JOptionPane.showInputDialog(null,"Qual é o seu telefone ?","Cadastro de cliente", JOptionPane.QUESTION_MESSAGE);
            Cliente c = new Cliente(nome,cpf,telefone);
            clientes.add(c);


            controleLoop = JOptionPane.showConfirmDialog(null,"Deseja continuar cadastrando clientes ?", "Cadastro de Clientes", 1);

            //Controle dos botoes do JOptionPane
            switch (controleLoop){
                case 1:
                case 2:
                case -1:
                    controle = false;
                    break;
                default:
                    controle = true;
                    break;
            }
        }
        return clientes;
    }

    public void teste(){
        GerenciaCliente gerenciaCliente = new GerenciaCliente();
        ArrayList<Cliente> c = this.testarCliente();
        gerenciaCliente.adicionar(c);
        gerenciaCliente.listar();
    }

    public void menu(){
        Object[] itensMenu  = {
                "1 – Cadastrar Cliente",
                "2 – Cadastrar Conta",
                "3 – Listar Conta ",
                "4 – Pesquisar Conta",
                "5 – Depositar",
                "6 – Debitar (Sacar)",
                "7 – Transferir",
                "8 – Remover Conta",
                "9 – Sair"
        };
        Object valorSelecionado = JOptionPane.showInputDialog(null, "Escolha um item", "Menu do Banco", JOptionPane.INFORMATION_MESSAGE, null, itensMenu, itensMenu[0]);
        System.out.println(valorSelecionado.toString());
    }

}
