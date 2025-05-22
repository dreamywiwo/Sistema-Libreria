/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tune.sistemabibliotecadominio.dtos;

import java.time.LocalDate;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Dana Chavez
 */
public class AlbumDetalleDTO {
    private ObjectId idAlbum;
    private String nombreAlbum;
    private String urlImagenAlbum;
    private String nombreArtista;
    private String generoMusical;             
    private LocalDate fechaLanzamiento;          
    private List<CancionConArtistaDTO> canciones;

    public AlbumDetalleDTO() {
    }   

    public AlbumDetalleDTO(ObjectId idAlbum, String nombreAlbum, String urlImagenAlbum, String nombreArtista, String generoMusical, LocalDate fechaLanzamiento, List<CancionConArtistaDTO> canciones) {
        this.idAlbum = idAlbum;
        this.nombreAlbum = nombreAlbum;
        this.urlImagenAlbum = urlImagenAlbum;
        this.nombreArtista = nombreArtista;
        this.generoMusical = generoMusical;
        this.fechaLanzamiento = fechaLanzamiento;
        this.canciones = canciones;
    }

    public ObjectId getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(ObjectId idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getNombreAlbum() {
        return nombreAlbum;
    }

    public void setNombreAlbum(String nombreAlbum) {
        this.nombreAlbum = nombreAlbum;
    }

    public String getUrlImagenAlbum() {
        return urlImagenAlbum;
    }

    public void setUrlImagenAlbum(String urlImagenAlbum) {
        this.urlImagenAlbum = urlImagenAlbum;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public List<CancionConArtistaDTO> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<CancionConArtistaDTO> canciones) {
        this.canciones = canciones;
    }
    
    
}
