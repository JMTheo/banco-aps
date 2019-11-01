package com.uam.poo.model;

import javax.swing.*;
import java.util.ArrayList;

/**
 * User: theo
 * Date: 16/10/2019
 * Time: 19:48
 */
public class GerenciaCliente {
    private ArrayList<Cliente> listaCliente;

    public ArrayList<Cliente> getListaCliente() {
        return this.listaCliente;
    }


    public void listar() {
        //ForEach OO
        for (Cliente cliente : this.listaCliente) {
            String texto = "Nome: " + cliente.getNome() + "\nCPF: " + cliente.getCpf() + "\nTelefone: " + cliente.getTelefone();
            JOptionPane.showMessageDialog(null,texto, "Informações dos clientes", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public boolean existCPF(Cliente cliente){ return true;}

    public void adicionar(ArrayList<Cliente> listaCliente){
        this.listaCliente = listaCliente;
    }
}
