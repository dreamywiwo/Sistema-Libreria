/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tune.sistemabibliotecadominio.dtos;

import org.bson.types.ObjectId;

public class CancionConArtistaDTO {
    private ObjectId id;
    private String nombreCancion;
    private String nombreArtista;
    private String nombreAlbum;
    private String duracion;
    private String urlImagenAlbum;
    private String generoMusical;

    public CancionConArtistaDTO() {
    }

    public CancionConArtistaDTO(String nombreCancion, String nombreArtista, String nombreAlbum, String duracion, String urlImagenAlbum) {
        this.nombreCancion = nombreCancion;
        this.nombreArtista = nombreArtista;
        this.nombreAlbum = nombreAlbum;
        this.duracion = duracion;
        this.urlImagenAlbum = urlImagenAlbum;
    }

    public CancionConArtistaDTO(ObjectId id, String nombreCancion, String nombreArtista, String nombreAlbum, String duracion, String urlImagenAlbum, String generoMusical) {
        this.id = id;
        this.nombreCancion = nombreCancion;
        this.nombreArtista = nombreArtista;
        this.nombreAlbum = nombreAlbum;
        this.duracion = duracion;
        this.urlImagenAlbum = urlImagenAlbum;
        this.generoMusical = generoMusical;
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

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    public String getNombreAlbum() {
        return nombreAlbum;
    }

    public void setNombreAlbum(String nombreAlbum) {
        this.nombreAlbum = nombreAlbum;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getUrlImagenAlbum() {
        return urlImagenAlbum;
    }

    public void setUrlImagenAlbum(String urlImagenAlbum) {
        this.urlImagenAlbum = urlImagenAlbum;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }
        

}