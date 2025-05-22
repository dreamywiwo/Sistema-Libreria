/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tune.sistemabibliotecapersistencia.interfaces;

import tune.sistemabibliotecadominio.entidades.Usuario;
import tune.sistemabibliotecapersistencia.exception.PersistenciaException;

/**
 *
 * @author leoca
 */
public interface IUsuariosDAO {

    public Usuario iniciarSesion(String correo, String contrasena) throws PersistenciaException;

    Usuario registrarUsuario(Usuario usuario)throws PersistenciaException;

    Usuario buscarPorCorreo(String correo)throws PersistenciaException;
    
    public Usuario editarUsuario(Usuario usuario) throws PersistenciaException;

}
