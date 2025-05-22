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
    public List<Album> obtenerTodosLosAlbums(List<String> generosRestringidos) throws NegocioException {
        try {
            return this.albumesDAO.obtenerTodosLosAlbums(generosRestringidos);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudieron obtener los albums");
        }
    }

    @Override
    public List<AlbumConArtistaDTO> obtenerAlbumPorNombreConArtista(String nombre, List<String> generosRestringidos) throws NegocioException {
        try {
            return this.albumesDAO.obtenerAlbumPorNombreConArtista(nombre, generosRestringidos);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudieron obtener los albums por nombre");
        }
    }

    @Override
    public List<AlbumConArtistaDTO> obtenerAlbumPorGeneroConArtista(String generoMusical, List<String> generosRestringidos) throws NegocioException {
        try {
            return this.albumesDAO.obtenerAlbumPorGeneroConArtista(generoMusical, generosRestringidos);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudieron obtener los albums por género");
        }
    }

    @Override
    public List<AlbumConArtistaDTO> obtenerAlbumPorFechaLanzamientoConArtista(String fechaLanzamiento, List<String> generosRestringidos) throws NegocioException {
        try {
            return this.albumesDAO.obtenerAlbumPorFechaLanzamientoConArtista(fechaLanzamiento, generosRestringidos);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudieron obtener los albums por fecha de lanzamiento");
        }
    }

    @Override
    public List<AlbumConArtistaDTO> obtenerAlbumsConNombreArtista(List<String> generosRestringidos) throws NegocioException {
        try {
            return this.albumesDAO.obtenerAlbumsConNombreArtista(generosRestringidos);
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
            throw new NegocioException("No se pudieron obtener las canciones del álbum");
        }
    }

    @Override
    public List<AlbumConArtistaDTO> buscarAlbumesPorTexto(String texto, List<String> generosRestringidos) throws NegocioException {
        try {
            return this.albumesDAO.buscarAlbumesPorTexto(texto, generosRestringidos);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudieron obtener los álbumes por texto");
        }
    }
}
