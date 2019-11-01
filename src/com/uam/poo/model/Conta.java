package com.uam.poo.model;

import java.time.LocalDate;

/**
 * User: theo
 * Date: 16/10/2019
 * Time: 19:29
 */
public class Conta {
    private int numero;
    private Cliente cliente;
    private LocalDate dataAbertura;
    protected double saldo;

    public void depositar(double quantia){}
    public boolean debitar(double quantia){return true;}
    public boolean transferir(Conta destino, double quantia){return true;}
    public void imprimir(){}

}
