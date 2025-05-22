/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tune.sistemabibliotecapersistencia.daos;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.List;
import org.bson.Document;
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
