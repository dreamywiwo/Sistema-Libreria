/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tune.sistemabibliotecapresentacion.control;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tune.sistemabibliotecadominio.entidades.Usuario;
import tune.sistemabibliotecadominio.dtos.NuevoUsuarioDTO;
import tune.sistemabibliotecanegocio.exception.NegocioException;
import tune.sistemabibliotecanegocio.implementaciones.AlbumesBO;
import tune.sistemabibliotecanegocio.implementaciones.ArtistasBO;
import tune.sistemabibliotecanegocio.implementaciones.CancionesBO;
import tune.sistemabibliotecanegocio.implementaciones.InsercionMasivaBO;
import tune.sistemabibliotecanegocio.implementaciones.UsuariosBO;
import tune.sistemabibliotecapersistencia.daos.AlbumesDAO;
import tune.sistemabibliotecapersistencia.daos.ArtistasDAO;
import tune.sistemabibliotecapersistencia.daos.CancionesDAO;
import tune.sistemabibliotecapersistencia.daos.InsercionMasivaDAO;
import tune.sistemabibliotecapersistencia.daos.UsuariosDAO;
import tune.sistemabibliotecapresentacion.PanelPerfilUsuario;
import tune.sistemabibliotecapresentacion.PanelAlbumes;
import tune.sistemabibliotecapresentacion.PanelArtistas;
import tune.sistemabibliotecapresentacion.PanelCanciones;
import tune.sistemabibliotecapresentacion.VentanaAlbumDetalle;
import tune.sistemabibliotecapresentacion.VentanaArtistaDetalle;
import tune.sistemabibliotecapresentacion.VentanaPrincipal;
import tune.sistemabibliotecapresentacion.VentanaRegistro;

public class ControlNavegacion {

    UsuariosDAO usuariosDAO = new UsuariosDAO();
    UsuariosBO usuariosBO = new UsuariosBO(usuariosDAO);
    
    InsercionMasivaDAO insercionMasivaDAO = new InsercionMasivaDAO();
    InsercionMasivaBO insercionMasivaBO = new InsercionMasivaBO(insercionMasivaDAO);
    
    AlbumesDAO albumesDAO = new AlbumesDAO();
    AlbumesBO albumesBO = new AlbumesBO(albumesDAO);
    
    ArtistasDAO artistasDAO = new ArtistasDAO();
    ArtistasBO artistasBO = new ArtistasBO(artistasDAO);
    
    CancionesDAO cancionesDAO = new CancionesDAO();
    CancionesBO cancionesBO = new CancionesBO(cancionesDAO);
    
    private PanelArtistas panelArtistas;
    private PanelAlbumes panelAlbumes;
    private PanelCanciones panelCanciones;
    
    
    
    public void mostrarVentanaPrincipal() throws NegocioException {
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(insercionMasivaBO, artistasBO, albumesBO, cancionesBO, this, usuariosBO);
        ventanaPrincipal.mostrar();
    }

    public void mostrarVentanaRegistro() {
        VentanaRegistro ventanaRegistro = new VentanaRegistro(this);
        ventanaRegistro.mostrar();
    }

    public void iniciarSesion(NuevoUsuarioDTO usuarioDTO) throws NegocioException {
        Usuario usuario = usuariosBO.iniciarSesion(usuarioDTO);
        if (usuario != null) {
            mostrarVentanaPrincipal();
        }
    }

    public void registrarUsuario(NuevoUsuarioDTO usuarioDTO) throws NegocioException {
        usuariosBO.registrarUsuario(usuarioDTO);
    }
    
    public void mostrarVentanaArtistaDetalle(String idArtista) throws NegocioException{
        List<String> generos = insercionMasivaBO.obtenerGenerosUnicos();

        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(insercionMasivaBO, artistasBO, albumesBO, cancionesBO, this, usuariosBO);
        PanelPerfilUsuario panelPerfilUsuario = new PanelPerfilUsuario(this, ventanaPrincipal, usuariosBO, generos, artistasBO, albumesBO, cancionesBO);
        VentanaArtistaDetalle ventanaArtista = new VentanaArtistaDetalle(artistasBO, idArtista, usuariosBO, this, panelPerfilUsuario, albumesBO);
        ventanaArtista.mostrar();
    }
    
    public void mostrarVentanaAlbumDetalle(String idArtista) throws NegocioException{
        List<String> generos = insercionMasivaBO.obtenerGenerosUnicos();
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(insercionMasivaBO, artistasBO, albumesBO, cancionesBO, this, usuariosBO);
        PanelPerfilUsuario panelPerfilUsuario = new PanelPerfilUsuario(this, ventanaPrincipal, usuariosBO, generos, artistasBO, albumesBO, cancionesBO);
        VentanaAlbumDetalle ventanaAlbum = new VentanaAlbumDetalle(albumesBO, idArtista, usuariosBO, this, panelPerfilUsuario);
        ventanaAlbum.mostrar();
    }

   
    public Usuario obtenerUsuarioActual() throws NegocioException {
        Usuario usuarioActual = usuariosBO.obtenerUsuarioActual();
        return usuarioActual;
    }
    
    public void actualizarPaneles() throws NegocioException{
        panelArtistas.cargarArtistasPorGenero();
        panelAlbumes.cargarAlbumes();
        panelCanciones.cargarCanciones();
    }
    
    public void setPanelArtistas(PanelArtistas panelArtistas) {
        this.panelArtistas = panelArtistas;
    }

    public void setPanelAlbumes(PanelAlbumes panelAlbumes) {
        this.panelAlbumes = panelAlbumes;
    }

    public void setPanelCanciones(PanelCanciones panelCanciones) {
        this.panelCanciones = panelCanciones;
    } 
}
