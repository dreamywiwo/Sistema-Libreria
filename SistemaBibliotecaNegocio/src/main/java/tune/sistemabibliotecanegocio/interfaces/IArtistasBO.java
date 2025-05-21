/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tune.sistemabibliotecanegocio.interfaces;

import java.util.List;
import tune.sistemabibliotecadominio.entidades.Artista;
import tune.sistemabibliotecanegocio.exception.NegocioException;

/**
 *
 * @author Dana Chavez
 */
public interface IArtistasBO {   
        
    public abstract List<Artista> obtenerTodosLosArtistas() throws NegocioException;
    
    public abstract List<Artista> obtenerPorNombre(String nombre) throws NegocioException;
    
    public abstract List<Artista> obtenerPorGenero(String generoMusical) throws NegocioException;
    
}
