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
    private GerenciaCliente objGerenciCliente;

    public void setObjGerenciCliente(GerenciaCliente obj){
        this.objGerenciCliente = obj;
    }
    public ArrayList<Cliente> testarCliente(){
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        Cliente c = new Cliente("Joao M", "000.000.000-07", "11 95127-6174");
        Cliente cc = new Cliente("Alessandra S", "111.114.111-07", "11 12121-6174");
        clientes.add(c);
        clientes.add(cc);
        return clientes;
    }
    public GerenciaCliente criarCliente(){
        String nome, cpf, telefone;
        int controleLoop;
        boolean controle = true;
        while(controle){
            nome = JOptionPane.showInputDialog(null,"Qual é o seu nome ? ","Cadastro de cliente", JOptionPane.QUESTION_MESSAGE);
            telefone = JOptionPane.showInputDialog(null,"Qual é o seu telefone ?","Cadastro de cliente", JOptionPane.QUESTION_MESSAGE);
            do {
                cpf = JOptionPane.showInputDialog(null,"Qual é o seu cpf ?","Cadastro de cliente", JOptionPane.QUESTION_MESSAGE);
                if(this.objGerenciCliente.existCPF(cpf))
                    JOptionPane.showMessageDialog(null,"Digite um cpf valido (unico) !", "Cadastro de cliente", JOptionPane.WARNING_MESSAGE);
            }while(this.objGerenciCliente.existCPF(cpf));
            Cliente c = new Cliente(nome,cpf,telefone);
            this.objGerenciCliente.adicionar(c);

        }
        return this.objGerenciCliente;
    }

    public String menu(){
        boolean controleLoop = true;
        Object valorSelecionado = null;
        Object[] itensMenu  = {
                "1 – Cadastrar Cliente",
                "2 – Cadastrar Conta",
                "3 – Listar Conta",
                "4 – Pesquisar Conta",
                "5 – Depositar",
                "6 – Debitar (Sacar)",
                "7 – Transferir",
                "8 – Remover Conta",
                "9 – Sair"
        };

        while(valorSelecionado == null){
            valorSelecionado= JOptionPane.showInputDialog(null, "Escolha um item", "Menu do Banco", JOptionPane.INFORMATION_MESSAGE, null, itensMenu, itensMenu[0]);
        }
        //Object valorSelecionado = JOptionPane.showOptionDialog(null, "Escolha um item", "Menu do Banco", 1, 1,null, itensMenu, itensMenu[0]);

        System.out.println(valorSelecionado.toString());
        return valorSelecionado.toString();
    }

}
