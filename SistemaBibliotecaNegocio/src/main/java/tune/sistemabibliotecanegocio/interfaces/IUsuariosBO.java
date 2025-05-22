/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tune.sistemabibliotecanegocio.interfaces;

import org.bson.types.ObjectId;
import tune.sistemabibliotecadominio.entidades.Usuario;
import tune.sistemabibliotecadominio.dtos.NuevoUsuarioDTO;
import tune.sistemabibliotecanegocio.exception.NegocioException;

public interface IUsuariosBO {
    
    public Usuario iniciarSesion(NuevoUsuarioDTO dto) throws NegocioException;
    Usuario registrarUsuario(NuevoUsuarioDTO usuarioDTO)throws NegocioException;
    public boolean verificarContraseñaActual(String contraseñaIngresada) throws NegocioException;
    public Usuario editarUsuario(NuevoUsuarioDTO usuarioDTO) throws NegocioException;
    public Usuario obtenerUsuarioActual();
    public void cerrarSesion();
    
    public abstract void agregarArtistaFavorito(ObjectId usuarioId, ObjectId artistaId) throws NegocioException;
    
    public abstract void eliminarArtistaFavorito(ObjectId usuarioId, ObjectId artistaId) throws NegocioException;
    
    public void agregarAlbumFavorito(ObjectId usuarioId, ObjectId albumId) throws NegocioException;
    
    public void eliminarAlbumFavorito(ObjectId usuarioId, ObjectId albumId) throws NegocioException;
    
    public void agregarCancionFavorito(ObjectId usuarioId, ObjectId cancionId) throws NegocioException;
    
    public void eliminarCancionFavorito(ObjectId usuarioId, ObjectId cancionId) throws NegocioException;


}
