/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tune.sistemabibliotecapresentacion.control;

import tune.sistemabibliotecapresentacion.VentanaPrincipal;
import tune.sistemabibliotecapresentacion.VentanaRegistro;

public class ControlNavegacion {
    
    public void mostrarVentanaPrincipal() {
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
        ventanaPrincipal.mostrar();
    }
    
    public void mostrarVentanaRegistro(){
        VentanaRegistro ventanaRegistro = new VentanaRegistro(this);
        ventanaRegistro.mostrar();
    }
    
}
