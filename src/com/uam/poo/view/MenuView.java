package com.uam.poo.view;

import com.uam.poo.FabricaConta;
import com.uam.poo.model.Conta;
import com.uam.poo.model.GerenciaCliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: theo
 * Date: 07/11/2019
 * Time: 14:13
 */
public class MenuView extends JFrame {
    private JButton buttonMenu;
    private JPanel panelMenuPrincipal;
    private JLabel label1;
    private JComboBox comboBox1;

    public MenuView() {
        GerenciaCliente gerenciaCliente = GerenciaCliente.getInstance();
        buttonMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(comboBox1.getSelectedIndex());
                switch (comboBox1.getSelectedIndex()){
                    case 0:
                        CadastroClienteView cadastroClienteView = new CadastroClienteView();
                        cadastroClienteView.setVisible(true);
                        break;
                    case 1:
                        String title = "Cadastro de conta";
                        Object[] tiposDeContas = {"Comum","Especial"};

                        if(!(gerenciaCliente.getListaCliente().isEmpty()))
                        {
                            int tipoConta = JOptionPane.showOptionDialog(panelMenuPrincipal, "Escolha um tipo de conta", title, JOptionPane.DEFAULT_OPTION, 1,null, tiposDeContas, tiposDeContas[0]);
                            System.out.println(tipoConta);
                            Conta conta = FabricaConta.fabricarConta(tipoConta);
                        }else{
                            JOptionPane.showMessageDialog(panelMenuPrincipal,"Vc deve ter clientes cadastrados antes de cadastrar uma conta", title, JOptionPane.WARNING_MESSAGE);
                        }
                        break;
                    case 8:
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
        tela.setContentPane(new MenuView().panelMenuPrincipal);
        //Não permite o usuario fechar a tela pelo controle
        tela.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        tela.pack(); //Nao tenho a menor ideia do que isso faz
        tela.setLocationRelativeTo(null); //Deixando para iniciar o programa centralizado
        tela.setTitle("Menu do Banco");
        tela.setMinimumSize(new Dimension(400, 200)); //Definindo um tamanho inicial
        tela.setVisible(true); // Deixando o panel Visivel

    }

}
