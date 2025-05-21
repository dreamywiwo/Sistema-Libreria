
package tune.sistemabibliotecapersistencia.daos;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Aggregates.lookup;
import static com.mongodb.client.model.Aggregates.match;
import static com.mongodb.client.model.Aggregates.project;
import static com.mongodb.client.model.Aggregates.unwind;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Projections.computed;
import static com.mongodb.client.model.Projections.fields;
import static com.mongodb.client.model.Projections.include;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import tune.sistemabibliotecadominio.dtos.AlbumConArtistaDTO;
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
    public List<AlbumConArtistaDTO> obtenerAlbumPorNombreConArtista(String nombre) throws PersistenciaException {
        List<AlbumConArtistaDTO> resultado = new ArrayList<>();

        MongoCollection<Document> coleccionDocs = ManejadorConexiones
            .obtenerBaseDatos()
            .getCollection(COLECCION_ALBUMES);

        List<Bson> pipeline = Arrays.asList(
            match(Filters.regex("nombre", ".*" + nombre + ".*", "i")),
            lookup("Artistas", "artistaId", "_id", "artista"),
            unwind("$artista"),
            project(fields(
                include("_id", "nombre", "imagenUrl"),
                computed("nombreArtista", "$artista.nombre")
            ))
        );

        AggregateIterable<Document> docs = coleccionDocs.aggregate(pipeline);

        for (Document doc : docs) {
            AlbumConArtistaDTO dto = new AlbumConArtistaDTO(
                doc.getObjectId("_id"),
                doc.getString("nombre"),
                doc.getString("imagenUrl"),
                doc.getString("nombreArtista")
            );
            resultado.add(dto);
        }

        return resultado;
    }

    @Override
    public List<AlbumConArtistaDTO> obtenerAlbumPorGeneroConArtista(String generoMusical) throws PersistenciaException {
        List<AlbumConArtistaDTO> resultado = new ArrayList<>();

        MongoCollection<Document> coleccionDocs = ManejadorConexiones
            .obtenerBaseDatos()
            .getCollection(COLECCION_ALBUMES);

        List<Bson> pipeline = Arrays.asList(
            match(Filters.regex("generoMusical", ".*" + generoMusical + ".*", "i")),
            lookup("Artistas", "artistaId", "_id", "artista"),
            unwind("$artista"),
            project(fields(
                include("_id", "nombre", "imagenUrl"),
                computed("nombreArtista", "$artista.nombre")
            ))
        );

        AggregateIterable<Document> docs = coleccionDocs.aggregate(pipeline);

        for (Document doc : docs) {
            AlbumConArtistaDTO dto = new AlbumConArtistaDTO(
                doc.getObjectId("_id"),
                doc.getString("nombre"),
                doc.getString("imagenUrl"),
                doc.getString("nombreArtista")
            );
            resultado.add(dto);
        }

        return resultado;
    }


    @Override
    public List<AlbumConArtistaDTO> obtenerAlbumPorFechaLanzamientoConArtista(String fechaLanzamiento) throws PersistenciaException {
        List<AlbumConArtistaDTO> resultado = new ArrayList<>();

        if (!fechaLanzamiento.matches("\\d{4}-\\d{2}-\\d{2}")) {
            return resultado; 
        }

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(fechaLanzamiento, formatter);
            Date date = java.sql.Date.valueOf(localDate);

            MongoCollection<Document> coleccionDocs = ManejadorConexiones
                .obtenerBaseDatos()
                .getCollection(COLECCION_ALBUMES);

            List<Bson> pipeline = Arrays.asList(
                match(Filters.eq("fechaLanzamiento", date)),
                lookup("Artistas", "artistaId", "_id", "artista"),
                unwind("$artista"),
                project(fields(
                    include("_id", "nombre", "imagenUrl"),
                    computed("nombreArtista", "$artista.nombre")
                ))
            );

            AggregateIterable<Document> docs = coleccionDocs.aggregate(pipeline);

            for (Document doc : docs) {
                AlbumConArtistaDTO dto = new AlbumConArtistaDTO(
                    doc.getObjectId("_id"),
                    doc.getString("nombre"),
                    doc.getString("imagenUrl"),
                    doc.getString("nombreArtista")
                );
                resultado.add(dto);
            }

        } catch (DateTimeParseException e) {

        }

        return resultado;
    }
    
    @Override
    public List<AlbumConArtistaDTO> obtenerAlbumsConNombreArtista() throws PersistenciaException {
        List<AlbumConArtistaDTO> resultado = new ArrayList<>();

        MongoCollection<Document> coleccionDocs = ManejadorConexiones
            .obtenerBaseDatos()
            .getCollection(COLECCION_ALBUMES);

        List<Bson> pipeline = Arrays.asList(
            lookup("Artistas", "artistaId", "_id", "artista"),
            unwind("$artista"),
            project(fields(
                include("_id", "nombre", "imagenUrl"),
                computed("nombreArtista", "$artista.nombre")
            ))
        );

        AggregateIterable<Document> docs = coleccionDocs.aggregate(pipeline);

        for (Document doc : docs) {
            AlbumConArtistaDTO dto = new AlbumConArtistaDTO(
                doc.getObjectId("_id"),
                doc.getString("nombre"),
                doc.getString("imagenUrl"),
                doc.getString("nombreArtista")
            );
            resultado.add(dto);
        }

        return resultado;
    }

    
}
