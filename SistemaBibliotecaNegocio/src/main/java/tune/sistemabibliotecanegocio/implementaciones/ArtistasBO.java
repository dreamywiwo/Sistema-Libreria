/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tune.sistemabibliotecanegocio.implementaciones;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.types.ObjectId;
import tune.sistemabibliotecadominio.dtos.AlbumConArtistaDTO;
import tune.sistemabibliotecadominio.dtos.ArtistaDTO;
import tune.sistemabibliotecadominio.dtos.CancionConArtistaDTO;
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
    public List<Artista> obtenerTodosLosArtistas(List<String> generosRestringidos) throws NegocioException {
        try {
            return artistasDAO.obtenerTodosLosArtistas(generosRestringidos);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error en negocio al obtener todos los artistas", e);
        }
    }

    @Override
    public List<Artista> obtenerPorNombre(String nombre, List<String> generosRestringidos) throws NegocioException {
        try {
            return artistasDAO.obtenerPorNombre(nombre, generosRestringidos);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error en negocio al obtener artistas por nombre", e);
        }
    }

    @Override
    public List<Artista> obtenerPorGenero(String generoMusical, List<String> generosRestringidos) throws NegocioException {
        try {
            return artistasDAO.obtenerPorGenero(generoMusical, generosRestringidos);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error en negocio al obtener artistas por género", e);
        }
    }

    @Override
    public ArtistaDTO obtenerArtistaPorId(String artistaId) throws NegocioException {
        try {
            return this.artistasDAO.obtenerArtistaPorId(artistaId);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudieron obtener el artista por id");
        }
    }

    @Override
    public List<AlbumConArtistaDTO> obtenerAlbumesPorArtista(String artistaId) throws NegocioException {
        try {
            return this.artistasDAO.obtenerAlbumesPorArtista(artistaId);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudieron obtener los albums del artista");
        }
    }

    @Override
    public List<CancionConArtistaDTO> obtenerCancionesPorArtista(String artistaId) throws NegocioException {
        try {
            return this.artistasDAO.obtenerCancionesPorArtista(artistaId);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudieron obtener las canciones del artista");
        }
    }

    @Override
    public List<Artista> obtenerArtistasPorIds(List<ObjectId> artistaIds) throws NegocioException {
        try {
            return this.artistasDAO.obtenerArtistasPorIds(artistaIds);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudieron obtener los artistas por sus ids");
        }
    }
    
    
    
}
