package com.uam.poo.controller;

import com.uam.poo.model.Cliente;
import com.uam.poo.model.GerenciaCliente;
import com.uam.poo.view.CadastroClienteView;
import com.uam.poo.view.GerenciaClienteView;

/**
 * User: theo
 * Date: 07/11/2019
 * Time: 13:55
 */
public class GerenciaClienteController {
    private GerenciaCliente model;
    private CadastroClienteView view;

    public GerenciaClienteController(GerenciaCliente model, CadastroClienteView view) {
        this.model = model;
        this.view  = view;
    }

    public void adicionarCliente(Cliente cliente) {
        this.model.adicionar(cliente);
    }

    public boolean existeCPF(Cliente cliente) {
        return this.model.existCPF(cliente.getCpf());
    }

    public void iniciarTela() {
        this.view.setVisible(true);
    }
}
