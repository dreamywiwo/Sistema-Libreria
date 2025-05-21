/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tune.sistemabibliotecadominio.dtos;

/**
 *
 * @author leoca
 */
public class NuevoUsuarioDTO {

    private String nombreusuario;
    private String correo;
    private String contrasena;
    private String imagenPerfil;

    public NuevoUsuarioDTO() {}

    public NuevoUsuarioDTO(String nombreusuario, String correo, String contrasena, String imagenPerfil) {
        this.nombreusuario = nombreusuario;
        this.correo = correo;
        this.contrasena = contrasena;
        this.imagenPerfil = imagenPerfil;
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

    @Override
    public String toString() {
        return "NuevoUsuarioDTO{" +
                "nombreusuario='" + nombreusuario + '\'' +
                ", correo='" + correo + '\'' +
                ", imagenPerfil='" + imagenPerfil + '\'' +
                '}';
    }
}
