/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tune.sistemabibliotecapersistencia.interfaces;

import java.time.LocalDate;
import java.util.List;
import org.bson.types.ObjectId;
import tune.sistemabibliotecadominio.dtos.AlbumConArtistaDTO;
import tune.sistemabibliotecadominio.dtos.CancionConArtistaDTO;
import tune.sistemabibliotecadominio.entidades.Album;
import tune.sistemabibliotecapersistencia.exception.PersistenciaException;

/**
 *
 * @author Dana Chavez
 */
public interface IAlbumesDAO {
    
    public abstract List<Album> obtenerTodosLosAlbums(List<String> generosRestringidos) throws PersistenciaException;
    
    public abstract List<AlbumConArtistaDTO> obtenerAlbumPorNombreConArtista(String nombre, List<String> generosRestringidos) throws PersistenciaException;
    
    public abstract List<AlbumConArtistaDTO> obtenerAlbumPorGeneroConArtista(String generoMusical, List<String> generosRestringidos) throws PersistenciaException;
    
    public abstract List<AlbumConArtistaDTO> obtenerAlbumPorFechaLanzamientoConArtista(String fechaLanzamiento, List<String> generosRestringidos) throws PersistenciaException;
    
    public abstract List<AlbumConArtistaDTO> obtenerAlbumsConNombreArtista(List<String> generosRestringidos) throws PersistenciaException;
    
    public abstract AlbumConArtistaDTO obtenerAlbumPorId(String albumId) throws PersistenciaException;
    
    public abstract String obtenerGeneroPorAlbum(String albumId) throws PersistenciaException;
    
    public abstract LocalDate obtenerFechaLanzamientoPorAlbum(String albumId) throws PersistenciaException;
    
    public abstract List<CancionConArtistaDTO> obtenerCancionesPorAlbum(String albumId) throws PersistenciaException;
    
    public abstract List<AlbumConArtistaDTO> buscarAlbumesPorTexto(String texto, List<String> generosRestringidos) throws PersistenciaException;
    
    public abstract List<AlbumConArtistaDTO> obtenerAlbumsPorIds(List<ObjectId> albumIds) throws PersistenciaException;
    
}
