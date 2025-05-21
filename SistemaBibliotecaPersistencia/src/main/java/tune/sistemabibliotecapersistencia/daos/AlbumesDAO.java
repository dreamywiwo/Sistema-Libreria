
package tune.sistemabibliotecapersistencia.daos;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import tune.sistemabibliotecadominio.entidades.Album;
import tune.sistemabibliotecapersistencia.conexion.ManejadorConexiones;
import tune.sistemabibliotecapersistencia.exception.PersistenciaException;
import tune.sistemabibliotecapersistencia.interfaces.IAlbumesDAO;

public class AlbumesDAO implements IAlbumesDAO {
    
    private final String COLECCION_ALBUMES = "Albumes";
    private MongoCollection<Album> coleccionAlbumes;

    public AlbumesDAO() {        
        MongoDatabase db = ManejadorConexiones.obtenerBaseDatos();
        coleccionAlbumes = db.getCollection(COLECCION_ALBUMES, Album.class);
    }
    
    @Override
    public List<Album> obtenerTodosLosAlbums() throws PersistenciaException {
        FindIterable<Album> resultados = coleccionAlbumes.find();
        List<Album> listaAlbumes = new LinkedList<>();
        resultados.into(listaAlbumes);

        return listaAlbumes;
    }

    @Override
    public List<Album> obtenerAlbumPorNombre(String nombre) throws PersistenciaException {
        List<Album> artistas = new ArrayList<>();
        coleccionAlbumes.find(Filters.regex("nombre", ".*" + nombre + ".*", "i"))
                        .into(artistas);
        return artistas;
    }

    @Override
    public List<Album> obtenerAlbumPorGenero(String generoMusical) throws PersistenciaException {
        List<Album> artistas = new ArrayList<>();
        coleccionAlbumes.find(Filters.regex("generoMusical", ".*" + generoMusical + ".*", "i"))
                        .into(artistas);
        return artistas;
    }

    @Override
    public List<Album> obtenerAlbumPorFechaLanzamiento(String fechaLanzamiento) throws PersistenciaException {     
        List<Album> listaAlbumes = new LinkedList<>();

        if (!fechaLanzamiento.matches("\\d{4}-\\d{2}-\\d{2}")) {
            return listaAlbumes; 
        }
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(fechaLanzamiento, formatter);
            Date date = java.sql.Date.valueOf(localDate);

            coleccionAlbumes.find(Filters.eq("fechaLanzamiento", date)).into(listaAlbumes);
        } catch (DateTimeParseException e) {

        }
        return listaAlbumes;
    }
    
}
