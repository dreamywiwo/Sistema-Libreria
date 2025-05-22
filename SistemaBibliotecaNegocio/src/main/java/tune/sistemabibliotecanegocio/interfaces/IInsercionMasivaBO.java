/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tune.sistemabibliotecanegocio.interfaces;

import java.util.List;
import tune.sistemabibliotecanegocio.exception.NegocioException;

/**
 *
 * @author Dana Chavez
 */
public interface IInsercionMasivaBO {
    
    public abstract void insertarArtistasMasivamente() throws NegocioException;
    public List<String> obtenerGenerosUnicos() throws NegocioException;
    
}
