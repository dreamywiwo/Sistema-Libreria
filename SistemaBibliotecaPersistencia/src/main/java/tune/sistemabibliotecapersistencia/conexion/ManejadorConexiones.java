
package tune.sistemabibliotecapersistencia.conexion;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 * Clase encargada de manejar las conexiones a MongoDB
 */
public class ManejadorConexiones {

    private static final String BASE_DATOS = "bibliotecaMusical";  

    /**
     * Regresa un MongoDatabase para la base de datos de producción.
     *
     * @return MongoDatabase a utilizar
     */
    public static MongoDatabase obtenerBaseDatos() {
        return crearMongoDatabase(BASE_DATOS);
    }

    /**
     * Crea el MongoDatabase a partir de un string con el nombre de la base de
     * datos
     *
     * @param nombreBaseDatos Nombre de la base de datos a utilizar
     * @return Base de datos a utilizar
     */
    private static MongoDatabase crearMongoDatabase(String nombreBaseDatos) {
        // Configuración del mapeador automático de POJOs
        CodecRegistry pojoCodecRegistry = fromRegistries(
            MongoClientSettings.getDefaultCodecRegistry(),
            fromProviders(PojoCodecProvider.builder().automatic(true).build())
        );

        // Asignar la configuración del mapeador con la conexión para que nuestras clases POJO sean reconocidas automáticamente
        MongoClientSettings configuraciones = MongoClientSettings.builder()
            .codecRegistry(pojoCodecRegistry)
            .build();

        // Conexión a MongoDB
        MongoClient cliente = MongoClients.create(configuraciones);

        // Obtener y retornar la base de datos
        return cliente.getDatabase(nombreBaseDatos);
    }
}
