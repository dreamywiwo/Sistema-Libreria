
package tune.sistemabibliotecapersistencia.daos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.List;
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
    
}
