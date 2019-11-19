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
 * Time: 02:47
 */

public class RemoverConta extends JFrame {
    private JLabel lblTitle;
    private JComboBox<Integer> cmbContas;
    private JButton btnVoltar;
    private JButton btnExcluir;
    private JPanel panelRemover;
    private JLabel lbllConta;
    private JLabel lblNomeCli;

    public RemoverConta() {
        Banco banco = Banco.getInstance();

        add(panelRemover);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Excluir Contas");
        setMinimumSize(new Dimension(400, 200)); //Definindo um tamanho inicial
        setLocationRelativeTo(rootPane); //Deixando para iniciar o programa centralizado

        for (Conta objConta : banco.getListaConta()) cmbContas.addItem(objConta.getNumero());
        lblNomeCli.setText(banco.getConta(cmbContas.getSelectedIndex()).getCliente().getNome());

        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Conta c = banco.getConta(cmbContas.getSelectedIndex());
                if (banco.remover(c.getNumero())){
                    JOptionPane.showMessageDialog(panelRemover, "Conta Excluida com sucesso !", "Confirmação de Exclusão", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog(panelRemover, "Não foi possível remover a conta, por favor saque tudo antes !", "Erro ao excluir conta", JOptionPane.ERROR_MESSAGE);
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
