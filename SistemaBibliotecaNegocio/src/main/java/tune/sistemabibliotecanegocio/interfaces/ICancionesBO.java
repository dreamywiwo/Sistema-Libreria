/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tune.sistemabibliotecanegocio.interfaces;

import java.util.List;
import tune.sistemabibliotecadominio.dtos.CancionConArtistaDTO;
import tune.sistemabibliotecadominio.entidades.Cancion;
import tune.sistemabibliotecanegocio.exception.NegocioException;

public interface ICancionesBO {
    
    public abstract List<Cancion> obtenerTodasLasCanciones(List<String> generosRestringidos) throws NegocioException;
    
    public abstract List<Cancion> obtenerCancionesPorNombre(String nombre, List<String> generosRestringidos) throws NegocioException;
    
    public abstract List<CancionConArtistaDTO> obtenerTodasLasCancionesConNombreArtista(List<String> generosRestringidos) throws NegocioException;
    
    public abstract List<CancionConArtistaDTO> obtenerCancionesPorNombreConArtista(String nombre) throws NegocioException;
    
}
