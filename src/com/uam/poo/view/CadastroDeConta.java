package com.uam.poo.view;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
import com.uam.poo.FabricaConta;
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
    private JTextField txtSaldo;

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
                System.out.println("Opa Comum");
                setNumeroRadio(0);
            }
        });

        radioBtnEspecial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Opa especial");
                setNumeroRadio(1);
            }
        });

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(radioGroup.getSelection() == null)
                    JOptionPane.showMessageDialog(panelCadConta, "É preciso selecionar um tipo de conta", "Erro ao salvar", JOptionPane.ERROR_MESSAGE);

                int numero = cmbCliente.getSelectedIndex();

                Conta c = FabricaConta.fabricarConta(getNumeroRadio());
                c.setDataAbertura(LocalDate.now());
                c.setSaldo(Double.parseDouble(txtSaldo.getText()));
                c.setNumero(numero);
                c.setCliente(gerenciaCliente.getListaCliente().get(numero));
                banco.adicionar(c);
                System.out.println(banco.listar());
                //TODO: Colocar um JOptionPane para perguntar se quqer continuar cadastrando conta
                dispose();
            }
        });
    }


    public int getNumeroRadio() {
        return numeroRadio;
    }

    public void setNumeroRadio(int numeroRadio) {
        this.numeroRadio = numeroRadio;
    }
}
