/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tune.sistemabibliotecapresentacion.control;

import tune.sistemabibliotecadominio.entidades.Usuario;
import tune.sistemabibliotecadominio.dtos.NuevoUsuarioDTO;
import tune.sistemabibliotecanegocio.exception.NegocioException;
import tune.sistemabibliotecanegocio.implementaciones.AlbumesBO;
import tune.sistemabibliotecanegocio.implementaciones.ArtistasBO;
import tune.sistemabibliotecanegocio.implementaciones.InsercionMasivaBO;
import tune.sistemabibliotecanegocio.implementaciones.UsuariosBO;
import tune.sistemabibliotecapersistencia.daos.AlbumesDAO;
import tune.sistemabibliotecapersistencia.daos.ArtistasDAO;
import tune.sistemabibliotecapersistencia.daos.InsercionMasivaDAO;
import tune.sistemabibliotecapersistencia.daos.UsuariosDAO;
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
    
    
    public void mostrarVentanaPrincipal() throws NegocioException {
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(insercionMasivaBO, artistasBO, albumesBO, this, usuariosBO);
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
   
    public Usuario obtenerUsuarioActual() throws NegocioException {
        Usuario usuarioActual = usuariosBO.obtenerUsuarioActual();
        return usuarioActual;
    }
}
