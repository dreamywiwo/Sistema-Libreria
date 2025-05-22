/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tune.sistemabibliotecapersistencia.interfaces;

import java.time.LocalDate;
import java.util.List;
import tune.sistemabibliotecadominio.dtos.AlbumConArtistaDTO;
import tune.sistemabibliotecadominio.dtos.CancionConArtistaDTO;
import tune.sistemabibliotecadominio.entidades.Album;
import tune.sistemabibliotecapersistencia.exception.PersistenciaException;

/**
 *
 * @author Dana Chavez
 */
public interface IAlbumesDAO {
    
    public abstract List<Album> obtenerTodosLosAlbums() throws PersistenciaException;
    
    public abstract List<AlbumConArtistaDTO> obtenerAlbumPorNombreConArtista(String nombre) throws PersistenciaException;
    
    public abstract List<AlbumConArtistaDTO> obtenerAlbumPorGeneroConArtista(String generoMusical) throws PersistenciaException;
    
    public abstract List<AlbumConArtistaDTO> obtenerAlbumPorFechaLanzamientoConArtista(String fechaLanzamiento) throws PersistenciaException;
    
    public abstract List<AlbumConArtistaDTO> obtenerAlbumsConNombreArtista() throws PersistenciaException;
    
    public abstract AlbumConArtistaDTO obtenerAlbumPorId(String albumId) throws PersistenciaException;
    
    public abstract String obtenerGeneroPorAlbum(String albumId) throws PersistenciaException;
    
    public abstract LocalDate obtenerFechaLanzamientoPorAlbum(String albumId) throws PersistenciaException;
    
    public abstract List<CancionConArtistaDTO> obtenerCancionesPorAlbum(String albumId) throws PersistenciaException;
    
    public abstract List<AlbumConArtistaDTO> buscarAlbumesPorTexto(String texto) throws PersistenciaException;
    
}
