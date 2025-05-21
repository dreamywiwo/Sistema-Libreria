/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tune.sistemabibliotecanegocio.implementaciones;

import java.util.List;
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
    public List<Cancion> obtenerTodasLasCanciones() throws NegocioException {
        try {
            return this.cancionesDAO.obtenerTodasLasCanciones();
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudieron obtener las canciones");
        }
    }

    @Override
    public List<Cancion> obtenerCancionesPorNombre(String nombre) throws NegocioException {
        try {
            return this.cancionesDAO.obtenerCancionesPorNombre(nombre);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudieron obtener los artistas");
        }
    }
    
}
