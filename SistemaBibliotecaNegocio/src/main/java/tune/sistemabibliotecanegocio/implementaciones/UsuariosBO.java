/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tune.sistemabibliotecanegocio.implementaciones;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

        String correo = usuarioDTO.getCorreo();
        String regexCorreo = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        Pattern pattern = Pattern.compile(regexCorreo);
        Matcher matcher = pattern.matcher(correo);
        if (!matcher.matches()) {
            throw new NegocioException("El formato del correo es inválido.");
        }

        Usuario usuario = usuariosDAO.buscarPorCorreo(correo);
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

    public Usuario registrarUsuario(NuevoUsuarioDTO usuarioDTO) throws NegocioException {
    try {
        if (usuarioDTO.getCorreo() == null || usuarioDTO.getContrasena() == null || usuarioDTO.getNombreusuario() == null) {
            throw new NegocioException("Faltan datos obligatorios.");
        }

        String correo = usuarioDTO.getCorreo();
        String regexCorreo = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        Pattern pattern = Pattern.compile(regexCorreo);
        Matcher matcher = pattern.matcher(correo);
        if (!matcher.matches()) {
            throw new NegocioException("El formato del correo es inválido.");
        }

        Usuario existente = usuariosDAO.buscarPorCorreo(correo);
        if (existente != null) {
            throw new NegocioException("El correo ya está registrado.");
        }

        String contrasenaHasheada = SeguridadUtil.generarHash(usuarioDTO.getContrasena());

        Usuario nuevo = new Usuario();
        nuevo.setCorreo(correo);
        nuevo.setContrasena(contrasenaHasheada);
        nuevo.setNombreusuario(usuarioDTO.getNombreusuario());
        nuevo.setImagenPerfil(usuarioDTO.getImagenPerfil());

        return usuariosDAO.registrarUsuario(nuevo);

    } catch (PersistenciaException ex) {
        throw new NegocioException("Error al registrar usuario", ex);
    }
}

    @Override
    public boolean verificarContraseñaActual(String contraseñaIngresada) throws NegocioException {
        if (usuarioActual == null) {
            throw new NegocioException("No hay un usuario autenticado.");
        }

        String contrasenaHasheada = SeguridadUtil.generarHash(contraseñaIngresada);
        return usuarioActual.getContrasena().equals(contrasenaHasheada);
    }

    @Override
    public Usuario editarUsuario(NuevoUsuarioDTO usuarioDTO) throws NegocioException {
        try {
            if (usuarioDTO.getNombreusuario() == null || usuarioDTO.getNombreusuario().trim().isEmpty()
                    || usuarioDTO.getCorreo() == null || usuarioDTO.getCorreo().trim().isEmpty()) {
                throw new NegocioException("El nombre de usuario y el correo no pueden estar vacíos.");
            }

            if (usuarioActual == null) {
                throw new NegocioException("No hay un usuario autenticado para editar.");
            }

            String nuevaContrasena = usuarioDTO.getContrasena();
            String hash = (nuevaContrasena != null && !nuevaContrasena.isBlank())
                    ? SeguridadUtil.generarHash(nuevaContrasena)
                    : usuarioActual.getContrasena();

            Usuario actualizado = new Usuario();
            actualizado.setId(usuarioActual.getId());
            actualizado.setNombreusuario(usuarioDTO.getNombreusuario());
            actualizado.setCorreo(usuarioDTO.getCorreo());
            actualizado.setImagenPerfil(usuarioDTO.getImagenPerfil());
            actualizado.setContrasena(hash);

            Usuario resultado = usuariosDAO.editarUsuario(actualizado);
            this.usuarioActual = resultado;
            return resultado;

        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al editar usuario", ex);
        }
    }

    @Override
    public Usuario obtenerUsuarioActual() {
        return usuarioActual;
    }

    @Override
    public void cerrarSesion() {
        usuarioActual = null;
    }
}
