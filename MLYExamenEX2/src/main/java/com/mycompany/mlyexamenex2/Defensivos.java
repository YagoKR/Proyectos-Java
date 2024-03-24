/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mlyexamenex2;

import java.util.Random;

/**
 *
 * @author yago.martinezloureda
 */
public class Defensivos extends Jugador implements Crackeable{
    
    public Defensivos(String nombre) {
        this.nombre = nombre;
        this.coste = 250;
    }
    
    public void defender () {
        coste *= 0.99;
        System.out.println(nombre + " - Zasca Zasca");
    }
    
    @Override
    public double entrenar () {
        coste += coste * 0.1;
        return coste;
    }
}


