/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tune.sistemabibliotecanegocio.interfaces;

import java.util.List;
import tune.sistemabibliotecadominio.entidades.Album;
import tune.sistemabibliotecanegocio.exception.NegocioException;


public interface IAlbumesBO {
    
    public abstract List<Album> obtenerTodosLosAlbums() throws NegocioException;
    
    public abstract List<Album> obtenerAlbumPorNombre(String nombre) throws NegocioException;
    
    public abstract List<Album> obtenerAlbumPorGenero(String generoMusical) throws NegocioException;
    
    public abstract List<Album> obtenerAlbumPorFechaLanzamiento(String fechaLanzamiento) throws NegocioException;
    
}
