package com.uam.poo.view;

import com.uam.poo.model.Banco;
import com.uam.poo.model.Conta;
import com.uam.poo.model.ContaEspecial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: theo
 * Date: 10/11/2019
 * Time: 20:11
 */
public class Debitar extends JFrame {
    private JButton btnVoltar;
    private JLabel lblTitle;
    private JLabel lblCli;
    private JButton btnSacar;
    private JLabel lblQuantia;
    private JLabel lblNomeCliente;
    private JComboBox<Integer> cmbContas;
    private JTextField txtQuantia;
    private JLabel lblNomeCli;
    private JPanel panelSaque;

    public Debitar() {
        Banco banco = Banco.getInstance();

        add(panelSaque);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Depositar dinheiro");
        setMinimumSize(new Dimension(400, 200)); //Definindo um tamanho inicial
        setLocationRelativeTo(rootPane); //Deixando para iniciar o programa centralizado

        for (Conta conta: banco.getListaConta())
            cmbContas.addItem(conta.getNumero());
        lblNomeCli.setText(banco.getConta(cmbContas.getSelectedIndex()).getCliente().getNome());

        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        cmbContas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblNomeCli.setText(banco.getConta(cmbContas.getSelectedIndex()).getCliente().getNome());
            }
        });

        btnSacar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sacar();
            }
        });
    }

    private void sacar(){
        Banco banco = Banco.getInstance();
        Conta c = banco.getConta(cmbContas.getSelectedIndex());

        //Problema ao depositar em contaEspecial
        if(txtQuantia.getText().equals(""))
            JOptionPane.showMessageDialog(panelSaque, "O campo quantia deve ser preenchido", "Erro ao sacar", JOptionPane.ERROR_MESSAGE);
        else{
            if(c.debitar(Double.parseDouble(txtQuantia.getText())))
                JOptionPane.showMessageDialog(panelSaque, "Quantia sacada com sucesso !");
            else
                JOptionPane.showMessageDialog(panelSaque, "Não foi possível sacar a quantia, verifique o saldo !");

            dispose();
        }
    }
}
