/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tune.sistemabibliotecanegocio.interfaces;

import java.util.List;
import tune.sistemabibliotecadominio.dtos.AlbumConArtistaDTO;
import tune.sistemabibliotecadominio.dtos.ArtistaDTO;
import tune.sistemabibliotecadominio.dtos.CancionConArtistaDTO;
import tune.sistemabibliotecadominio.entidades.Artista;
import tune.sistemabibliotecanegocio.exception.NegocioException;

public interface IArtistasBO {   
        
    public abstract List<Artista> obtenerTodosLosArtistas() throws NegocioException;
    
    public abstract List<Artista> obtenerPorNombre(String nombre) throws NegocioException;
    
    public abstract List<Artista> obtenerPorGenero(String generoMusical) throws NegocioException;
    
    public abstract ArtistaDTO obtenerArtistaPorId(String artistaId) throws NegocioException;
    
    public abstract List<AlbumConArtistaDTO> obtenerAlbumesPorArtista(String artistaId) throws NegocioException;
    
    public abstract List<CancionConArtistaDTO> obtenerCancionesPorArtista(String artistaId) throws NegocioException;

    
}
