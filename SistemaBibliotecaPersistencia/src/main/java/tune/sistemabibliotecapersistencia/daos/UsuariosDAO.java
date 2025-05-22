/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tune.sistemabibliotecapersistencia.daos;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;
import tune.sistemabibliotecadominio.entidades.Usuario;
import tune.sistemabibliotecapersistencia.conexion.ManejadorConexiones;
import tune.sistemabibliotecapersistencia.exception.PersistenciaException;
import tune.sistemabibliotecapersistencia.interfaces.IUsuariosDAO;

/**
 *
 * @author leoca
 */
public class UsuariosDAO implements IUsuariosDAO {

    @Override
    public Usuario iniciarSesion(String correo, String contrasena) throws PersistenciaException {
        MongoDatabase db = ManejadorConexiones.obtenerBaseDatos();
        MongoCollection<Usuario> coleccion = db.getCollection("usuarios", Usuario.class);

        Document filtro = new Document();
        filtro.append("correo", correo);
        filtro.append("contrasena", contrasena);

        FindIterable<Usuario> resultado = coleccion.find(filtro);
        Usuario usuarioEncontrado = resultado.first();

        return usuarioEncontrado;
    }

    @Override
    public Usuario registrarUsuario(Usuario usuario) throws PersistenciaException {
        MongoDatabase db = ManejadorConexiones.obtenerBaseDatos();
        MongoCollection<Usuario> coleccion = db.getCollection("usuarios", Usuario.class);
        coleccion.insertOne(usuario);
        return usuario;
    }

    @Override
    public Usuario buscarPorCorreo(String correo) throws PersistenciaException {
        MongoDatabase db = ManejadorConexiones.obtenerBaseDatos();
        MongoCollection<Usuario> coleccion = db.getCollection("usuarios", Usuario.class);

        Document filtro = new Document("correo", correo);
        return coleccion.find(filtro).first();
    }

    @Override
    public Usuario editarUsuario(Usuario usuario) throws PersistenciaException {
        try {
            MongoDatabase db = ManejadorConexiones.obtenerBaseDatos();
            MongoCollection<Usuario> coleccion = db.getCollection("usuarios", Usuario.class);

            Document filtro = new Document("_id", usuario.getId());
            Document actualizacion = new Document("$set", new Document()
                    .append("nombreusuario", usuario.getNombreusuario())
                    .append("correo", usuario.getCorreo())
                    .append("imagenPerfil", usuario.getImagenPerfil())
                    .append("contrasena", usuario.getContrasena())
            );

            coleccion.updateOne(filtro, actualizacion);
            return usuario;

        } catch (Exception e) {
            throw new PersistenciaException("Error al editar el usuario", e);
        }
    }
    
    @Override
    public void agregarArtistaFavorito(ObjectId usuarioId, ObjectId artistaId) throws PersistenciaException {
        try {
            MongoDatabase db = ManejadorConexiones.obtenerBaseDatos();
            MongoCollection<Usuario> coleccion = db.getCollection("usuarios", Usuario.class);

            UpdateResult result = coleccion.updateOne(
                Filters.eq("_id", usuarioId),
                Updates.addToSet("artistas", artistaId) 
            );

            if (result.getMatchedCount() == 0) {
                throw new PersistenciaException("Usuario no encontrado para agregar favorito");
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al agregar artista favorito", e);
        }
    }
    
    @Override
    public void eliminarArtistaFavorito(ObjectId usuarioId, ObjectId artistaId) throws PersistenciaException {
        try {
            MongoDatabase db = ManejadorConexiones.obtenerBaseDatos();
            MongoCollection<Usuario> coleccion = db.getCollection("usuarios", Usuario.class);

            UpdateResult result = coleccion.updateOne(
                Filters.eq("_id", usuarioId),
                Updates.pull("artistas", artistaId)
            );

            if (result.getMatchedCount() == 0) {
                throw new PersistenciaException("Usuario no encontrado para eliminar favorito");
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al eliminar artista favorito", e);
        }
    }
    
    @Override
    public void agregarAlbumFavorito(ObjectId usuarioId, ObjectId albumId) throws PersistenciaException {
        try {
            MongoDatabase db = ManejadorConexiones.obtenerBaseDatos();
            MongoCollection<Usuario> coleccion = db.getCollection("usuarios", Usuario.class);

            UpdateResult result = coleccion.updateOne(
                Filters.eq("_id", usuarioId),
                Updates.addToSet("albumes", albumId)
            );

            if (result.getMatchedCount() == 0) {
                throw new PersistenciaException("Usuario no encontrado para agregar álbum favorito");
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al agregar álbum favorito", e);
        }
    }

    @Override
    public void eliminarAlbumFavorito(ObjectId usuarioId, ObjectId albumId) throws PersistenciaException {
        try {
            MongoDatabase db = ManejadorConexiones.obtenerBaseDatos();
            MongoCollection<Usuario> coleccion = db.getCollection("usuarios", Usuario.class);

            UpdateResult result = coleccion.updateOne(
                Filters.eq("_id", usuarioId),
                Updates.pull("albumes", albumId)
            );

            if (result.getMatchedCount() == 0) {
                throw new PersistenciaException("Usuario no encontrado para eliminar álbum favorito");
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al eliminar álbum favorito", e);
        }
    }

    @Override
    public void agregarCancionFavorito(ObjectId usuarioId, ObjectId cancionId) throws PersistenciaException {
        try {
            MongoDatabase db = ManejadorConexiones.obtenerBaseDatos();
            MongoCollection<Usuario> coleccion = db.getCollection("usuarios", Usuario.class);

            UpdateResult result = coleccion.updateOne(
                Filters.eq("_id", usuarioId),
                Updates.addToSet("canciones", cancionId)
            );

            if (result.getMatchedCount() == 0) {
                throw new PersistenciaException("Usuario no encontrado para agregar canción favorito");
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al agregar canción favorito", e);
        }
    }

    @Override
    public void eliminarCancionFavorito(ObjectId usuarioId, ObjectId cancionId) throws PersistenciaException {
        try {
            MongoDatabase db = ManejadorConexiones.obtenerBaseDatos();
            MongoCollection<Usuario> coleccion = db.getCollection("usuarios", Usuario.class);

            UpdateResult result = coleccion.updateOne(
                Filters.eq("_id", usuarioId),
                Updates.pull("canciones", cancionId)
            );

            if (result.getMatchedCount() == 0) {
                throw new PersistenciaException("Usuario no encontrado para eliminar canción favorito");
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al eliminar canción favorito", e);
        }
    }


    public void actualizarGenerosRestringidosPorId(Object id, List<String> generosRestringidos) throws PersistenciaException {
    try {
        MongoDatabase db = ManejadorConexiones.obtenerBaseDatos();
        MongoCollection<Usuario> coleccion = db.getCollection("usuarios", Usuario.class);

        Document filtro = new Document("_id", id);
        Document actualizacion = new Document("$set", new Document("generosRestringidos", generosRestringidos));

        coleccion.updateOne(filtro, actualizacion);

    } catch (Exception e) {
        throw new PersistenciaException("Error al actualizar géneros restringidos en la base de datos", e);
    }
}

}
