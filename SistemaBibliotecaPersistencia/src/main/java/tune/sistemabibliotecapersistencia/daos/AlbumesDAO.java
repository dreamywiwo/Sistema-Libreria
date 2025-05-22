
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
import static com.mongodb.client.model.Filters.eq;
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
import org.bson.types.ObjectId;
import tune.sistemabibliotecadominio.dtos.AlbumConArtistaDTO;
import tune.sistemabibliotecadominio.dtos.CancionConArtistaDTO;
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
    public List<AlbumConArtistaDTO> buscarAlbumesPorTexto(String texto) throws PersistenciaException {
        List<AlbumConArtistaDTO> resultado = new ArrayList<>();

        MongoCollection<Document> coleccionDocs = ManejadorConexiones
            .obtenerBaseDatos()
            .getCollection(COLECCION_ALBUMES);

        List<Bson> pipeline = Arrays.asList(
            lookup("Artistas", "artistaId", "_id", "artista"),
            unwind("$artista"),
            project(fields(
                include("_id", "nombre", "imagenUrl", "generoMusical"),
                computed("nombreArtista", "$artista.nombre"),
                computed("fechaLanzamientoStr", new Document("$dateToString", new Document("format", "%Y-%m-%d").append("date", "$fechaLanzamiento")))
            )),
            match(Filters.or(
                Filters.regex("nombre", texto, "i"),
                Filters.regex("generoMusical", texto, "i"),
                Filters.regex("nombreArtista", texto, "i"),
                Filters.regex("fechaLanzamientoStr", texto, "i")
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
    
    @Override
    public AlbumConArtistaDTO obtenerAlbumPorId(String albumId) throws PersistenciaException {
        MongoCollection<Document> coleccionDocs = ManejadorConexiones
            .obtenerBaseDatos()
            .getCollection(COLECCION_ALBUMES);

        List<Bson> pipeline = Arrays.asList(
            match(eq("_id", new ObjectId(albumId))),
            lookup("Artistas", "artistaId", "_id", "artista"),
            unwind("$artista"),
            project(fields(
                include("_id", "nombre", "imagenUrl", "generoMusical", "fechaLanzamiento"),
                computed("nombreArtista", "$artista.nombre")
            ))
        );

        AggregateIterable<Document> docs = coleccionDocs.aggregate(pipeline);
        Document doc = docs.first();
        if (doc == null) return null;

        return new AlbumConArtistaDTO(
            doc.getObjectId("_id"),
            doc.getString("nombre"),
            doc.getString("imagenUrl"),
            doc.getString("nombreArtista")
        );
    }

    @Override
    public String obtenerGeneroPorAlbum(String albumId) throws PersistenciaException {
        Album album = coleccionAlbumes.find(eq("_id", new ObjectId(albumId))).first();
        if (album == null) return null;
        return album.getGeneroMusical();
    }

    @Override
    public LocalDate obtenerFechaLanzamientoPorAlbum(String albumId) throws PersistenciaException {
        Album album = coleccionAlbumes.find(eq("_id", new ObjectId(albumId))).first();
        if (album == null) return null;
        return album.getFechaLanzamiento();
    }

    @Override
    public List<CancionConArtistaDTO> obtenerCancionesPorAlbum(String albumId) throws PersistenciaException {
        List<CancionConArtistaDTO> resultado = new ArrayList<>();
        MongoCollection<Document> coleccionCanciones = ManejadorConexiones
            .obtenerBaseDatos()
            .getCollection("Canciones");

        List<Bson> pipeline = Arrays.asList(
            match(eq("albumId", new ObjectId(albumId))),
            lookup("Artistas", "artistaId", "_id", "artista"),
            unwind("$artista"),
            project(fields(
                include("nombre", "duracion"),
                computed("nombreArtista", "$artista.nombre"),
                computed("nombreAlbum", "$albumId"), // Opcional, si quieres nombre album también
                computed("urlImagenAlbum", "") // Vacío o lo que tengas si es necesario
            ))
        );

        AggregateIterable<Document> docs = coleccionCanciones.aggregate(pipeline);

        for (Document doc : docs) {
            CancionConArtistaDTO dto = new CancionConArtistaDTO(
                doc.getString("nombre"),
                doc.getString("nombreArtista"),
                null, 
                doc.getString("duracion"),
                null 
            );
            resultado.add(dto);
        }
        return resultado;
    }
    
    
}
