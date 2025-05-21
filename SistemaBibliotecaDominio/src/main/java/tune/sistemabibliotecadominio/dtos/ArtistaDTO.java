package tune.sistemabibliotecadominio.dtos;

import java.util.List;
import java.time.LocalDate;  

public class ArtistaDTO {
    
    private String idArtista;         
    private String nombreArtista;         
    private String imagen;                
    private String generoMusical;         
    private String tipo;                 
    private LocalDate fechaCreacion;  
    private List<IntegranteDTO> integrantes;  

    // Constructor sin el idArtista
    public ArtistaDTO(String nombreArtista, String imagen, String generoMusical, String tipo, LocalDate fechaCreacion, List<IntegranteDTO> integrantes) {
        this.nombreArtista = nombreArtista;
        this.imagen = imagen;
        this.generoMusical = generoMusical;
        this.tipo = tipo;
        this.fechaCreacion = fechaCreacion;
        this.integrantes = integrantes;
    }

    // Constructor con el idArtista
    public ArtistaDTO(String idArtista, String nombreArtista, String imagen, String generoMusical, String tipo, LocalDate fechaCreacion, List<IntegranteDTO> integrantes) {
        this.idArtista = idArtista;
        this.nombreArtista = nombreArtista;
        this.imagen = imagen;
        this.generoMusical = generoMusical;
        this.tipo = tipo;
        this.fechaCreacion = fechaCreacion;
        this.integrantes = integrantes;
    }

    public String getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(String idArtista) {
        this.idArtista = idArtista;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public List<IntegranteDTO> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(List<IntegranteDTO> integrantes) {
        this.integrantes = integrantes;
    }
}
