/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tune.sistemabibliotecanegocio.implementaciones;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.types.ObjectId;
import tune.sistemabibliotecadominio.dtos.CancionConArtistaDTO;
import tune.sistemabibliotecadominio.entidades.Cancion;
import tune.sistemabibliotecanegocio.exception.NegocioException;
import tune.sistemabibliotecanegocio.interfaces.ICancionesBO;
import tune.sistemabibliotecapersistencia.exception.PersistenciaException;
import tune.sistemabibliotecapersistencia.interfaces.ICancionesDAO;

/**
 *
 * @author Dana Chavez
 */
public class CancionesBO implements ICancionesBO {

    private final ICancionesDAO cancionesDAO;

    public CancionesBO(ICancionesDAO cancionesDAO) {
        this.cancionesDAO = cancionesDAO;
    }

    @Override
    public List<Cancion> obtenerTodasLasCanciones(List<String> generosRestringidos) throws NegocioException {
        try {
            return this.cancionesDAO.obtenerTodasLasCanciones(generosRestringidos);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudieron obtener las canciones");
        }
    }

    @Override
    public List<Cancion> obtenerCancionesPorNombre(String nombre, List<String> generosRestringidos) throws NegocioException {
        try {
            return this.cancionesDAO.obtenerCancionesPorNombre(nombre, generosRestringidos);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudieron obtener las canciones por nombre");
        }
    }

    @Override
    public List<CancionConArtistaDTO> obtenerTodasLasCancionesConNombreArtista(List<String> generosRestringidos) throws NegocioException {
        try {
            return this.cancionesDAO.obtenerTodasLasCancionesConNombreArtista(generosRestringidos);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudieron obtener las canciones con sus artistas");
        }
    }

    @Override
    public List<CancionConArtistaDTO> obtenerCancionesPorNombreConArtista(String nombre) throws NegocioException {
        try {
            return this.cancionesDAO.obtenerCancionesPorNombreConArtista(nombre);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudieron obtener las canciones con sus artistas");
        }
    }

    @Override
    public List<CancionConArtistaDTO> obtenerCancionesPorIds(List<ObjectId> cancionIds) throws NegocioException {
        try {
            return this.cancionesDAO.obtenerCancionesPorIds(cancionIds);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudieron obtener las canciones por ids");
        }
    }
    
}
