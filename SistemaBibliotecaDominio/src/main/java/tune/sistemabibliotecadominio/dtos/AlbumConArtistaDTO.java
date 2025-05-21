/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tune.sistemabibliotecadominio.dtos;

import org.bson.types.ObjectId;

public class AlbumConArtistaDTO {
    private ObjectId idAlbum;
    private String nombreAlbum;
    private String urlImagenAlbum;
    private String nombreArtista;

    public AlbumConArtistaDTO(ObjectId idAlbum, String nombreAlbum, String urlImagenAlbum, String nombreArtista) {
        this.idAlbum = idAlbum;
        this.nombreAlbum = nombreAlbum;
        this.urlImagenAlbum = urlImagenAlbum;
        this.nombreArtista = nombreArtista;
    }

    public ObjectId getIdAlbum() {
        return idAlbum;
    }

    public String getNombreAlbum() {
        return nombreAlbum;
    }

    public String getUrlImagenAlbum() {
        return urlImagenAlbum;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }
}
