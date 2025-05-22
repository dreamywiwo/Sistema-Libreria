/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tune.sistemabibliotecanegocio.interfaces;

import java.time.LocalDate;
import java.util.List;
import tune.sistemabibliotecadominio.dtos.AlbumConArtistaDTO;
import tune.sistemabibliotecadominio.dtos.CancionConArtistaDTO;
import tune.sistemabibliotecadominio.entidades.Album;
import tune.sistemabibliotecanegocio.exception.NegocioException;

public interface IAlbumesBO {
    
    public abstract List<Album> obtenerTodosLosAlbums(List<String> generosRestringidos) throws NegocioException;
    
    public abstract List<AlbumConArtistaDTO> obtenerAlbumPorNombreConArtista(String nombre, List<String> generosRestringidos) throws NegocioException;
    
    public abstract List<AlbumConArtistaDTO> obtenerAlbumPorGeneroConArtista(String generoMusical, List<String> generosRestringidos) throws NegocioException;
    
    public abstract List<AlbumConArtistaDTO> obtenerAlbumPorFechaLanzamientoConArtista(String fechaLanzamiento, List<String> generosRestringidos) throws NegocioException;
    
    public abstract List<AlbumConArtistaDTO> obtenerAlbumsConNombreArtista(List<String> generosRestringidos) throws NegocioException;
               
    public abstract AlbumConArtistaDTO obtenerAlbumPorId(String albumId) throws NegocioException;
    
    public abstract String obtenerGeneroPorAlbum(String albumId) throws NegocioException;
    
    public abstract LocalDate obtenerFechaLanzamientoPorAlbum(String albumId) throws NegocioException;
    
    public abstract List<CancionConArtistaDTO> obtenerCancionesPorAlbum(String albumId) throws NegocioException;
    
    public abstract List<AlbumConArtistaDTO> buscarAlbumesPorTexto(String texto, List<String> generosRestringidos) throws NegocioException;
    
}
