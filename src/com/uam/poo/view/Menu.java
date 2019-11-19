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

        buttonMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: Colocar um filtro de acesso em todos os menus
                String title = "Erro ao entrar no menu";
                switch (comboBox1.getSelectedIndex()){
                    case 0:
                        CadastroCliente cadastroCliente = new CadastroCliente();
                        dispose();
                        cadastroCliente.setVisible(true);
                        break;
                    case 1:
                        if(checarCadUser())
                        {
                            CadastroDeConta cadastroDeConta = new CadastroDeConta();
                            cadastroDeConta.setVisible(true);
                        }else{
                            JOptionPane.showMessageDialog(panelMenuPrincipal,"Você deve ter clientes cadastrados antes de cadastrar uma conta", title, JOptionPane.WARNING_MESSAGE);
                        }
                        break;
                    case 2:
                        if(checarCadConta()){
                            ListarContas listarContas = new ListarContas();
                            listarContas.setVisible(true);
                        }else{
                            JOptionPane.showMessageDialog(panelMenuPrincipal,"Você deve ter uma conta cadastrada", title, JOptionPane.WARNING_MESSAGE);
                        }
                        break;
                    case 3:
                        //Pesquisar Conta
                        if(checarCadConta()){
                            PesquisarConta pesquisarConta = new PesquisarConta();
                            pesquisarConta.setVisible(true);
                        }else{
                            JOptionPane.showMessageDialog(panelMenuPrincipal,"Você deve ter uma conta cadastrada", title, JOptionPane.WARNING_MESSAGE);
                        }
                        break;
                    case 4:
                        //Depositar
                        if(checarCadConta()){
                            Depositar depositar = new Depositar();
                            depositar.setVisible(true);
                        }else{
                            JOptionPane.showMessageDialog(panelMenuPrincipal,"Você deve ter uma conta cadastrada", title, JOptionPane.WARNING_MESSAGE);
                        }
                        break;
                    case 5:
                        //Debitar
                        if (checarCadConta()){
                            Debitar debitar = new Debitar();
                            debitar.setVisible(true);
                        }else{
                            JOptionPane.showMessageDialog(panelMenuPrincipal,"Você deve ter uma conta cadastrada", title, JOptionPane.WARNING_MESSAGE);
                        }

                        break;
                    case 6:
                        //Transferir
                        if(checarCadConta()){
                            Transferencia transferencia = new Transferencia();
                            transferencia.setVisible(true);
                        }else{
                            JOptionPane.showMessageDialog(panelMenuPrincipal,"Você deve ter uma conta cadastrada", title, JOptionPane.WARNING_MESSAGE);
                        }
                        break;
                    case 7:
                        //Remover Conta
                        if (checarCadConta()){
                            RemoverConta removerConta = new RemoverConta();
                            removerConta.setVisible(true);
                        }else{
                            JOptionPane.showMessageDialog(panelMenuPrincipal,"Você deve ter uma conta cadastrada", title, JOptionPane.WARNING_MESSAGE);
                        }
                        break;
                    case 8:
                        //Sair
                        JOptionPane.showMessageDialog(panelMenuPrincipal, "Fechando o programa ...", "Fechando", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                        break;
                }
            }
        });
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");  // This line gives Windows Theme

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
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

    private boolean checarCadUser(){
        GerenciaCliente objGerenciaCli = GerenciaCliente.getInstance();
        return  !objGerenciaCli.getListaCliente().isEmpty();
    }

    private boolean checarCadConta(){
        Banco banco = Banco.getInstance();
        return !banco.getListaConta().isEmpty();
    }

}
