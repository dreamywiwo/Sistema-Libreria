/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tune.sistemabibliotecanegocio.implementaciones;

import java.util.logging.Level;
import java.util.logging.Logger;
import tune.sistemabibliotecadominio.entidades.Usuario;
import tune.sistemabibliotecadominio.entidades.dtos.NuevoUsuarioDTO;
import tune.sistemabibliotecanegocio.exception.NegocioException;
import tune.sistemabibliotecanegocio.interfaces.IUsuariosBO;
import tune.sistemabibliotecapersistencia.exception.PersistenciaException;
import tune.sistemabibliotecapersistencia.interfaces.IUsuariosDAO;

/**
 *
 * @author leoca
 */
public class UsuariosBO implements IUsuariosBO {

    private final IUsuariosDAO usuariosDAO;

    public UsuariosBO(IUsuariosDAO usuariosDAO) {
        this.usuariosDAO = usuariosDAO;
    }

    @Override
    public Usuario iniciarSesion(NuevoUsuarioDTO usuarioDTO) throws NegocioException {
        if (usuarioDTO.getCorreo() == null || usuarioDTO.getContrasena() == null) {
            throw new NegocioException("Correo y contraseña son obligatorios.");
        }

        try {
            Usuario usuario = usuariosDAO.iniciarSesion(usuarioDTO.getCorreo(), usuarioDTO.getContrasena());

            if (usuario == null) {
                throw new NegocioException("Credenciales incorrectas.");
            }

            return usuario;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al iniciar sesión: " + e.getMessage(), e);
        }
    }

    @Override
    public Usuario registrarUsuario(NuevoUsuarioDTO usuarioDTO) throws NegocioException {
        if (usuarioDTO.getCorreo() == null || usuarioDTO.getContrasena() == null || usuarioDTO.getNombreusuario() == null) {
            throw new NegocioException("Faltan datos obligatorios.");
        }

        try {
            Usuario existente = usuariosDAO.buscarPorCorreo(usuarioDTO.getCorreo());
            if (existente != null) {
                throw new NegocioException("El correo ya está registrado.");
            }

            Usuario nuevo = new Usuario();
            nuevo.setCorreo(usuarioDTO.getCorreo());
            nuevo.setContrasena(usuarioDTO.getContrasena());
            nuevo.setNombreusuario(usuarioDTO.getNombreusuario());
            nuevo.setImagenPerfil(usuarioDTO.getImagenPerfil());

            return usuariosDAO.registrarUsuario(nuevo);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al registrar usuario: " + e.getMessage(), e);
        }
    }
}
