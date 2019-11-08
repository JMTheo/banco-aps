package com.uam.poo.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: theo
 * Date: 07/11/2019
 * Time: 14:55
 */
public class CadastroClienteView extends JFrame {
    private JPanel panelCadCliente;
    private JLabel labelNome;
    private JTextField txtNome;
    private JLabel labelCPF;
    private JTextField txtCPF;
    private JLabel labelTelefone;
    private JTextField txtTelefone;
    private JButton btnSalvar;
    private JButton btnVoltar;

    public CadastroClienteView(){
        add(panelCadCliente);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Cadastro de Clientes");
        setMinimumSize(new Dimension(400, 200)); //Definindo um tamanho inicial
        setLocationRelativeTo(rootPane); //Deixando para iniciar o programa centralizado

        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int controleLoop = JOptionPane.showConfirmDialog(panelCadCliente,"Deseja continuar cadastrando clientes ?", "Cadastro de Clientes", 1);
                //Controle dos botoes do JOptionPane
                switch (controleLoop){
                    case 1:
                    case 2:
                    case -1:
                        dispose();
                        //this.objGerenciCliente.listar();
                        break;
                    default:
                        break;
                }
            }
        });
    }
}

