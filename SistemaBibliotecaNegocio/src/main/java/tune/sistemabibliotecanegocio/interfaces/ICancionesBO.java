/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tune.sistemabibliotecanegocio.interfaces;

import java.util.List;
import tune.sistemabibliotecadominio.entidades.Cancion;
import tune.sistemabibliotecanegocio.exception.NegocioException;

/**
 *
 * @author Dana Chavez
 */
public interface ICancionesBO {
    
    public abstract List<Cancion> obtenerTodasLasCanciones() throws NegocioException;
    
    public abstract List<Cancion> obtenerCancionesPorNombre(String nombre) throws NegocioException;
    
}
