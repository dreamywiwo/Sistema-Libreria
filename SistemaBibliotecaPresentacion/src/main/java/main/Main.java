/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import tune.sistemabibliotecapresentacion.VentanaRegistro;
import tune.sistemabibliotecapresentacion.control.ControlNavegacion;

/**
 *
 * @author Dana Chavez
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ControlNavegacion control = new ControlNavegacion();
        VentanaRegistro ventanaRegistro = new VentanaRegistro(control);
        ventanaRegistro.mostrar();
    }
    
}
