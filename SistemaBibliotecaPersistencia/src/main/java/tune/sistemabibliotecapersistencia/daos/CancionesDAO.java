
package tune.sistemabibliotecapersistencia.daos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.List;
import tune.sistemabibliotecadominio.entidades.Cancion;
import tune.sistemabibliotecapersistencia.conexion.ManejadorConexiones;
import tune.sistemabibliotecapersistencia.exception.PersistenciaException;
import tune.sistemabibliotecapersistencia.interfaces.ICancionesDAO;

public class CancionesDAO implements ICancionesDAO {
    
    private final String COLECCION_CANCIONES = "Canciones";
    private MongoCollection<Cancion> coleccionCanciones;

    public CancionesDAO() {
        MongoDatabase db = ManejadorConexiones.obtenerBaseDatos();
        coleccionCanciones = db.getCollection(COLECCION_CANCIONES, Cancion.class);
    }

    @Override
    public List<Cancion> obtenerTodasLasCanciones() throws PersistenciaException {
        List<Cancion> canciones = new ArrayList<>();
        coleccionCanciones.find().into(canciones);
        return canciones;
    }

    @Override
    public List<Cancion> obtenerCancionesPorNombre(String nombre) throws PersistenciaException {
        List<Cancion> canciones = new ArrayList<>();
        coleccionCanciones.find(Filters.regex("nombre", ".*" + nombre + ".*", "i"))
                        .into(canciones);
        return canciones;
    }
    
    
    
}
