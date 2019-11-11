package com.uam.poo.view;

import com.uam.poo.MaskFactory;
import com.uam.poo.model.Banco;
import com.uam.poo.model.Conta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: theo
 * Date: 11/11/2019
 * Time: 12:57
 */
public class Transferencia extends JFrame {
    private JPanel panelTransferencia;
    private JComboBox<Integer> cmbContaDest;
    private JLabel lblNomeDest;
    private JComboBox<Integer> cmbContaOrig;
    private JLabel lblNomeOrig;
    private JTextField fTxtQuantia;
    private JButton btnVoltar;
    private JButton btnTransferir;

    public Transferencia(){
        add(panelTransferencia);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Transferencia de dinheiro");
        setMinimumSize(new Dimension(600, 250)); //Definindo um tamanho inicial
        setLocationRelativeTo(rootPane); //Deixando para iniciar o programa centralizado

        Banco banco = Banco.getInstance();

        for(Conta conta: banco.getListaConta()){
            cmbContaDest.addItem(conta.getNumero());
            cmbContaOrig.addItem(conta.getNumero());
        }

        Conta contaInicialDest = banco.getConta(cmbContaDest.getSelectedIndex());
        Conta contaInicialOrig = banco.getConta(cmbContaOrig.getSelectedIndex() + 1);

        lblNomeDest.setText(contaInicialDest.getCliente().getNome());
        lblNomeOrig.setText(contaInicialOrig.getCliente().getNome());

        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        btnTransferir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(fTxtQuantia.getText().isEmpty()){
                    JOptionPane.showMessageDialog(panelTransferencia,"Campo quantia não pode ser vazio");
                }else{
                    transferencia();
                }
            }
        });

        cmbContaDest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Conta contaEscolhida = banco.getConta(cmbContaDest.getSelectedIndex());
                lblNomeDest.setText(contaEscolhida.getCliente().getNome());
            }
        });

        cmbContaOrig.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Conta contaEscolhida = banco.getConta(cmbContaOrig.getSelectedIndex());
                lblNomeOrig.setText(contaEscolhida.getCliente().getNome());
            }
        });
    }
    private void transferencia(){
        Banco banco = Banco.getInstance();
        Conta cOrig = banco.getConta(cmbContaOrig.getSelectedIndex());
        Conta cDest = banco.getConta(cmbContaDest.getSelectedIndex());

        String valor = fTxtQuantia.getText();
        double saldo = Double.parseDouble(valor.replace(',','.'));

        if(cOrig.transferir(cDest, saldo)){
            JOptionPane.showMessageDialog(panelTransferencia, "Dinheiro transferido com sucesso", "Sucesso ao realizar a transação", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }else{
            JOptionPane.showMessageDialog(panelTransferencia, "Saldo insuficiente para realizar a transferencia", "Erro ao realizar a transação", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        fTxtQuantia = new JFormattedTextField(MaskFactory.mascara("####,##"));
        fTxtQuantia.setHorizontalAlignment(JFormattedTextField.RIGHT);
    }
}
