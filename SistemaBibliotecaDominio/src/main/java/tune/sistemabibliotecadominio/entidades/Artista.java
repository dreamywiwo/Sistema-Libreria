/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tune.sistemabibliotecadominio.entidades;

import org.bson.types.ObjectId;

import java.util.List;

public class Artista {
    private ObjectId id;
    private String tipo;  // "solista" o "banda"
    private String nombre;
    private String imagen;
    private String generoMusical;

    // Si es una banda, esta lista contendrá los integrantes
    private List<Integrante> integrantes;

    // Si el artista es un solista, esta lista será null o vacía
    private List<ObjectId> albums; // Referencias a los álbumes de la banda o solista

    // Getters y setters
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    public List<Integrante> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(List<Integrante> integrantes) {
        this.integrantes = integrantes;
    }

    public List<ObjectId> getAlbums() {
        return albums;
    }

    public void setAlbums(List<ObjectId> albums) {
        this.albums = albums;
    }
}
