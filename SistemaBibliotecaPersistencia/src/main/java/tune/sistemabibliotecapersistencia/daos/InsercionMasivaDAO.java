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

        List<Artista> artistasToInsert = new ArrayList<>();
        List<Album> albumsToInsert = new ArrayList<>();
        List<Cancion> cancionesToInsert = new ArrayList<>();

        // Procesar artistas, álbumes y canciones para insertar
        for (ArtistaDTO artistaDTO : artistasSolistas) {
            // Verificar si el artista ya existe en la base de datos
            Artista artistaExistente = coleccionArtistas.find(eq("nombre", artistaDTO.getNombre())).first();
            if (artistaExistente == null) {
                // Crear y agregar el artista solo si no existe
                Artista artista = crearArtista(artistaDTO);
                artistasToInsert.add(artista);
            }
        }

        // Realizar inserciones masivas de artistas primero
        if (!artistasToInsert.isEmpty()) {
            coleccionArtistas.insertMany(artistasToInsert);
        }

        // Asignar los IDs generados a los artistas y continuar con los álbumes y canciones
        for (Artista artista : artistasToInsert) {
            // Crear y agregar álbumes
            List<Album> albums = crearAlbumesDeArtista(artista, artista.getId());
            albumsToInsert.addAll(albums);

            // Crear y agregar canciones
            for (Album album : albums) {
                cancionesToInsert.addAll(crearCancionesDeAlbum(album, artista.getId()));
            }
        }

        // Insertar los álbumes
        if (!albumsToInsert.isEmpty()) {
            coleccionAlbumes.insertMany(albumsToInsert);
        }

        // Asignar los IDs generados para los álbumes y continuar con las canciones
        for (Album album : albumsToInsert) {
            for (Cancion cancion : cancionesToInsert) {
                if (cancion.getAlbumId() == null) {
                    cancion.setAlbumId(album.getId());
                }
            }
        }

        // Insertar las canciones
        if (!cancionesToInsert.isEmpty()) {
            coleccionCanciones.insertMany(cancionesToInsert);
        }

        // Repetir el mismo proceso para las bandas
        for (ArtistaDTO bandaDTO : bandas) {
            // Verificar si la banda ya existe en la base de datos
            Artista bandaExistente = coleccionArtistas.find(eq("nombre", bandaDTO.getNombre())).first();
            if (bandaExistente == null) {
                // Crear y agregar la banda solo si no existe
                Artista banda = crearArtista(bandaDTO);
                artistasToInsert.add(banda);
            }
        }

        // Realizar inserciones masivas de bandas
        if (!artistasToInsert.isEmpty()) {
            coleccionArtistas.insertMany(artistasToInsert);
        }

        // Asignar los IDs generados a las bandas y continuar con los álbumes y canciones
        for (Artista banda : artistasToInsert) {
            List<Album> albums = crearAlbumesDeBanda(banda, banda.getId());
            albumsToInsert.addAll(albums);

            for (Album album : albums) {
                cancionesToInsert.addAll(crearCancionesDeAlbum(album, banda.getId()));
            }
        }

        // Insertar los álbumes de las bandas
        if (!albumsToInsert.isEmpty()) {
            coleccionAlbumes.insertMany(albumsToInsert);
        }

        // Asignar los IDs generados para los álbumes y continuar con las canciones
        for (Album album : albumsToInsert) {
            for (Cancion cancion : cancionesToInsert) {
                if (cancion.getAlbumId() == null) {
                    cancion.setAlbumId(album.getId());
                }
            }
        }

        // Insertar las canciones de las bandas
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

        // Convertir el Artista a ArtistaDTO
        ArtistaDTO artistaDTO = new ArtistaDTO(
            artista.getNombre(),
            artista.getTipo(),
            artista.getGeneroMusical(),
            artista.getImagen()
        );

        // Obtener los álbumes de este ArtistaDTO
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

        // Convertir el Artista (banda) a ArtistaDTO
        ArtistaDTO bandaDTO = new ArtistaDTO(
            banda.getNombre(),
            banda.getTipo(),
            banda.getGeneroMusical(),
            banda.getImagen()
        );

        // Obtener los álbumes de esta Banda (ArtistaDTO)
        List<AlbumDTO> albumDTOs = DatosPredefinidos.obtenerAlbumesDeBanda(bandaDTO);

        for (AlbumDTO albumDTO : albumDTOs) {
            Album album = new Album();
            album.setNombre(albumDTO.getNombre());
            album.setFechaLanzamiento(albumDTO.getFechaLanzamiento());
            album.setGeneroMusical(albumDTO.getGeneroMusical());
            album.setImagenPortada(albumDTO.getImagenPortada());
            album.setArtistaId(bandaId);  // Asociar al Artista (banda) por su ID
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
