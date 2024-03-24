/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mlyexamenex2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author yago.martinezloureda
 */
public class yagofc {
    public static void main(String[] args) {
        ArrayList<Jugador> j = new ArrayList<>();
        Scanner t = new Scanner (System.in);
        int i = 0, op = 0;
        
        Jugador jJ = null;
        
        do {
            System.out.println("------------------");
            System.out.println("1. Mostrar los jugadores");
            System.out.println("2. Mostrar jugadores ofensivos");
            System.out.println("3. Utilizar un jugador ofensivo");
            System.out.println("4. Utilizar un jugador defensivo");
            System.out.println("5. Jugar");
            System.out.println("6. Entrenar");
            System.out.println("7. Entrenar todos los jugadores");
            System.out.println("8. Fichar jugadores");
            System.out.println("9. Jugar partido");
            System.out.println("10. Salir");
            System.out.println("Opción escogida: ");
            i = Integer.parseInt(t.nextLine());
            System.out.println("-----------------");
            
            if (i == 1) {
                if (j.isEmpty()) {
                    System.out.println("La lista está vacía");
                }
                for (Jugador jugador : j) {
                     System.out.println("Nombre: " + jugador.getNombre() + " Edad: " + jugador.getfNacimiento() + " Coste: " + jugador.getCoste());
                }
            }
            
            if (i == 2) {
                 for (Jugador jugador : j) {
                      if (jugador instanceof Delanteros) {
                           System.out.println("Nombre: " + jugador.nombre + "Goles: " + ((Delanteros) jugador).goles);
                      }
                      if (jugador instanceof Extremos) {
                           System.out.println("Nombre: " + jugador.nombre + "Goles: " + ((Extremos) jugador).asistencias);
                      }
                 }
            }
            
               
            if (i == 3) {
                System.out.println("Introduzca el nombre del jugador ofensivo que quiere buscar: ");
                String s = t.nextLine();
                 for (Jugador jugador : j) {
                     if (jugador.nombre.equalsIgnoreCase(s)) {
                        if (jugador instanceof Delanteros) {
                           ((Delanteros) jugador).atacar();
                      }
                         if (jugador instanceof Extremos) {
                           ((Extremos) jugador).atacar();
                      }
                        break;
                     }
                 }
            }
            
            if (i == 4) {
                System.out.println("Introduzca el nombre del jugador defensivo que quiere buscar: ");
                String s = t.nextLine();
                 for (Jugador jugador : j) {
                     if (jugador.nombre.equalsIgnoreCase(s)) {
                        ((Defensivos) jugador).defender();
                        break;
                     }
                 }
            }
            
            if (i == 5) {
                for (Jugador jugador : j) {
                    if (jugador instanceof Delanteros) {
                           ((Delanteros) jugador).atacar();
                    }
                        if (jugador instanceof Extremos) {
                           ((Extremos) jugador).atacar();
                    }
                         
                    if (jugador instanceof Defensivos) {
                           ((Defensivos) jugador).defender();
                    }
                 }
            }
            
             if (i == 6) {
                System.out.println("Introduzca el nombre del jugador que quiere entrenar: ");
                String s = t.nextLine();
                 for (Jugador jugador : j) {
                     if (jugador.nombre.equalsIgnoreCase(s)) {
                        if (jugador instanceof Delanteros) {
                           ((Delanteros) jugador).entrenar();
                      }
                        if (jugador instanceof Extremos) {
                           ((Extremos) jugador).entrenar();
                      }
                         
                        if (jugador instanceof Defensivos) {
                           ((Defensivos) jugador).entrenar();
                      }
                        break;
                     }
                 }
            }
             
            if (i == 7) {
                for (Jugador jugador : j) {
                    if (jugador instanceof Delanteros) {
                           ((Delanteros) jugador).entrenar();
                    }
                    if (jugador instanceof Extremos) {
                           ((Extremos) jugador).entrenar();
                    }
                         
                    if (jugador instanceof Defensivos) {
                           ((Defensivos) jugador).entrenar();
                    }
                }
            }
            
            if (i == 8) {
                System.out.println("1. Fichar delantero");
                System.out.println("2. Fichar extremo");
                System.out.println("3. Fichar defensor");
                System.out.println("Opción escogida: ");
                op = Integer.parseInt(t.nextLine());
                
                System.out.println("------------------");
                
                if (op == 1) {
                    System.out.println("Introduzca su nombre:");
                    String s = t.nextLine();
                    
                    jJ = new Delanteros (s);
                    j.add(jJ);
                }
                 if (op == 2) {
                    System.out.println("Introduzca su nombre:");
                    String s = t.nextLine();
                    
                    jJ = new Extremos (s);
                    j.add(jJ);
                }
                  if (op == 3) {
                    System.out.println("Introduzca su nombre:");
                    String s = t.nextLine();
                    
                    jJ = new Defensivos (s);
                    j.add(jJ);
                }
            }
            
               if (i == 9) {
                if (j.size() < 11) {
                    System.out.println("No hay suficientes jugadores");
                } else {
                    /**
                    *
                    * No me dio tiempo a implementar la función
                    */
                }
            }
        } while (i != 10);
 
    }
}
