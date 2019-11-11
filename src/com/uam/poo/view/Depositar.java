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
    private JTextField fTxtQuantia;
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
                if(checarCampo()){
                    JOptionPane.showMessageDialog(panelDepositar,"O campo quantia precisa ser preenchido", "Erro ao depositar", JOptionPane.ERROR_MESSAGE);
                }else{
                    String valor = fTxtQuantia.getText();
                    double saldo = Double.parseDouble(valor.replace(',','.'));

                    banco.getConta(cmbContas.getSelectedIndex()).depositar(saldo);
                    JOptionPane.showMessageDialog(panelDepositar, "Quantia adicionada com sucesso !");
                    dispose();
                }
            }
        });

        cmbContas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblNomeCli.setText(banco.getConta(cmbContas.getSelectedIndex()).getCliente().getNome());

            }
        });
    }

    private boolean checarCampo(){
        boolean status = false;
        if(fTxtQuantia.getText().isEmpty())
            status = true;

        return status;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        fTxtQuantia = new JFormattedTextField(MaskFactory.mascara("####,##"));
        fTxtQuantia.setHorizontalAlignment(JFormattedTextField.RIGHT);

    }
}
