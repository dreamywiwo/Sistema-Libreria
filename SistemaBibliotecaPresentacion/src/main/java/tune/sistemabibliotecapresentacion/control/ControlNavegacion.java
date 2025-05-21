/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tune.sistemabibliotecapresentacion.control;

import tune.sistemabibliotecadominio.entidades.Usuario;
import tune.sistemabibliotecadominio.entidades.dtos.NuevoUsuarioDTO;
import tune.sistemabibliotecanegocio.exception.NegocioException;
import tune.sistemabibliotecanegocio.implementaciones.UsuariosBO;
import tune.sistemabibliotecapersistencia.implementaciones.UsuariosDAO;
import tune.sistemabibliotecapresentacion.VentanaPrincipal;
import tune.sistemabibliotecapresentacion.VentanaRegistro;

public class ControlNavegacion {
    
    UsuariosDAO usuariosDAO = new UsuariosDAO();
    UsuariosBO usuariosBO = new UsuariosBO(usuariosDAO);
    
    public void mostrarVentanaPrincipal() {
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
        ventanaPrincipal.mostrar();
    }
    
    public void mostrarVentanaRegistro(){
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
    mostrarVentanaPrincipal(); // O mostrar mensaje de éxito
}
    
}
