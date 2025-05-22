/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tune.sistemabibliotecapersistencia.interfaces;

import org.bson.types.ObjectId;
import java.util.List;
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
    
    public abstract void agregarArtistaFavorito(ObjectId usuarioId, ObjectId artistaId) throws PersistenciaException;
    
    public abstract void eliminarArtistaFavorito(ObjectId usuarioId, ObjectId artistaId) throws PersistenciaException;
    
    public void agregarAlbumFavorito(ObjectId usuarioId, ObjectId albumId) throws PersistenciaException;
    
    public void eliminarAlbumFavorito(ObjectId usuarioId, ObjectId albumId) throws PersistenciaException;
    
    public void agregarCancionFavorito(ObjectId usuarioId, ObjectId cancionId) throws PersistenciaException;
    
    public void eliminarCancionFavorito(ObjectId usuarioId, ObjectId cancionId) throws PersistenciaException;
    
    public void actualizarGenerosRestringidosPorId(Object id, List<String> generosRestringidos) throws PersistenciaException;

}
