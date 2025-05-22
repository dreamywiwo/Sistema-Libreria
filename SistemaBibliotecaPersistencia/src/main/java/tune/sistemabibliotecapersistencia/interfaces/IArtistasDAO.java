/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tune.sistemabibliotecapersistencia.interfaces;

import java.util.List;
import tune.sistemabibliotecadominio.dtos.AlbumConArtistaDTO;
import tune.sistemabibliotecadominio.dtos.ArtistaDTO;
import tune.sistemabibliotecadominio.dtos.CancionConArtistaDTO;
import tune.sistemabibliotecadominio.entidades.Artista;
import tune.sistemabibliotecapersistencia.exception.PersistenciaException;

/**
 *
 * @author Dana Chavez
 */
public interface IArtistasDAO {
    
    public abstract List<Artista> obtenerTodosLosArtistas(List<String> generosRestringidos) throws PersistenciaException;

    public abstract List<Artista> obtenerPorNombre(String nombre, List<String> generosRestringidos) throws PersistenciaException;

    public abstract List<Artista> obtenerPorGenero(String generoMusical, List<String> generosRestringidos) throws PersistenciaException;
    
    public abstract ArtistaDTO obtenerArtistaPorId(String artistaId) throws PersistenciaException;
    
    public abstract List<AlbumConArtistaDTO> obtenerAlbumesPorArtista(String artistaId) throws PersistenciaException;
    
    public abstract List<CancionConArtistaDTO> obtenerCancionesPorArtista(String artistaId) throws PersistenciaException;

    
    
}
