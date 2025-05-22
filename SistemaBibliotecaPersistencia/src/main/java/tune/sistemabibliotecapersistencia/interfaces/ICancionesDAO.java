/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tune.sistemabibliotecapersistencia.interfaces;

import java.util.List;
import tune.sistemabibliotecadominio.dtos.CancionConArtistaDTO;
import tune.sistemabibliotecadominio.entidades.Cancion;
import tune.sistemabibliotecapersistencia.exception.PersistenciaException;

/**
 *
 * @author Dana Chavez
 */
public interface ICancionesDAO {

    public abstract List<Cancion> obtenerTodasLasCanciones(List<String> generosRestringidos) throws PersistenciaException;

    public abstract List<Cancion> obtenerCancionesPorNombre(String nombre, List<String> generosRestringidos) throws PersistenciaException;

    public abstract List<CancionConArtistaDTO> obtenerTodasLasCancionesConNombreArtista(List<String> generosRestringidos) throws PersistenciaException;

    public abstract List<CancionConArtistaDTO> obtenerCancionesPorNombreConArtista(String nombre) throws PersistenciaException;

}
