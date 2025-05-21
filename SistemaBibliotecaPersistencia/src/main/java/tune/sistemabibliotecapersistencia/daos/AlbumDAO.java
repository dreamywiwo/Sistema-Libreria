
package tune.sistemabibliotecapersistencia.daos;

import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;
import tune.sistemabibliotecadominio.dtos.AlbumDTO;
import tune.sistemabibliotecadominio.dtos.ArtistaDTO;
import tune.sistemabibliotecadominio.entidades.Album;
import tune.sistemabibliotecadominio.entidades.Artista;

public class AlbumDAO {

    List<Album> crearAlbumesDeArtista(Artista artista, ObjectId artistaId) {
        List<Album> albums = new ArrayList<>();
        // Convertir el Artista a ArtistaDTO
        ArtistaDTO artistaDTO = new ArtistaDTO(artista.getNombre(), artista.getTipo(), artista.getGeneroMusical(), artista.getImagen());
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

    List<Album> crearAlbumesDeBanda(Artista banda, ObjectId bandaId) {
        List<Album> albums = new ArrayList<>();
        // Convertir el Artista (banda) a ArtistaDTO
        ArtistaDTO bandaDTO = new ArtistaDTO(banda.getNombre(), banda.getTipo(), banda.getGeneroMusical(), banda.getImagen());
        // Obtener los álbumes de esta Banda (ArtistaDTO)
        List<AlbumDTO> albumDTOs = DatosPredefinidos.obtenerAlbumesDeBanda(bandaDTO);
        for (AlbumDTO albumDTO : albumDTOs) {
            Album album = new Album();
            album.setNombre(albumDTO.getNombre());
            album.setFechaLanzamiento(albumDTO.getFechaLanzamiento());
            album.setGeneroMusical(albumDTO.getGeneroMusical());
            album.setImagenPortada(albumDTO.getImagenPortada());
            album.setArtistaId(bandaId); // Asociar al Artista (banda) por su ID
            albums.add(album);
        }
        return albums;
    }
    
}
