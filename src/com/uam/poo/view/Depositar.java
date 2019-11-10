package com.uam.poo.view;

import com.uam.poo.model.Banco;
import com.uam.poo.model.Conta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: theo
 * Date: 10/11/2019
 * Time: 18:04
 */
public class Depositar extends JFrame{
    private JButton btnVoltar;
    private JPanel panelDepositar;
    private JLabel lblTitle;
    private JLabel lblCli;
    private JButton btnDepositar;
    private JLabel lblQuantia;
    private JTextField txtQuantia;
    private JComboBox<Integer> cmbContas;
    private JLabel lblNomeCliente;
    private JLabel lblNomeCli;

    public Depositar() {
        Banco banco = Banco.getInstance();

        add(panelDepositar);
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
        btnDepositar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                banco.getConta(cmbContas.getSelectedIndex()).depositar(Double.parseDouble(txtQuantia.getText()));
                JOptionPane.showMessageDialog(panelDepositar, "Quantia adicionada com sucesso !");
                dispose();
            }
        });
        cmbContas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblNomeCli.setText(banco.getConta(cmbContas.getSelectedIndex()).getCliente().getNome());

            }
        });
    }

}
