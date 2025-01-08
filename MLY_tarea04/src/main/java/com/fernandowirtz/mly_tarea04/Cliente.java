/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fernandowirtz.mly_tarea04;

/**
 *
 * @author yago.martinezloureda
 */


public class Cliente extends Thread {
    private int idCliente;
    private int numArticulos;
    private Supermercado supermercado;

    public Cliente(int idCliente, Supermercado supermercado) {
        this.idCliente = idCliente;
        this.supermercado = supermercado;
        this.numArticulos = (int) (Math.random() * 10) + 1; 
    }

    @Override
    public void run() {
        supermercado.agregarClienteACola(this);
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getNumArticulos() {
        return numArticulos;
    }
}
