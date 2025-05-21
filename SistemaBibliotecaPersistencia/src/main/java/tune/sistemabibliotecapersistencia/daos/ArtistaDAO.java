
package tune.sistemabibliotecapersistencia.daos;

import tune.sistemabibliotecadominio.dtos.ArtistaDTO;
import tune.sistemabibliotecadominio.entidades.Artista;

public class ArtistaDAO {

    Artista crearArtista(ArtistaDTO artistaDTO) {
        Artista artista = new Artista();
        artista.setNombre(artistaDTO.getNombre());
        artista.setTipo(artistaDTO.getTipo());
        artista.setGeneroMusical(artistaDTO.getGeneroMusical());
        artista.setImagen(artistaDTO.getImagen());
        return artista;
    }
    
}
