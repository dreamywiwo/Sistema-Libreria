/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tune.sistemabibliotecanegocio.interfaces;

import java.util.List;
import tune.sistemabibliotecadominio.dtos.AlbumConArtistaDTO;
import tune.sistemabibliotecadominio.entidades.Album;
import tune.sistemabibliotecanegocio.exception.NegocioException;


public interface IAlbumesBO {
    
    public abstract List<Album> obtenerTodosLosAlbums() throws NegocioException;
    
    public abstract List<AlbumConArtistaDTO> obtenerAlbumPorNombreConArtista(String nombre) throws NegocioException;
    
    public abstract List<AlbumConArtistaDTO> obtenerAlbumPorGeneroConArtista(String generoMusical) throws NegocioException;
    
    public abstract List<AlbumConArtistaDTO> obtenerAlbumPorFechaLanzamientoConArtista(String fechaLanzamiento) throws NegocioException;
    
    public abstract List<AlbumConArtistaDTO> obtenerAlbumsConNombreArtista() throws NegocioException;
    
}
