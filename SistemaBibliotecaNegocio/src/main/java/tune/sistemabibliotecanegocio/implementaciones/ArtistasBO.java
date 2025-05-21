/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tune.sistemabibliotecanegocio.implementaciones;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tune.sistemabibliotecadominio.entidades.Artista;
import tune.sistemabibliotecanegocio.exception.NegocioException;
import tune.sistemabibliotecanegocio.interfaces.IArtistasBO;
import tune.sistemabibliotecapersistencia.exception.PersistenciaException;
import tune.sistemabibliotecapersistencia.interfaces.IArtistasDAO;

/**
 *
 * @author Dana Chavez
 */
public class ArtistasBO implements IArtistasBO {
    
    private final IArtistasDAO artistasDAO;

    public ArtistasBO(IArtistasDAO artistasDAO) {
        this.artistasDAO = artistasDAO;
    }

    @Override
    public List<Artista> obtenerTodosLosArtistas() throws NegocioException {
        try {
            return this.artistasDAO.obtenerTodosLosArtistas();
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudieron obtener los artistas");
        }
    }

    @Override
    public List<Artista> obtenerPorNombre(String nombre) throws NegocioException {
        try {
            return this.artistasDAO.obtenerPorNombre(nombre);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudieron obtener los artistas por nombre");
        }
    }

    @Override
    public List<Artista> obtenerPorGenero(String generoMusical) throws NegocioException {
        try {
            return this.artistasDAO.obtenerPorGenero(generoMusical);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudieron obtener los artistas por genero");
        }
    }
    
    
    
}
