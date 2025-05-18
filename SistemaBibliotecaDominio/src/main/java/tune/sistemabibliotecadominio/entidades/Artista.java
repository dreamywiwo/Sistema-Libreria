/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tune.sistemabibliotecadominio.entidades;

import java.util.List;

/**
 *
 * @author Dana Chavez
 */
public class Artista {
    //private ObjectId id;
    private String nombre;
    private String imagen;
    private String genero;
    private String tipo;  

    private List<Integrante> integrantes;



    public static class Integrante {
        private String nombre;
        private String rol;
        private String fechaIngreso;
        private String fechaSalida;
        private boolean activo;
    }
    
}
