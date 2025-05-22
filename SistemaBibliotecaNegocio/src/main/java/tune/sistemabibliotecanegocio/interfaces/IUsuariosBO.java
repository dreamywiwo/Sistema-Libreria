/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tune.sistemabibliotecanegocio.interfaces;

import java.util.List;
import tune.sistemabibliotecadominio.entidades.Usuario;
import tune.sistemabibliotecadominio.dtos.NuevoUsuarioDTO;
import tune.sistemabibliotecanegocio.exception.NegocioException;

/**
 *
 * @author leoca
 */
public interface IUsuariosBO {
    
    public Usuario iniciarSesion(NuevoUsuarioDTO dto) throws NegocioException;
    Usuario registrarUsuario(NuevoUsuarioDTO usuarioDTO)throws NegocioException;
    public boolean verificarContraseñaActual(String contraseñaIngresada) throws NegocioException;
    public Usuario editarUsuario(NuevoUsuarioDTO usuarioDTO) throws NegocioException;
    public void actualizarGenerosRestringidos(List<String> generosRestringidos) throws NegocioException;
    public Usuario obtenerUsuarioActual();
    public void cerrarSesion();
}
