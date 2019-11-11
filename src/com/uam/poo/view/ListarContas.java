package com.uam.poo.view;

import com.uam.poo.model.Banco;
import com.uam.poo.model.Conta;
import com.uam.poo.model.ContaEspecial;

import javax.swing.*;
import javax.swing.table.*;
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

        add(panelListarContas);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Contas");
        setMinimumSize(new Dimension(600, 200)); //Definindo um tamanho inicial
        setLocationRelativeTo(rootPane); //Deixando para iniciar o programa centralizado

        //TODO: Fazer funcionar essa caralha de JTable
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        Banco banco = Banco.getInstance();

        String[] colunas = {"Numero", "Nome", "Data de Abertura", "Saldo", "Limite"};
        String[][] dados = new String[banco.getListaConta().size()][colunas.length];
        int i = 0;
        for(Conta objContas: banco.getListaConta()){
            String[] dadosUsuario = new String[colunas.length];
            dadosUsuario[0] ="" + objContas.getNumero();
            dadosUsuario[1] = objContas.getCliente().getNome();
            dadosUsuario[2] = objContas.getDataAbertura().toString();
            dadosUsuario[3] = "" + objContas.getSaldo();
            dadosUsuario[4] = objContas instanceof ContaEspecial ? "" + ((ContaEspecial) objContas).getLimite() : "Conta Comum";

            dados[i++] = dadosUsuario;
        }

        TableModel model = new DefaultTableModel(dados, colunas);
        table1 = new JTable(model);

        RowSorter<TableModel> sorter =  new TableRowSorter<TableModel>(model);
        table1.setRowSorter(sorter);
        //Deixando o conteudo das celulas centralizadas
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        dtcr.setHorizontalAlignment(SwingConstants.CENTER);
        for (i = 0; i < colunas.length; i++){
            table1.getColumn(colunas[i]).setCellRenderer(dtcr);
        }
    }
}
