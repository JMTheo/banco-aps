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
    private  static Banco instanciaUnica;

    public static synchronized Banco getInstance(){
        if(instanciaUnica == null)
            instanciaUnica = new Banco();
        return instanciaUnica;
    }

    private Banco() {
        this.listaConta = new ArrayList<>();
    }

    public ArrayList<Conta> getListaConta(){
        return this.listaConta;
    }

    public void adicionar(Conta c){
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
    //public Conta getConta(int numero){}
    public boolean remover(int numero){return true;}

    @Override
    public String toString() {
        return "Banco{" +
                "listaConta=" + listaConta +
                '}';
    }
}
