/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fernandowirtz.mly_tarea04;

/**
 *
 * @author yago.martinezloureda
 */

import java.util.LinkedList;
import java.util.Queue;

public class Caja extends Thread {
    private int idC;
    private Queue<Cliente> cola;
    private boolean abierta;

    public Caja(int id) {
        this.idC = id;
        this.cola = new LinkedList<>();
        this.abierta = true; 
    }

    @Override
    public void run() {
        while (abierta || !cola.isEmpty()) {
            if (!cola.isEmpty()) {
                Cliente cliente = cola.poll();
                procesarCliente(cliente);
            }
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void agregarCliente(Cliente cliente) {
        cola.offer(cliente);
        System.out.println("Cliente " + cliente.getIdCliente() + " se ha agregado a la caja " + idC);
    }

    private void procesarCliente(Cliente cliente) {
        System.out.println("Caja " + idC + " procesando al cliente " + cliente.getIdCliente());
        try {
            Thread.sleep(cliente.getNumArticulos() * 1000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Caja " + idC + " termino con el cliente " + cliente.getIdCliente());
    }

    public int getTamanoCola() {
        return cola.size();
    }

    public boolean estaAbierta() {
        return abierta;
    }

    public void cerrarCaja() {
        this.abierta = false;
        System.out.println("Caja " + idC + " ha sido cerrada.");
    }

    public int getIdC() {
        return idC;
    }
}

