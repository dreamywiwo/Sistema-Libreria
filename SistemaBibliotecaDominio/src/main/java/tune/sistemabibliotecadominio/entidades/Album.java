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
public class Album {
    //private ObjectId id;
    private String nombre;
    private String fechaLanzamiento;
    private String genero;
    private String imagen;
    //private ObjectId artistaId;
    private List<Cancion> canciones;

    public static class Cancion {
        private String nombre;
        private String duracion;
        private int numeroPista;

    }
    
}
