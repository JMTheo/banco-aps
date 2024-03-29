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
    private static GerenciaCliente instanciaUnica;

    public static synchronized GerenciaCliente getInstance() {
        if (instanciaUnica == null)
            instanciaUnica = new GerenciaCliente();

        return instanciaUnica;
    }


    private GerenciaCliente() {
        this.listaCliente = new ArrayList<>();
    }

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
    public boolean existCPF(String cpf){
        boolean status = false;
        for(Cliente clienteCad: this.listaCliente){
            if(clienteCad.getCpf().equals(cpf))
                status = true;
        }
        return status;
    }

    public void adicionar(Cliente cliente){
        this.listaCliente.add(cliente);
    }

}
