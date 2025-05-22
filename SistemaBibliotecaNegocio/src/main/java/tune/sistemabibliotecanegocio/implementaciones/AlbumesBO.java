/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tune.sistemabibliotecanegocio.implementaciones;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tune.sistemabibliotecadominio.dtos.AlbumConArtistaDTO;
import tune.sistemabibliotecadominio.dtos.CancionConArtistaDTO;
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

    @Override
    public AlbumConArtistaDTO obtenerAlbumPorId(String albumId) throws NegocioException {
        try {
            return this.albumesDAO.obtenerAlbumPorId(albumId);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo obtener el id del album");
        }
    }

    @Override
    public String obtenerGeneroPorAlbum(String albumId) throws NegocioException {
        try {
            return this.albumesDAO.obtenerGeneroPorAlbum(albumId);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo obtener el genero del album");
        }
    }

    @Override
    public LocalDate obtenerFechaLanzamientoPorAlbum(String albumId) throws NegocioException {
        try {
            return this.albumesDAO.obtenerFechaLanzamientoPorAlbum(albumId);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo obtener la fecha de lanzamiento del album");
        }
    }

    @Override
    public List<CancionConArtistaDTO> obtenerCancionesPorAlbum(String albumId) throws NegocioException {
        try {
            return this.albumesDAO.obtenerCancionesPorAlbum(albumId);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudieron obtener las canciones del album");
        }
    }

    @Override
    public List<AlbumConArtistaDTO> buscarAlbumesPorTexto(String texto) throws NegocioException {
        try {
            return this.albumesDAO.buscarAlbumesPorTexto(texto);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudieron obtener los albums");
        }
    }
}
