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

    public void depositar(double quantia){
        this.saldo += quantia;
    }
    public boolean debitar(double quantia){
        boolean status = false;
        if(quantia < this.saldo){
            this.saldo -= quantia;
            status = true;
        }
        return status;
    }
    public boolean transferir(Conta destino, double quantia){
        boolean status = false;
        if(quantia < this.saldo){
            this.saldo -= quantia;
            destino.saldo += quantia;
            status = true;
        }
        return status;
    }
    public String imprimir(){
        return this.toString();
    }

    public Conta(){
        this.numero = 0;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numero=" + numero +
                ", cliente=" + cliente +
                ", dataAbertura=" + dataAbertura +
                ", saldo=" + saldo +
                '}';
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Conta(int numero, Cliente cliente, LocalDate dataAbertura, double saldo) {
        this.numero = numero;
        this.cliente = cliente;
        this.dataAbertura = dataAbertura;
        this.saldo = saldo;
    }
}
