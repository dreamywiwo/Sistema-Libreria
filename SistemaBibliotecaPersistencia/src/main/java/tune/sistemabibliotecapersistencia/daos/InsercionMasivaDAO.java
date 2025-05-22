package tune.sistemabibliotecapersistencia.daos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import org.bson.types.ObjectId;
import tune.sistemabibliotecadominio.dtos.AlbumDTO;
import tune.sistemabibliotecadominio.dtos.ArtistaDTO;
import tune.sistemabibliotecadominio.dtos.CancionDTO;
import tune.sistemabibliotecadominio.entidades.Album;
import tune.sistemabibliotecadominio.entidades.Artista;
import tune.sistemabibliotecadominio.entidades.Cancion;
import tune.sistemabibliotecapersistencia.conexion.ManejadorConexiones;
import tune.sistemabibliotecapersistencia.interfaces.IInsercionMasiva;

import java.util.ArrayList;
import java.util.List;

public class InsercionMasivaDAO implements IInsercionMasiva {

    private final String COLECCION_ARTISTAS = "Artistas";
    private final String COLECCION_ALBUMES = "Albumes";
    private final String COLECCION_CANCIONES = "Canciones";

    @Override
    public void insertarArtistasMasivamente() {
        MongoDatabase db = ManejadorConexiones.obtenerBaseDatos();
        MongoCollection<Artista> coleccionArtistas = db.getCollection(COLECCION_ARTISTAS, Artista.class);
        MongoCollection<Album> coleccionAlbumes = db.getCollection(COLECCION_ALBUMES, Album.class);
        MongoCollection<Cancion> coleccionCanciones = db.getCollection(COLECCION_CANCIONES, Cancion.class);

        List<ArtistaDTO> artistasSolistas = DatosPredefinidos.obtenerArtistasSolistas();
        List<ArtistaDTO> bandas = DatosPredefinidos.obtenerBandas();

        List<Artista> solistasToInsert = new ArrayList<>();
        List<Artista> bandasToInsert = new ArrayList<>();

        // Filtrar solistas que no existen aún
        for (ArtistaDTO artistaDTO : artistasSolistas) {
            Artista artistaExistente = coleccionArtistas.find(eq("nombre", artistaDTO.getNombre())).first();
            if (artistaExistente == null) {
                Artista artista = crearArtista(artistaDTO);
                solistasToInsert.add(artista);
            }
        }

        // Filtrar bandas que no existen aún
        for (ArtistaDTO bandaDTO : bandas) {
            Artista bandaExistente = coleccionArtistas.find(eq("nombre", bandaDTO.getNombre())).first();
            if (bandaExistente == null) {
                Artista banda = crearArtista(bandaDTO);
                bandasToInsert.add(banda);
            }
        }

        // Insertar solistas
        if (!solistasToInsert.isEmpty()) {
            coleccionArtistas.insertMany(solistasToInsert);
        }

        List<Cancion> cancionesToInsert = new ArrayList<>();

        // Insertar álbumes y canciones de solistas
        for (Artista artista : solistasToInsert) {
            List<Album> albums = crearAlbumesDeArtista(artista, artista.getId());

            if (!albums.isEmpty()) {
                coleccionAlbumes.insertMany(albums);
            }

            for (Album album : albums) {
                List<Cancion> canciones = crearCancionesDeAlbum(album, artista.getId());
                cancionesToInsert.addAll(canciones);
            }
        }

        if (!cancionesToInsert.isEmpty()) {
            coleccionCanciones.insertMany(cancionesToInsert);
        }

        // Limpiar lista de canciones para bandas
        cancionesToInsert.clear();

        // Insertar bandas
        if (!bandasToInsert.isEmpty()) {
            coleccionArtistas.insertMany(bandasToInsert);
        }

        // Insertar álbumes y canciones de bandas
        for (Artista banda : bandasToInsert) {
            List<Album> albums = crearAlbumesDeBanda(banda, banda.getId());

            if (!albums.isEmpty()) {
                coleccionAlbumes.insertMany(albums);
            }

            for (Album album : albums) {
                List<Cancion> canciones = crearCancionesDeAlbum(album, banda.getId());
                cancionesToInsert.addAll(canciones);
            }
        }

        if (!cancionesToInsert.isEmpty()) {
            coleccionCanciones.insertMany(cancionesToInsert);
        }
    }

    private Artista crearArtista(ArtistaDTO artistaDTO) {
        Artista artista = new Artista();
        artista.setNombre(artistaDTO.getNombre());
        artista.setTipo(artistaDTO.getTipo());
        artista.setGeneroMusical(artistaDTO.getGeneroMusical());
        artista.setImagen(artistaDTO.getImagen());
        return artista;
    }

    private List<Album> crearAlbumesDeArtista(Artista artista, ObjectId artistaId) {
        List<Album> albums = new ArrayList<>();

        ArtistaDTO artistaDTO = new ArtistaDTO(
            artista.getNombre(),
            artista.getTipo(),
            artista.getGeneroMusical(),
            artista.getImagen()
        );

        List<AlbumDTO> albumDTOs = DatosPredefinidos.obtenerAlbumesDeArtista(artistaDTO);

        for (AlbumDTO albumDTO : albumDTOs) {
            Album album = new Album();
            album.setNombre(albumDTO.getNombre());
            album.setFechaLanzamiento(albumDTO.getFechaLanzamiento());
            album.setGeneroMusical(albumDTO.getGeneroMusical());
            album.setImagenPortada(albumDTO.getImagenPortada());
            album.setArtistaId(artistaId);
            albums.add(album);
        }
        return albums;
    }

    private List<Album> crearAlbumesDeBanda(Artista banda, ObjectId bandaId) {
        List<Album> albums = new ArrayList<>();

        ArtistaDTO bandaDTO = new ArtistaDTO(
            banda.getNombre(),
            banda.getTipo(),
            banda.getGeneroMusical(),
            banda.getImagen()
        );

        List<AlbumDTO> albumDTOs = DatosPredefinidos.obtenerAlbumesDeBanda(bandaDTO);

        for (AlbumDTO albumDTO : albumDTOs) {
            Album album = new Album();
            album.setNombre(albumDTO.getNombre());
            album.setFechaLanzamiento(albumDTO.getFechaLanzamiento());
            album.setGeneroMusical(albumDTO.getGeneroMusical());
            album.setImagenPortada(albumDTO.getImagenPortada());
            album.setArtistaId(bandaId);
            albums.add(album);
        }
        return albums;
    }

    private List<Cancion> crearCancionesDeAlbum(Album album, ObjectId artistaId) {
        List<Cancion> canciones = new ArrayList<>();
        String albumNombre = album.getNombre();
        for (CancionDTO cancionDTO : DatosPredefinidos.obtenerCancionesDeAlbum(albumNombre)) {
            Cancion cancion = new Cancion();
            cancion.setNombre(cancionDTO.getNombre());
            cancion.setDuracion(cancionDTO.getDuracion());
            cancion.setAlbumId(album.getId());  
            cancion.setArtistaId(artistaId);
            cancion.setGeneroMusical(cancionDTO.getGeneroMusical());
            canciones.add(cancion);
        }
        return canciones;
    }
}