
package tune.sistemabibliotecapersistencia.daos;

import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;
import tune.sistemabibliotecadominio.dtos.CancionDTO;
import tune.sistemabibliotecadominio.entidades.Album;
import tune.sistemabibliotecadominio.entidades.Cancion;

public class CancionDAO {

    List<Cancion> crearCancionesDeAlbum(Album album, ObjectId artistaId) {
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
