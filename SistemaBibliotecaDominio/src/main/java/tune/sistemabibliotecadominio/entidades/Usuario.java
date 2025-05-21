
package tune.sistemabibliotecadominio.entidades;

import org.bson.types.ObjectId;

import java.util.List;

public class Usuario {
    private ObjectId id;
    private String nombreUsuario;
    private String correo;
    private String contrasena;
    private String imagenPerfil;
    private List<String> generosNoDeseados;
    private List<ObjectId> favoritosArtistas; // Referencias a artistas
    private List<ObjectId> favoritosAlbumes;  // Referencias a álbumes
    private List<ObjectId> favoritosCanciones; // Referencias a canciones

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getImagenPerfil() {
        return imagenPerfil;
    }

    public void setImagenPerfil(String imagenPerfil) {
        this.imagenPerfil = imagenPerfil;
    }

    public List<String> getGenerosNoDeseados() {
        return generosNoDeseados;
    }

    public void setGenerosNoDeseados(List<String> generosNoDeseados) {
        this.generosNoDeseados = generosNoDeseados;
    }

    public List<ObjectId> getFavoritosArtistas() {
        return favoritosArtistas;
    }

    public void setFavoritosArtistas(List<ObjectId> favoritosArtistas) {
        this.favoritosArtistas = favoritosArtistas;
    }

    public List<ObjectId> getFavoritosAlbumes() {
        return favoritosAlbumes;
    }

    public void setFavoritosAlbumes(List<ObjectId> favoritosAlbumes) {
        this.favoritosAlbumes = favoritosAlbumes;
    }

    public List<ObjectId> getFavoritosCanciones() {
        return favoritosCanciones;
    }

    public void setFavoritosCanciones(List<ObjectId> favoritosCanciones) {
        this.favoritosCanciones = favoritosCanciones;
    }
}


