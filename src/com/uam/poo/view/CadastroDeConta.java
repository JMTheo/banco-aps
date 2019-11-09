package com.uam.poo.view;

import com.uam.poo.model.Cliente;
import com.uam.poo.model.GerenciaCliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: theo
 * Date: 08/11/2019
 * Time: 22:05
 */
public class CadastroDeConta extends JFrame{
    private JPanel panelCadConta;
    private JLabel lblTitle;
    private JLabel lblCli;
    private JComboBox<String> cmbCliente;
    private JButton btnVoltar;

    public CadastroDeConta(){
        GerenciaCliente gerenciaCliente = GerenciaCliente.getInstance();

        add(panelCadConta);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Contas");
        setMinimumSize(new Dimension(400, 200)); //Definindo um tamanho inicial
        setLocationRelativeTo(rootPane); //Deixando para iniciar o programa centralizado

        for(Cliente c: gerenciaCliente.getListaCliente())
        {
            cmbCliente.addItem(c.getNome());

        }
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(cmbCliente.getSelectedIndex());
            }
        });
    }

}
