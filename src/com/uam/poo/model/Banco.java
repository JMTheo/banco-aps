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

    public ArrayList<Conta> getListaConta(){
        return this.listaConta;
    }

    public void adicionar(Conta c){}
    public String listar(){return "opa";}
    public String pesquisar(int numero){return "opa";}
    //public Conta getConta(int numero){}
    public boolean remover(int numero){return true;}
}
