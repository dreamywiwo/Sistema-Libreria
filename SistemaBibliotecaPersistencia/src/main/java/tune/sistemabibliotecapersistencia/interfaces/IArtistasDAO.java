/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tune.sistemabibliotecapersistencia.interfaces;

import java.util.List;
import tune.sistemabibliotecadominio.entidades.Artista;
import tune.sistemabibliotecapersistencia.exception.PersistenciaException;

/**
 *
 * @author Dana Chavez
 */
public interface IArtistasDAO {
    
    public abstract List<Artista> obtenerTodosLosArtistas() throws PersistenciaException;
    
    public abstract List<Artista> obtenerPorNombre(String nombre) throws PersistenciaException;
    
    public abstract List<Artista> obtenerPorGenero(String generoMusical) throws PersistenciaException;
    
}
