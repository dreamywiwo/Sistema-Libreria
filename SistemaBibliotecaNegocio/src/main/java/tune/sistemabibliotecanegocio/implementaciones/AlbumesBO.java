/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tune.sistemabibliotecanegocio.implementaciones;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tune.sistemabibliotecadominio.dtos.AlbumConArtistaDTO;
import tune.sistemabibliotecadominio.entidades.Album;
import tune.sistemabibliotecanegocio.exception.NegocioException;
import tune.sistemabibliotecanegocio.interfaces.IAlbumesBO;
import tune.sistemabibliotecapersistencia.exception.PersistenciaException;
import tune.sistemabibliotecapersistencia.interfaces.IAlbumesDAO;

/**
 *
 * @author Dana Chavez
 */
public class AlbumesBO implements IAlbumesBO {
    
    private IAlbumesDAO albumesDAO;

    public AlbumesBO(IAlbumesDAO albumesDAO) {
        this.albumesDAO = albumesDAO;
    }   

    @Override
    public List<Album> obtenerTodosLosAlbums() throws NegocioException {
        try {
            return this.albumesDAO.obtenerTodosLosAlbums();
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudieron obtener los albums");
        }
    }

    @Override
    public List<AlbumConArtistaDTO> obtenerAlbumPorNombreConArtista(String nombre) throws NegocioException {
        try {
            return this.albumesDAO.obtenerAlbumPorNombreConArtista(nombre);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudieron obtener los albums por nombre");
        }
    }

    @Override
    public List<AlbumConArtistaDTO> obtenerAlbumPorGeneroConArtista(String generoMusical) throws NegocioException {
        try {
            return this.albumesDAO.obtenerAlbumPorGeneroConArtista(generoMusical);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudieron obtener los albums por genero");
        }
    }

    @Override
    public List<AlbumConArtistaDTO> obtenerAlbumPorFechaLanzamientoConArtista(String fechaLanzamiento) throws NegocioException {
        try {
            return this.albumesDAO.obtenerAlbumPorFechaLanzamientoConArtista(fechaLanzamiento);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudieron obtener los albums por fecha de lanzamiento");
        }
    }   

    @Override
    public List<AlbumConArtistaDTO> obtenerAlbumsConNombreArtista() throws NegocioException {
        try {
            return this.albumesDAO.obtenerAlbumsConNombreArtista();
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudieron obtener los albums y sus artistas");
        }
    }
}
