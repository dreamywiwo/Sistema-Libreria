/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tune.sistemabibliotecadominio.dtos;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Dana Chavez
 */
public class AlbumDTO {
     
    private String idAlbum;           
    private String nombreAlbum;       
    private LocalDate fechaLanzamiento;  
    private String generoMusical;     
    private String imagenPortada;     
    private String artistaId;         
    private List<String> canciones;   

    // Constructor sin ID
    public AlbumDTO(String nombreAlbum, LocalDate  fechaLanzamiento, String generoMusical, 
                    String imagenPortada, String artistaId, List<String> canciones) {
        this.nombreAlbum = nombreAlbum;
        this.fechaLanzamiento = fechaLanzamiento;
        this.generoMusical = generoMusical;
        this.imagenPortada = imagenPortada;
        this.artistaId = artistaId;
        this.canciones = canciones;
    }

    // Constructor con ID
    public AlbumDTO(String idAlbum, String nombreAlbum, LocalDate fechaLanzamiento, 
                    String generoMusical, String imagenPortada, String artistaId, 
                    List<String> canciones) {
        this.idAlbum = idAlbum;
        this.nombreAlbum = nombreAlbum;
        this.fechaLanzamiento = fechaLanzamiento;
        this.generoMusical = generoMusical;
        this.imagenPortada = imagenPortada;
        this.artistaId = artistaId;
        this.canciones = canciones;
    }

    // Getters y setters
    public String getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(String idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getNombreAlbum() {
        return nombreAlbum;
    }

    public void setNombreAlbum(String nombreAlbum) {
        this.nombreAlbum = nombreAlbum;
    }

    public LocalDate  getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(LocalDate  fechaLanzamiento) {
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

    public String getArtistaId() {
        return artistaId;
    }

    public void setArtistaId(String artistaId) {
        this.artistaId = artistaId;
    }

    public List<String> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<String> canciones) {
        this.canciones = canciones;
    }
    
}
