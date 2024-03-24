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
public class Delanteros extends Ofensivos implements Crackeable {
    public int goles;
    
    public Delanteros(String nombre) {
        this.nombre = nombre;
        this.coste = 1000;
        this.goles = 0;
    }
    
    @Override
    public void atacar () {
        Random r = new Random ();
        int i = r.nextInt(0,coste);
        coste *= 0.99;
        if (i > 600) {
            goles++;
        }
        System.out.println(nombre + " - Tiki Taka");
    }
    
    @Override
    public double entrenar () {
        coste += coste * 0.1;
        return coste;
    }
    
}
