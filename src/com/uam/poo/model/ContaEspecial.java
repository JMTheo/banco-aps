package com.uam.poo.model;

/**
 * User: theo
 * Date: 16/10/2019
 * Time: 19:41
 */
public class ContaEspecial extends Conta {
    private double limite;

    public ContaEspecial(){}

    public boolean debitar(){return true;}
    //TODO: Implementar o polimorfismo com o imprimir


    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
}
