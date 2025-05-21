
package tune.sistemabibliotecapersistencia.daos;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Aggregates.lookup;
import static com.mongodb.client.model.Aggregates.match;
import static com.mongodb.client.model.Aggregates.project;
import static com.mongodb.client.model.Aggregates.unwind;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.regex;
import static com.mongodb.client.model.Projections.computed;
import static com.mongodb.client.model.Projections.fields;
import static com.mongodb.client.model.Projections.include;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import tune.sistemabibliotecadominio.dtos.CancionConArtistaDTO;
import tune.sistemabibliotecadominio.entidades.Cancion;
import tune.sistemabibliotecapersistencia.conexion.ManejadorConexiones;
import tune.sistemabibliotecapersistencia.exception.PersistenciaException;
import tune.sistemabibliotecapersistencia.interfaces.ICancionesDAO;

public class CancionesDAO implements ICancionesDAO {
    
    private final String COLECCION_CANCIONES = "Canciones";
    private MongoCollection<Cancion> coleccionCanciones;

    public CancionesDAO() {
        MongoDatabase db = ManejadorConexiones.obtenerBaseDatos();
        coleccionCanciones = db.getCollection(COLECCION_CANCIONES, Cancion.class);
    }

    @Override
    public List<Cancion> obtenerTodasLasCanciones() throws PersistenciaException {
        List<Cancion> canciones = new ArrayList<>();
        coleccionCanciones.find().into(canciones);
        return canciones;
    }

    @Override
    public List<Cancion> obtenerCancionesPorNombre(String nombre) throws PersistenciaException {
        List<Cancion> canciones = new ArrayList<>();
        coleccionCanciones.find(Filters.regex("nombre", ".*" + nombre + ".*", "i"))
                        .into(canciones);
        return canciones;
    }
    
    @Override
    public List<CancionConArtistaDTO> obtenerTodasLasCancionesConNombreArtista() throws PersistenciaException {
        List<CancionConArtistaDTO> resultado = new ArrayList<>();

        MongoCollection<Document> coleccionDocs = ManejadorConexiones
            .obtenerBaseDatos()
            .getCollection(COLECCION_CANCIONES);

            List<Bson> pipeline = Arrays.asList(
                lookup("Artistas", "artistaId", "_id", "artista"),
                unwind("$artista"),
                lookup("Albumes", "albumId", "_id", "album"),
                unwind("$album"),
                project(fields(
                    include("nombre", "duracion"),
                    computed("nombreArtista", "$artista.nombre"),
                    computed("nombreAlbum", "$album.nombre"),
                    computed("urlImagenAlbum", "$album.imagenUrl") 
                ))
            );

        AggregateIterable<Document> docs = coleccionDocs.aggregate(pipeline);

        for (Document doc : docs) {
            CancionConArtistaDTO dto = new CancionConArtistaDTO(
                doc.getString("nombre"),
                doc.getString("nombreArtista"),
                doc.getString("nombreAlbum"),
                doc.getString("duracion"),
                doc.getString("urlImagenAlbum")
            );
            resultado.add(dto);
        }

        return resultado;
    }

    @Override
    public List<CancionConArtistaDTO> obtenerCancionesPorNombreConArtista(String nombre) throws PersistenciaException {
        List<CancionConArtistaDTO> resultado = new ArrayList<>();

        MongoCollection<Document> coleccionDocs = ManejadorConexiones
            .obtenerBaseDatos()
            .getCollection(COLECCION_CANCIONES);

        List<Bson> pipeline = Arrays.asList(
            match(regex("nombre", nombre, "i")), // filtro case-insensitive por nombre
            lookup("Artistas", "artistaId", "_id", "artista"),
            unwind("$artista"),
            lookup("Albumes", "albumId", "_id", "album"),
            unwind("$album"),
            project(fields(
                include("nombre", "duracion"),
                computed("nombreArtista", "$artista.nombre"),
                computed("nombreAlbum", "$album.nombre"),
                computed("urlImagenAlbum", "$album.imagenUrl") 
                )   
            )
        );

        AggregateIterable<Document> docs = coleccionDocs.aggregate(pipeline);

        for (Document doc : docs) {
            CancionConArtistaDTO dto = new CancionConArtistaDTO(
                doc.getString("nombre"),
                doc.getString("nombreArtista"),
                doc.getString("nombreAlbum"),
                doc.getString("duracion"),
                doc.getString("urlImagenAlbum")
            );
            resultado.add(dto);
        }

        return resultado;
    }

}
