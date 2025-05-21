/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tune.sistemabibliotecapersistencia.daos;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
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

}
