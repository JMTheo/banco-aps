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
 * Time: 14:03
 */
public class PesquisarConta extends JFrame {
    private JButton btnVoltar;
    private JPanel panelPesquisar;
    private JComboBox<Integer> cmbCliente;
    private JLabel lblNomeCli;
    private JLabel lblCPF;
    private JLabel lblDataAbertura;
    private JLabel lblSaldo;
    private JLabel lblLimiteCont;
    private JLabel lblLimite;
    private JButton btnPesquisarConta;

    public PesquisarConta() {
        Dimension dimension = new Dimension(500, 400);
        add(panelPesquisar);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisar Conta");
        setMinimumSize(dimension); //Definindo um tamanho inicial
        setMaximumSize(dimension);
        setLocationRelativeTo(rootPane); //Deixando para iniciar o programa centralizado

        Banco banco = Banco.getInstance();

        for(Conta conta: banco.getListaConta())
            cmbCliente.addItem(conta.getNumero());

        Conta contaInicial = banco.getConta(cmbCliente.getSelectedIndex());
        lblCPF.setText(contaInicial.getCliente().getCpf());
        lblNomeCli.setText(contaInicial.getCliente().getNome());
        lblDataAbertura.setText(contaInicial.getDataAbertura().toString());
        lblSaldo.setText("" + contaInicial.getSaldo());
        if(contaInicial instanceof ContaEspecial){
            lblLimiteCont.setText("" + ((ContaEspecial) contaInicial).getLimite());
        }else{
            lblLimiteCont.setText("Conta não tem limite");
        }

        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnPesquisarConta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        cmbCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Conta contaEscolhida = banco.getConta(cmbCliente.getSelectedIndex());
                lblCPF.setText(contaEscolhida.getCliente().getCpf());
                lblNomeCli.setText(contaEscolhida.getCliente().getNome());
                lblDataAbertura.setText(contaEscolhida.getDataAbertura().toString());
                lblSaldo.setText("" + contaEscolhida.getSaldo());
                if(contaEscolhida instanceof ContaEspecial){
                    lblLimiteCont.setText("" + ((ContaEspecial) contaEscolhida).getLimite());
                }else{
                    lblLimiteCont.setText("Conta não tem limite");

                }
            }
        });
    }
}
