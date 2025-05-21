/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tune.sistemabibliotecanegocio.interfaces;

import tune.sistemabibliotecadominio.entidades.Usuario;
import tune.sistemabibliotecadominio.entidades.dtos.NuevoUsuarioDTO;
import tune.sistemabibliotecanegocio.exception.NegocioException;

/**
 *
 * @author leoca
 */
public interface IUsuariosBO {
    
    public Usuario iniciarSesion(NuevoUsuarioDTO dto) throws NegocioException;
    Usuario registrarUsuario(NuevoUsuarioDTO usuarioDTO)throws NegocioException;
}
