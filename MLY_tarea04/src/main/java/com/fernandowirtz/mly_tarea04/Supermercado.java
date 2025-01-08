package com.fernandowirtz.mly_tarea04;

import com.fernandowirtz.mly_tarea04.Caja;
import com.fernandowirtz.mly_tarea04.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Supermercado {
    private List<Caja> cajas;
    private int idCliente = 0;
    private int clientesProcesados = 0;
    private static final int MAX_CLIENTES = 50;
    private static final int MAX_CLIENTES_POR_CAJA = 5;
    private static final int MIN_CLIENTES_POR_CAJA = 2;

    public Supermercado(int numCajasIniciales) {
        cajas = new ArrayList<>();
        for (int i = 1; i <= numCajasIniciales; i++) {
            Caja caja = new Caja(i);
            cajas.add(caja);
            caja.start();
        }
    }


    public void agregarClienteACola(Cliente cliente) {
        Caja cajaSeleccionada = seleccionarCaja();
        
        if (cajaSeleccionada != null) {
            cajaSeleccionada.agregarCliente(cliente); 
        } else {
        
            abrirNuevaCaja();
            agregarClienteACola(cliente); 
        }
    }


    public Caja seleccionarCaja() {
        return cajas.stream()
                .filter(Caja::estaAbierta) 
                .min((c1, c2) -> Integer.compare(c1.getTamanoCola(), c2.getTamanoCola()))
                .orElse(null); 
    }

    public void ajustarCajas() {
        int totalClientes = cajas.stream().mapToInt(Caja::getTamanoCola).sum();
        int numCajasAbiertas = (int) cajas.stream().filter(Caja::estaAbierta).count();
        int promedioClientesPorCaja = (numCajasAbiertas == 0) ? 0 : totalClientes / numCajasAbiertas;

      
        if (promedioClientesPorCaja > MAX_CLIENTES_POR_CAJA) {
            abrirNuevaCaja();
        }

        if (promedioClientesPorCaja < MIN_CLIENTES_POR_CAJA && numCajasAbiertas > 1) {
            cerrarCaja();
        }
    }

    private void abrirNuevaCaja() {
        int nuevoId = cajas.size() + 1; 
        Caja nuevaCaja = new Caja(nuevoId);
        cajas.add(nuevaCaja);
        nuevaCaja.start(); 
        System.out.println("Se ha abierto la caja " + nuevoId);
    }

    private void cerrarCaja() {
        Caja cajaCerrada = cajas.stream()
                .filter(c -> c.getTamanoCola() == 0 && c.estaAbierta())
                .findFirst()
                .orElse(null);

        if (cajaCerrada != null) {
            cajaCerrada.cerrarCaja();
            System.out.println("Se ha cerrado la caja " + cajaCerrada.getId());
        }
    }

    public void generarClientes() {
        new Thread(() -> {
            Random random = new Random();
            while (clientesProcesados < MAX_CLIENTES) {
                Cliente cliente = new Cliente(++idCliente, this);
                cliente.start(); 
                clientesProcesados++; 

                try {
                    Thread.sleep(random.nextInt(1000) + 500); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                ajustarCajas(); 
            }
            System.out.println("Se han procesado 50 clientes. Terminando la simulación.");
            cerrarTodasLasCajas();
        }).start();
    }


    private void cerrarTodasLasCajas() {
        for (Caja caja : cajas) {
            caja.cerrarCaja();
        }
        System.out.println("Todas las cajas han sido cerradas.");
    }
}
