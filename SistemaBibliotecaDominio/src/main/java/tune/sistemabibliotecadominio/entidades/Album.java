/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tune.sistemabibliotecadominio.entidades;

import org.bson.types.ObjectId;

import java.util.List;

public class Album {
    private ObjectId id;
    private String nombre;
    private String fechaLanzamiento;
    private String generoMusical;
    private String imagenPortada;
    private List<ObjectId> canciones; // Referencias a canciones
    private ObjectId artistaId; // Referencia al artista

    public Album() {
    }

    public Album(ObjectId id, String nombre, String fechaLanzamiento, String generoMusical, String imagenPortada, List<ObjectId> canciones, ObjectId artistaId) {
        this.id = id;
        this.nombre = nombre;
        this.fechaLanzamiento = fechaLanzamiento;
        this.generoMusical = generoMusical;
        this.imagenPortada = imagenPortada;
        this.canciones = canciones;
        this.artistaId = artistaId;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(String fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    public String getImagenPortada() {
        return imagenPortada;
    }

    public void setImagenPortada(String imagenPortada) {
        this.imagenPortada = imagenPortada;
    }

    public List<ObjectId> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<ObjectId> canciones) {
        this.canciones = canciones;
    }

    public ObjectId getArtistaId() {
        return artistaId;
    }

    public void setArtistaId(ObjectId artistaId) {
        this.artistaId = artistaId;
    }
}
