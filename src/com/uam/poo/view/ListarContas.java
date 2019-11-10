package com.uam.poo.view;

import com.uam.poo.model.Banco;
import com.uam.poo.model.Conta;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

/**
 * User: theo
 * Date: 10/11/2019
 * Time: 14:42
 */
public class ListarContas extends JFrame {

    private JButton btnVoltar;
    private JPanel panelListarContas;
    private JTable table1;

    public ListarContas() {
        Banco banco = Banco.getInstance();

        add(panelListarContas);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Contas");
        setMinimumSize(new Dimension(400, 200)); //Definindo um tamanho inicial
        setLocationRelativeTo(rootPane); //Deixando para iniciar o programa centralizado

        //TODO: Fazer funcionar essa caralha de JTable
        String[] colunas = {"Numero", "Nome", "Data de Abertura", "Saldo"};
        String[][] dados = new String[banco.getListaConta().size()][colunas.length];
        int i = 0;
        for(Conta objContas: banco.getListaConta()){
            String[] dadosUsuario = new String[colunas.length];
            dadosUsuario[0] ="" + objContas.getNumero();
            dadosUsuario[1] = objContas.getCliente().getNome();
            dadosUsuario[2] = objContas.getDataAbertura().toString();
            dadosUsuario[3] = "" + objContas.getSaldo();

            dados[i++] = dadosUsuario;
        }
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
