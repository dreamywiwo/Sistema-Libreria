
package tune.sistemabibliotecadominio.dtos;

public class CancionDTO {
    private String id;
    private String nombre;
    private String duracion;
    private String albumId; 
    private String artistaId; 
    private String generoMusical;

    public CancionDTO() {
    }

    public CancionDTO(String id, String nombre, String duracion, String albumId, String artistaId, String generoMusical) {
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
        this.albumId = albumId;
        this.artistaId = artistaId;
        this.generoMusical = generoMusical;
    }

    public CancionDTO(String nombre, String duracion, String albumId, String artistaId, String generoMusical) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.albumId = albumId;
        this.artistaId = artistaId;
        this.generoMusical = generoMusical;
    }

    public CancionDTO(String nombre, String duracion, String generoMusical) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.generoMusical = generoMusical;
    }   
   
    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getArtistaId() {
        return artistaId;
    }

    public void setArtistaId(String artistaId) {
        this.artistaId = artistaId;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }
}

