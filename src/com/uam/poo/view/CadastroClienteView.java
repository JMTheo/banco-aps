package com.uam.poo.view;

import com.uam.poo.model.Cliente;
import com.uam.poo.model.GerenciaCliente;

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
        GerenciaCliente gerenciaCliente = GerenciaCliente.getInstance();

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
                String cpf;
                cpf = txtCPF.getText();
                if(gerenciaCliente.existCPF(cpf))
                    JOptionPane.showMessageDialog(null,"CPF já cadastrado !", "Cadastro de cliente", JOptionPane.WARNING_MESSAGE);
                else{
                    gerenciaCliente.adicionar(cadCliente());
                    txtCPF.setText(null);
                    txtNome.setText(null);
                    txtTelefone.setText(null);
                    int controleLoop = JOptionPane.showConfirmDialog(panelCadCliente,"Deseja continuar cadastrando clientes ?", "Cadastro de Clientes", 1);
                    //Controle dos botoes do JOptionPane
                    switch (controleLoop){
                        case 1:
                        case 2:
                        case -1:
                            dispose();
                            //gerenciaCliente.listar();

                            //this.objGerenciCliente.listar();
                            break;
                        default:
                            break;
                    }
                }
            }
        });
    }

    private Cliente cadCliente(){
        return new Cliente(txtNome.getText(), txtCPF.getText(), txtTelefone.getText());
    }


}

