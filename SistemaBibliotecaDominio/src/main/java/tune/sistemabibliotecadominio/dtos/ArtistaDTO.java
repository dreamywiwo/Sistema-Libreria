package tune.sistemabibliotecadominio.dtos;

import java.util.List;

public class ArtistaDTO {
    private String id;
    private String tipo; 
    private String nombre;
    private String imagen;
    private String generoMusical;
    private List<IntegranteDTO> integrantes;

    public ArtistaDTO() {
    }

    public ArtistaDTO(String id, String tipo, String nombre, String imagen, String generoMusical, List<IntegranteDTO> integrantes) {
        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.imagen = imagen;
        this.generoMusical = generoMusical;
        this.integrantes = integrantes;
    }

    public ArtistaDTO(String tipo, String nombre, String imagen, String generoMusical, List<IntegranteDTO> integrantes) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.imagen = imagen;
        this.generoMusical = generoMusical;
        this.integrantes = integrantes;
    }

    public ArtistaDTO(String nombre, String tipo, String generoMusical, String imagen) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.generoMusical = generoMusical;
        this.imagen = imagen;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public List<IntegranteDTO> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(List<IntegranteDTO> integrantes) {
        this.integrantes = integrantes;
    }
}

