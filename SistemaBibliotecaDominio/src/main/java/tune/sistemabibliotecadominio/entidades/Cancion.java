/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tune.sistemabibliotecadominio.entidades;

import org.bson.types.ObjectId;

public class Cancion {
    private ObjectId id;
    private String nombre;
    private String duracion;
    private ObjectId albumId; // Referencia al álbum
    private ObjectId artistaId; // Referencia al artista
    private String generoMusical;

    public Cancion() {
    }

    public Cancion(ObjectId id, String nombre, String duracion, ObjectId albumId, ObjectId artistaId, String generoMusical) {
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
        this.albumId = albumId;
        this.artistaId = artistaId;
        this.generoMusical = generoMusical;
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

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public ObjectId getAlbumId() {
        return albumId;
    }

    public void setAlbumId(ObjectId albumId) {
        this.albumId = albumId;
    }

    public ObjectId getArtistaId() {
        return artistaId;
    }

    public void setArtistaId(ObjectId artistaId) {
        this.artistaId = artistaId;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }
}
