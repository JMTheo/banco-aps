package com.uam.poo.model;

/**
 * User: theo
 * Date: 16/10/2019
 * Time: 19:41
 */
public class ContaEspecial extends Conta {
    private double limite;
    private static ContaEspecial instanciaUnica;

    private ContaEspecial(){}

    public static synchronized  ContaEspecial getInstance(){
        if(instanciaUnica == null)
            instanciaUnica = new ContaEspecial();
        return instanciaUnica;
    }
    public boolean debitar(){return true;}
    //TODO: Implementar o polimorfismo com o imprimir
}
