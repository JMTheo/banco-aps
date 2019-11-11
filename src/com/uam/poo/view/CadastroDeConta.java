package com.uam.poo.view;

import com.uam.poo.FabricaConta;
import com.uam.poo.MaskFactory;
import com.uam.poo.model.*;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

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
    private JButton btnSalvar;
    private JRadioButton radioBtnComum;
    private JLabel lblTipoConta;
    private JRadioButton radioBtnEspecial;
    private JLabel lblSaldo;
    private JTextField fTxtSaldo;

    private int numeroRadio;

    public CadastroDeConta() {
        GerenciaCliente gerenciaCliente = GerenciaCliente.getInstance();
        Banco banco = Banco.getInstance();

        add(panelCadConta);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Contas");
        setMinimumSize(new Dimension(400, 200)); //Definindo um tamanho inicial
        setLocationRelativeTo(rootPane); //Deixando para iniciar o programa centralizado

        //Criando um grupo de Radio Button
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(radioBtnComum);
        radioGroup.add(radioBtnEspecial);

        for(Cliente c: gerenciaCliente.getListaCliente())
        {
            cmbCliente.addItem(c.getNome());
        }

        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        radioBtnComum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNumeroRadio(0);
            }
        });

        radioBtnEspecial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNumeroRadio(1);
            }
        });

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(radioGroup.getSelection() == null)
                    JOptionPane.showMessageDialog(panelCadConta, "É preciso selecionar um tipo de conta", "Erro ao salvar", JOptionPane.ERROR_MESSAGE);

                int numero = cmbCliente.getSelectedIndex();

                String valor = fTxtSaldo.getText();
                double saldo = Double.parseDouble(valor.replace(',','.'));

                Conta c = FabricaConta.fabricarConta(getNumeroRadio());
                c.setDataAbertura(LocalDate.now());
                c.setSaldo(saldo);
                c.setNumero(numero);
                c.setCliente(gerenciaCliente.getListaCliente().get(numero));
                if(checarCadConta(c.getCliente()))
                    JOptionPane.showMessageDialog(panelCadConta, "Cliente ja cadastrado", "Erro ao adicionar conta", JOptionPane.ERROR_MESSAGE);
                else{
                    banco.adicionar(c);
                    JOptionPane.showMessageDialog(panelCadConta, "Conta cadastrada com sucesso", "Sucesso ao realizar o cadastro", JOptionPane.INFORMATION_MESSAGE);
                    fTxtSaldo.setText("");
                }
            }
        });
    }


    public int getNumeroRadio() {
        return numeroRadio;
    }

    public void setNumeroRadio(int numeroRadio) {
        this.numeroRadio = numeroRadio;
    }

    private boolean checarCadConta(Cliente c){
        Banco banco = Banco.getInstance();
        boolean status = false;
        for(Conta conta: banco.getListaConta())
        {
            if (c.getCpf().equals(conta.getCliente().getCpf())) {
                status = true;
                break;
            }
        }
        return status;

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        fTxtSaldo = new JFormattedTextField(MaskFactory.mascara("####,##"));
        fTxtSaldo.setHorizontalAlignment(JFormattedTextField.CENTER);
    }
}
