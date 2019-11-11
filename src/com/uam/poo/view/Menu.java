package com.uam.poo.view;

import com.uam.poo.FabricaConta;
import com.uam.poo.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

/**
 * User: theo
 * Date: 07/11/2019
 * Time: 14:13
 */
public class Menu extends JFrame {
    private JButton buttonMenu;
    private JPanel panelMenuPrincipal;
    private JLabel label1;
    private JComboBox comboBox1;

    public Menu() {
        GerenciaCliente gerenciaCliente = GerenciaCliente.getInstance();

        //Funcao para teste
        testeCadUser();

        buttonMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(comboBox1.getSelectedIndex());
                switch (comboBox1.getSelectedIndex()){
                    case 0:
                        CadastroCliente cadastroCliente = new CadastroCliente();
                        dispose();
                        cadastroCliente.setVisible(true);
                        break;
                    case 1:
                        String title = "Cadastro de conta";
                        Object[] tiposDeContas = {"Comum","Especial"};

                        if(checarCadConta())
                        {
                            CadastroDeConta cadastroDeConta = new CadastroDeConta();
                            cadastroDeConta.setVisible(true);
                        }else{
                            JOptionPane.showMessageDialog(panelMenuPrincipal,"Vc deve ter clientes cadastrados antes de cadastrar uma conta", title, JOptionPane.WARNING_MESSAGE);
                        }
                        break;
                    case 2:
                        //TODO: Arrumar o Listar!!!
                        ListarContas listarContas = new ListarContas();
                        listarContas.setVisible(true);
                        break;
                    case 3:
                        //Pesquisar Conta
                        PesquisarConta pesquisarConta = new PesquisarConta();
                        pesquisarConta.setVisible(true);
                        break;
                    case 4:
                        //Depositar
                        Depositar depositar = new Depositar();
                        depositar.setVisible(true);
                        break;
                    case 5:
                        //Debitar
                        Debitar debitar = new Debitar();
                        debitar.setVisible(true);
                        break;
                    case 6:
                        //Transferir
                        break;
                    case 7:
                        //Remover Conta
                        RemoverConta removerConta = new RemoverConta();
                        removerConta.setVisible(true);
                        break;
                    case 8:
                        //Sair
                        System.exit(0);
                        break;
                }
            }
        });
    }



    public static void main(String[] args) {
        initTela();
    }

    private static void initTela(){
        JFrame tela = new JFrame("Menu");
        tela.setContentPane(new Menu().panelMenuPrincipal);
        //Não permite o usuario fechar a tela pelo controle
        tela.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        tela.pack(); //Nao tenho a menor ideia do que isso faz
        tela.setLocationRelativeTo(null); //Deixando para iniciar o programa centralizado
        tela.setTitle("Menu do Banco");
        tela.setMinimumSize(new Dimension(400, 200)); //Definindo um tamanho inicial
        tela.setVisible(true); // Deixando o panel Visivel

    }

    private static boolean checarCadConta(){
        GerenciaCliente objGerenciaCli = GerenciaCliente.getInstance();
        return  !objGerenciaCli.getListaCliente().isEmpty();
    }

    private static void testeCadUser(){
        GerenciaCliente objGerencia = GerenciaCliente.getInstance();
        Cliente cliente = new Cliente("joao", "123", "123");
        Cliente cliente2 = new Cliente("Max", "321", "123");
        Cliente cliente3 = new Cliente("Carminha", "432", "123");
        objGerencia.adicionar(cliente);
        objGerencia.adicionar(cliente2);
        objGerencia.adicionar(cliente3);

        Conta c = new ContaEspecial(1,cliente, LocalDate.now(),100, 200);
        Conta c1 = new Conta(0,cliente2, LocalDate.now(),100);
        Conta c2 = new Conta(2,cliente3, LocalDate.now(),0);

        Banco banco = Banco.getInstance();
        banco.adicionar(c1);
        banco.adicionar(c);
        banco.adicionar(c2);
    }

}
