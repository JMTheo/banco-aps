package com.uam.poo.model;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * User: theo
 * Date: 16/10/2019
 * Time: 19:50
 */
public class Banco {
    private ArrayList<Conta> listaConta;

    public Banco() {
        this.listaConta = new ArrayList<>();
    }

    public ArrayList<Conta> getListaConta(){
        return this.listaConta;
    }

    public void adicionar(Conta c){
       // c.setCliente(this.getConta(c.getNumero()));
        this.listaConta.add(c);
    }

    public String listar(){return this.toString();}

    public String pesquisar(int numero){
        String dadosConta = "";
        for (Conta contaCad :this.listaConta) {
            if(numero == contaCad.getNumero())
                dadosConta = contaCad.imprimir();
        }
        return dadosConta;
    }
    public Conta getConta(int numero){
        for (Conta contaCad :this.listaConta) {
            if(numero == contaCad.getNumero())
                return contaCad;
        }
        return null;
    }
    public boolean remover(int numero){
        boolean status = false;
        for (Conta contaCad :this.listaConta) {
            if(numero == contaCad.getNumero()){
                this.listaConta.remove(numero);
                status = true;
            }
        }
        return status;
    }

    @Override
    public String toString() {
        return "Banco{" +
                "listaConta=" + listaConta +
                '}';
    }
}
;