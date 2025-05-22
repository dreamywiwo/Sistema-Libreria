
package tune.sistemabibliotecapersistencia.daos;

import com.mongodb.client.AggregateIterable;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import tune.sistemabibliotecadominio.dtos.AlbumConArtistaDTO;
import tune.sistemabibliotecadominio.dtos.ArtistaDTO;
import tune.sistemabibliotecadominio.dtos.CancionConArtistaDTO;
import tune.sistemabibliotecadominio.dtos.IntegranteDTO;
import tune.sistemabibliotecadominio.entidades.Artista;
import tune.sistemabibliotecapersistencia.conexion.ManejadorConexiones;
import tune.sistemabibliotecapersistencia.exception.PersistenciaException;
import tune.sistemabibliotecapersistencia.interfaces.IArtistasDAO;

public class ArtistasDAO implements IArtistasDAO {
    
    private final String COLECCION_ARTISTAS = "Artistas";
    private MongoCollection<Artista> coleccionArtistas;

    public ArtistasDAO() {
        MongoDatabase db = ManejadorConexiones.obtenerBaseDatos();
        coleccionArtistas = db.getCollection(COLECCION_ARTISTAS, Artista.class);
    }

    @Override
    public List<Artista> obtenerTodosLosArtistas() throws PersistenciaException {
        List<Artista> artistas = new ArrayList<>();
        coleccionArtistas.find().into(artistas);
        return artistas;
    }

    @Override
    public List<Artista> obtenerPorNombre(String nombre) throws PersistenciaException {
        List<Artista> artistas = new ArrayList<>();
        coleccionArtistas.find(Filters.regex("nombre", ".*" + nombre + ".*", "i"))
                        .into(artistas);
        return artistas;
    }

    @Override
    public List<Artista> obtenerPorGenero(String generoMusical) throws PersistenciaException {
        List<Artista> artistas = new ArrayList<>();
        coleccionArtistas.find(Filters.regex("generoMusical", "^" + generoMusical + "$", "i"))
                        .into(artistas);
        return artistas;
    }
    
    @Override
    public ArtistaDTO obtenerArtistaPorId(String artistaId) throws PersistenciaException {
        try {
            MongoCollection<Document> coleccion = ManejadorConexiones
                .obtenerBaseDatos()
                .getCollection(COLECCION_ARTISTAS);

            Document doc = coleccion.find(Filters.eq("_id", new ObjectId(artistaId))).first();

            if (doc == null) {
                return null;
            }

            ArtistaDTO artistaDTO = new ArtistaDTO();
            artistaDTO.setId(doc.getObjectId("_id").toHexString());
            artistaDTO.setTipo(doc.getString("tipo"));
            artistaDTO.setNombre(doc.getString("nombre"));
            artistaDTO.setImagen(doc.getString("imagen"));
            artistaDTO.setGeneroMusical(doc.getString("generoMusical"));

            List<Document> integrantesDocs = (List<Document>) doc.get("integrantes");
            if (integrantesDocs != null) {
                List<IntegranteDTO> integrantes = new ArrayList<>();
                for (Document integranteDoc : integrantesDocs) {
                    String nombreCompleto = integranteDoc.getString("nombreCompleto");
                    String rol = integranteDoc.getString("rol");

                    LocalDate fechaIngreso = null;
                    LocalDate fechaSalida = null;

                    Object fechaIngresoObj = integranteDoc.get("fechaIngreso");
                    if (fechaIngresoObj instanceof java.util.Date) {
                        fechaIngreso = ((java.util.Date) fechaIngresoObj).toInstant()
                            .atZone(java.time.ZoneId.systemDefault()).toLocalDate();
                    } else if (fechaIngresoObj instanceof String) {
                        fechaIngreso = LocalDate.parse((String) fechaIngresoObj);
                    }

                    Object fechaSalidaObj = integranteDoc.get("fechaSalida");
                    if (fechaSalidaObj instanceof java.util.Date) {
                        fechaSalida = ((java.util.Date) fechaSalidaObj).toInstant()
                            .atZone(java.time.ZoneId.systemDefault()).toLocalDate();
                    } else if (fechaSalidaObj instanceof String) {
                        fechaSalida = LocalDate.parse((String) fechaSalidaObj);
                    }

                    String estadoActividad = integranteDoc.getString("estadoActividad");

                    IntegranteDTO integrante = new IntegranteDTO(nombreCompleto, rol, fechaIngreso, fechaSalida, estadoActividad);
                    integrantes.add(integrante);
                }
                artistaDTO.setIntegrantes(integrantes);
            }

            return artistaDTO;
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener artista por ID", e);
        }
    }
    
    @Override
    public List<AlbumConArtistaDTO> obtenerAlbumesPorArtista(String artistaId) throws PersistenciaException {
        List<AlbumConArtistaDTO> resultado = new ArrayList<>();

        try {
            MongoCollection<Document> coleccion = ManejadorConexiones
                .obtenerBaseDatos()
                .getCollection("Albumes");

            List<Bson> pipeline = Arrays.asList(
                match(Filters.eq("artistaId", new ObjectId(artistaId))),
                lookup("Artistas", "artistaId", "_id", "artista"),
                unwind("$artista"),
                project(fields(
                    include("_id", "nombre", "imagenUrl"),
                    computed("nombreArtista", "$artista.nombre")
                ))
            );

            AggregateIterable<Document> docs = coleccion.aggregate(pipeline);

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

        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener álbumes por artista", e);
        }
    }
    
    @Override
    public List<CancionConArtistaDTO> obtenerCancionesPorArtista(String artistaId) throws PersistenciaException {
        List<CancionConArtistaDTO> resultado = new ArrayList<>();

        try {
            MongoCollection<Document> coleccion = ManejadorConexiones
                .obtenerBaseDatos()
                .getCollection("Canciones");

            List<Bson> pipeline = Arrays.asList(
                match(Filters.eq("artistaId", new ObjectId(artistaId))),
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

            AggregateIterable<Document> docs = coleccion.aggregate(pipeline);

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

        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener canciones por artista", e);
        }
    }
    
    
    
}
