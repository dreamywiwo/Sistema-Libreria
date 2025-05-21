/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tune.sistemabibliotecadominio.dtos;

import org.bson.types.ObjectId;

public class CancionConArtistaDTO {
    private ObjectId id;
    private String nombreCancion;
    private String duracion;
    private ObjectId albumId;
    private String generoMusical;
    private String nombreArtista;

    public CancionConArtistaDTO() {}

    public CancionConArtistaDTO(ObjectId id, String nombreCancion, String duracion, ObjectId albumId, String generoMusical, String nombreArtista) {
        this.id = id;
        this.nombreCancion = nombreCancion;
        this.duracion = duracion;
        this.albumId = albumId;
        this.generoMusical = generoMusical;
        this.nombreArtista = nombreArtista;
    }

    public CancionConArtistaDTO(String nombreCancion, String nombreArtista) {
        this.nombreCancion = nombreCancion;
        this.nombreArtista = nombreArtista;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
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

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }
}