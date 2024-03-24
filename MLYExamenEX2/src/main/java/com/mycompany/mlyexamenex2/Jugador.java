/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mlyexamenex2;

import java.time.LocalTime;

/**
 *
 * @author yago.martinezloureda
 */
public abstract class Jugador {
    public String nombre;
    public int coste;
    public LocalTime fNacimiento = LocalTime.now();

    public Jugador() {
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCoste() {
        return coste;
    }

    public void setCoste(int coste) {
        this.coste = coste;
    }

    public LocalTime getfNacimiento() {
        return fNacimiento;
    }

    public void setfNacimiento(LocalTime fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

}
