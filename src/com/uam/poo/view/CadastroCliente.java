package com.uam.poo.view;

import com.uam.poo.model.Cliente;
import com.uam.poo.model.GerenciaCliente;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: theo
 * Date: 07/11/2019
 * Time: 14:55
 */
public class CadastroCliente extends JFrame {
    private JPanel panelCadCliente;
    private JLabel labelNome;
    private JTextField txtNome;
    private JLabel labelCPF;
    private JLabel labelTelefone;
    private JButton btnSalvar;

    private JFormattedTextField fTxtTelefone;
    private JFormattedTextField fTxtCPF;

    public CadastroCliente(){
        GerenciaCliente gerenciaCliente = GerenciaCliente.getInstance();

        add(panelCadCliente);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Clientes");
        setMinimumSize(new Dimension(400, 200)); //Definindo um tamanho inicial
        setLocationRelativeTo(rootPane); //Deixando para iniciar o programa centralizado


        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf;
                cpf = fTxtCPF.getText();
                if(gerenciaCliente.existCPF(cpf))
                    JOptionPane.showMessageDialog(null,"CPF já cadastrado !", "Cadastro de cliente", JOptionPane.WARNING_MESSAGE);
                else{
                    gerenciaCliente.adicionar(cadCliente());
                    fTxtCPF.setText(null);
                    txtNome.setText(null);
                    fTxtTelefone.setText(null);
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
        return new Cliente(txtNome.getText(), fTxtCPF.getText(), fTxtTelefone.getText());
    }

    public MaskFormatter mascara(String Mascara){

        MaskFormatter F_Mascara = new MaskFormatter();
        try{
            F_Mascara.setMask(Mascara); //Atribui a mascara
            F_Mascara.setPlaceholderCharacter(' '); //Caracter para preencimento
        }
        catch (Exception excecao) {
            excecao.printStackTrace();
        }
        return F_Mascara;
    }
    private void createUIComponents() {
        fTxtTelefone = new JFormattedTextField(mascara("(##) #####-####"));
        fTxtCPF = new JFormattedTextField(mascara("###.###.###-##"));
    }
}

