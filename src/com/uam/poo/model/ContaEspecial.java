package com.uam.poo.model;

import javax.swing.*;
import java.time.LocalDate;

/**
 * User: theo
 * Date: 16/10/2019
 * Time: 19:41
 */
public class ContaEspecial extends Conta {
    private double limite;

    public ContaEspecial(){}

    public boolean debitar(double quantia){
        boolean status = false;
        if(this.limite+quantia < this.saldo){
            this.saldo -= quantia;
            status = true;
            JOptionPane.showMessageDialog(null,"CONTA ESPECIAL");
        }
        return status;
    }
    //TODO: Implementar o polimorfismo com o imprimir

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public ContaEspecial(int numero, Cliente cliente, LocalDate dataAbertura, double saldo, double limite) {
        super(numero, cliente, dataAbertura,saldo);
        this.limite = limite;
    }
}
