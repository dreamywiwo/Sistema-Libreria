/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tune.sistemabibliotecanegocio.implementaciones;

import java.util.logging.Level;
import java.util.logging.Logger;
import tune.sistemabibliotecadominio.entidades.Usuario;
import tune.sistemabibliotecadominio.dtos.NuevoUsuarioDTO;
import tune.sistemabibliotecadominio.utils.SeguridadUtil;
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
    private Usuario usuarioActual;

    public UsuariosBO(IUsuariosDAO usuariosDAO) {
        this.usuariosDAO = usuariosDAO;
    }

    @Override
    public Usuario iniciarSesion(NuevoUsuarioDTO usuarioDTO) throws NegocioException {
        try {
            if (usuarioDTO.getCorreo() == null || usuarioDTO.getContrasena() == null) {
                throw new NegocioException("Correo y contraseña son obligatorios.");
            }

            Usuario usuario = usuariosDAO.buscarPorCorreo(usuarioDTO.getCorreo());
            if (usuario == null) {
                throw new NegocioException("Usuario no encontrado.");
            }

            String contrasenaHasheada = SeguridadUtil.generarHash(usuarioDTO.getContrasena());
            if (!usuario.getContrasena().equals(contrasenaHasheada)) {
                throw new NegocioException("Credenciales incorrectas.");
            }

            this.usuarioActual = usuario;

            return usuario;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al iniciar sesión", ex);
        }
    }

    @Override
    public Usuario registrarUsuario(NuevoUsuarioDTO usuarioDTO) throws NegocioException {
        try {
            if (usuarioDTO.getCorreo() == null || usuarioDTO.getContrasena() == null || usuarioDTO.getNombreusuario() == null) {
                throw new NegocioException("Faltan datos obligatorios.");
            }

            Usuario existente = usuariosDAO.buscarPorCorreo(usuarioDTO.getCorreo());
            if (existente != null) {
                throw new NegocioException("El correo ya está registrado.");
            }

            String contrasenaHasheada = SeguridadUtil.generarHash(usuarioDTO.getContrasena());

            Usuario nuevo = new Usuario();
            nuevo.setCorreo(usuarioDTO.getCorreo());
            nuevo.setContrasena(contrasenaHasheada);
            nuevo.setNombreusuario(usuarioDTO.getNombreusuario());
            nuevo.setImagenPerfil(usuarioDTO.getImagenPerfil());

            return usuariosDAO.registrarUsuario(nuevo);

        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al registrar usuario", ex);
        }
    }

    public Usuario obtenerUsuarioActual() {
        return usuarioActual;
    }

    public void cerrarSesion() {
        usuarioActual = null;
    }
}
