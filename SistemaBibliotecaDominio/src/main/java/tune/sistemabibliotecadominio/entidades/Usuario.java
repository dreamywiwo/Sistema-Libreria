/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tune.sistemabibliotecadominio.entidades;

import org.bson.types.ObjectId;

import java.util.List;

public class Usuario {

    private ObjectId id;

    private String nombreusuario;
    private String correo;
    private String contrasena;
    private String imagenPerfil;

    private List<ObjectId> favoritos;
    private List<ObjectId> artistas;
    private List<ObjectId> albumes;
    private List<ObjectId> canciones;
    private List<String> generosRestringidos;

    public Usuario() {}

    public Usuario(ObjectId id, String nombreusuario, String correo, String contrasena, String imagenPerfil,
                   List<ObjectId> favoritos, List<ObjectId> artistas, List<ObjectId> albumes,
                   List<ObjectId> canciones, List<String> generosRestringidos) {
        this.id = id;
        this.nombreusuario = nombreusuario;
        this.correo = correo;
        this.contrasena = contrasena;
        this.imagenPerfil = imagenPerfil;
        this.favoritos = favoritos;
        this.artistas = artistas;
        this.albumes = albumes;
        this.canciones = canciones;
        this.generosRestringidos = generosRestringidos;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
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

    public List<ObjectId> getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(List<ObjectId> favoritos) {
        this.favoritos = favoritos;
    }

    public List<ObjectId> getArtistas() {
        return artistas;
    }

    public void setArtistas(List<ObjectId> artistas) {
        this.artistas = artistas;
    }

    public List<ObjectId> getAlbumes() {
        return albumes;
    }

    public void setAlbumes(List<ObjectId> albumes) {
        this.albumes = albumes;
    }

    public List<ObjectId> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<ObjectId> canciones) {
        this.canciones = canciones;
    }

    public List<String> getGenerosRestringidos() {
        return generosRestringidos;
    }

    public void setGenerosRestringidos(List<String> generosRestringidos) {
        this.generosRestringidos = generosRestringidos;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombreusuario='" + nombreusuario + '\'' +
                ", correo='" + correo + '\'' +
                ", imagenPerfil='" + imagenPerfil + '\'' +
                '}';
    }
}
