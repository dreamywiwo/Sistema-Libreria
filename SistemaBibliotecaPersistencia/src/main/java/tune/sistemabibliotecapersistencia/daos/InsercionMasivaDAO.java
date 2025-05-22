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

        // Obtener artistas solistas y bandas predefinidos
        List<ArtistaDTO> artistasSolistas = DatosPredefinidos.obtenerArtistasSolistas();
        List<ArtistaDTO> bandas = DatosPredefinidos.obtenerBandas();

        // Listas separadas para evitar problemas de IDs duplicados
        List<Artista> solistasToInsert = new ArrayList<>();
        List<Album> albumsToInsert = new ArrayList<>();
        List<Cancion> cancionesToInsert = new ArrayList<>();

        // Procesar solistas
        for (ArtistaDTO artistaDTO : artistasSolistas) {
            Artista artistaExistente = coleccionArtistas.find(eq("nombre", artistaDTO.getNombre())).first();
            if (artistaExistente == null) {
                Artista artista = crearArtista(artistaDTO);
                solistasToInsert.add(artista);
            }
        }

        if (!solistasToInsert.isEmpty()) {
            coleccionArtistas.insertMany(solistasToInsert);
        }

        // Crear álbumes y canciones para solistas
        for (Artista artista : solistasToInsert) {
            List<Album> albums = crearAlbumesDeArtista(artista, artista.getId());
            albumsToInsert.addAll(albums);

            for (Album album : albums) {
                cancionesToInsert.addAll(crearCancionesDeAlbum(album, artista.getId()));
            }
        }

        if (!albumsToInsert.isEmpty()) {
            coleccionAlbumes.insertMany(albumsToInsert);
        }

        // Asignar albumId en canciones donde esté null (seguramente no necesario si se asignó bien)
        for (Album album : albumsToInsert) {
            for (Cancion cancion : cancionesToInsert) {
                if (cancion.getAlbumId() == null) {
                    cancion.setAlbumId(album.getId());
                }
            }
        }

        if (!cancionesToInsert.isEmpty()) {
            coleccionCanciones.insertMany(cancionesToInsert);
        }

        // Ahora procesar las bandas por separado
        List<Artista> bandasToInsert = new ArrayList<>();
        albumsToInsert.clear();
        cancionesToInsert.clear();

        for (ArtistaDTO bandaDTO : bandas) {
            Artista bandaExistente = coleccionArtistas.find(eq("nombre", bandaDTO.getNombre())).first();
            if (bandaExistente == null) {
                Artista banda = crearArtista(bandaDTO);
                bandasToInsert.add(banda);
            }
        }

        if (!bandasToInsert.isEmpty()) {
            coleccionArtistas.insertMany(bandasToInsert);
        }

        // Crear álbumes y canciones para bandas
        for (Artista banda : bandasToInsert) {
            List<Album> albums = crearAlbumesDeBanda(banda, banda.getId());
            albumsToInsert.addAll(albums);

            for (Album album : albums) {
                cancionesToInsert.addAll(crearCancionesDeAlbum(album, banda.getId()));
            }
        }

        if (!albumsToInsert.isEmpty()) {
            coleccionAlbumes.insertMany(albumsToInsert);
        }

        for (Album album : albumsToInsert) {
            for (Cancion cancion : cancionesToInsert) {
                if (cancion.getAlbumId() == null) {
                    cancion.setAlbumId(album.getId());
                }
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