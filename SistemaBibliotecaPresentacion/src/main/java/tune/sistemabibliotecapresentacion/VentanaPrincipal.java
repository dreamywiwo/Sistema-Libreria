/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tune.sistemabibliotecapresentacion;

import java.awt.CardLayout;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import tune.sistemabibliotecadominio.dtos.CancionConArtistaDTO;
import tune.sistemabibliotecanegocio.exception.NegocioException;
import tune.sistemabibliotecanegocio.interfaces.IAlbumesBO;
import tune.sistemabibliotecanegocio.interfaces.IArtistasBO;
import tune.sistemabibliotecanegocio.interfaces.ICancionesBO;
import tune.sistemabibliotecanegocio.interfaces.IInsercionMasivaBO;
import tune.sistemabibliotecanegocio.interfaces.IUsuariosBO;
import tune.sistemabibliotecapresentacion.control.ControlNavegacion;

/**
 *
 * @author Dana Chavez
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    private IInsercionMasivaBO insercionMasivaBO;
    private IArtistasBO artistasBO;
    private IAlbumesBO albumesBO;
    private IUsuariosBO usuariosBO;
    private ICancionesBO cancionesBO;
    private CancionConArtistaDTO cancion;
    private static final Logger LOG = Logger.getLogger(VentanaPrincipal.class.getName());
    ControlNavegacion control;

    private PanelArtistas panelArtistas;
    private PanelAlbumes panelAlbumes;
    private PanelCanciones panelCanciones;
    private PanelPrincipal panelPrincipal;
    private PanelPerfilUsuario panelPerfilUsuario;
    private List<String> generos;

    public VentanaPrincipal(IInsercionMasivaBO insercionMasivaBO, IArtistasBO artistasBO, IAlbumesBO albumesBO, ICancionesBO cancionesBO, ControlNavegacion control, IUsuariosBO usuariosBO) throws NegocioException {
        initComponents();
        this.insercionMasivaBO = insercionMasivaBO;
        this.artistasBO = artistasBO;
        this.albumesBO = albumesBO;
        this.cancionesBO = cancionesBO;
        this.control = control;
        this.usuariosBO = usuariosBO;
        this.cancion = cancion;
        this.generos = insercionMasivaBO.obtenerGenerosUnicos();
        setLocationRelativeTo(null);

        // Inicializar los paneles
        panelPerfilUsuario = new PanelPerfilUsuario(control, this, usuariosBO, generos, artistasBO, albumesBO, cancionesBO);
        panelArtistas = new PanelArtistas(artistasBO, usuariosBO, control, panelPerfilUsuario);
        panelAlbumes = new PanelAlbumes(albumesBO, usuariosBO, control, panelPerfilUsuario);
        panelCanciones = new PanelCanciones(cancionesBO, usuariosBO, control, panelPerfilUsuario);
        panelPrincipal = new PanelPrincipal(artistasBO, albumesBO, cancionesBO, control, cancion, panelPerfilUsuario, usuariosBO);
        

        control.setPanelArtistas(panelArtistas);
        control.setPanelAlbumes(panelAlbumes);
        control.setPanelCanciones(panelCanciones);
        control.setPanelPerfilUsuario(panelPerfilUsuario);

        // Establecer CardLayout para jPanelPaneles
        jPanelPaneles.setLayout(new CardLayout());
        jPanelPaneles.setOpaque(false);

        // Agregar los paneles al contenedor con un nombre clave
        jPanelPaneles.add(panelArtistas, "Artistas");
        jPanelPaneles.add(panelAlbumes, "Albumes");
        jPanelPaneles.add(panelCanciones, "Canciones");
        jPanelPaneles.add(panelPrincipal, "Principal");
        jPanelPaneles.add(panelPerfilUsuario, "Perfil");

        mostrarPanel("Principal");

    }

    private void agregarArtistasMasivamente() {
        try {
            insercionMasivaBO.insertarArtistasMasivamente();
        } catch (NegocioException ex) {
            LOG.severe("No se pudieron agregar los artistas: " + ex.getMessage());
            JOptionPane.showMessageDialog(this,
                    "Error al agregar artistas: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarPanel(String nombrePanel) {
        CardLayout cl = (CardLayout) jPanelPaneles.getLayout();
        cl.show(jPanelPaneles, nombrePanel);
    }

    public void mostrar() {
        setVisible(true);
    }

    public void cerrar() {
        setVisible(false);
        dispose();
    }

    public void setGeneros() throws NegocioException {
        this.generos = insercionMasivaBO.obtenerGenerosUnicos();
        if (panelPerfilUsuario != null) {
            panelPerfilUsuario = null;
            panelPerfilUsuario = new PanelPerfilUsuario(control, this, usuariosBO, generos, artistasBO, albumesBO, cancionesBO);
            control.setPanelPerfilUsuario(panelPerfilUsuario);
        } else {
            panelPerfilUsuario = new PanelPerfilUsuario(control, this, usuariosBO, generos, artistasBO, albumesBO, cancionesBO);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonIcono = new javax.swing.JButton();
        jButtonHome = new javax.swing.JButton();
        jButtonAgregarArtistas = new javax.swing.JButton();
        jButtonArtistas = new javax.swing.JButton();
        jButtonAlbumes = new javax.swing.JButton();
        jButtonCanciones = new javax.swing.JButton();
        jButtonFavoritos = new javax.swing.JButton();
        jPanelPaneles = new javax.swing.JPanel();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BotonPerfil.png"))); // NOI18N
        jButtonIcono.setContentAreaFilled(false);
        jButtonIcono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIconoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonIcono, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 30, 40, 40));

        jButtonHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonHome.png"))); // NOI18N
        jButtonHome.setBorder(null);
        jButtonHome.setContentAreaFilled(false);
        jButtonHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHomeActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, -1));

        jButtonAgregarArtistas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonAgregar.png"))); // NOI18N
        jButtonAgregarArtistas.setBorder(null);
        jButtonAgregarArtistas.setContentAreaFilled(false);
        jButtonAgregarArtistas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAgregarArtistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarArtistasActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAgregarArtistas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 60, -1));

        jButtonArtistas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonArtistas.png"))); // NOI18N
        jButtonArtistas.setBorder(null);
        jButtonArtistas.setContentAreaFilled(false);
        jButtonArtistas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonArtistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonArtistasActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonArtistas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 60, 70));

        jButtonAlbumes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonAlbumes.png"))); // NOI18N
        jButtonAlbumes.setBorder(null);
        jButtonAlbumes.setContentAreaFilled(false);
        jButtonAlbumes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAlbumes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlbumesActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAlbumes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 60, 70));

        jButtonCanciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonCanciones.png"))); // NOI18N
        jButtonCanciones.setBorder(null);
        jButtonCanciones.setContentAreaFilled(false);
        jButtonCanciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCanciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancionesActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCanciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 100, -1));

        jButtonFavoritos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonFavoritos.png"))); // NOI18N
        jButtonFavoritos.setBorder(null);
        jButtonFavoritos.setContentAreaFilled(false);
        jButtonFavoritos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButtonFavoritos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 60, -1));
        getContentPane().add(jPanelPaneles, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 1010, 750));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoVentanaPrincipal.png"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHomeActionPerformed
        mostrarPanel("Principal");
    }//GEN-LAST:event_jButtonHomeActionPerformed

    private void jButtonAgregarArtistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarArtistasActionPerformed
        agregarArtistasMasivamente();
        panelArtistas.mostrarArtistas(panelArtistas.cargarArtistasExterior());
        panelAlbumes.mostrarAlbumes(panelAlbumes.cargarAlbumesExterior());
        panelCanciones.mostrarCanciones(panelCanciones.cargarCancionesExterior());
        panelArtistas.cargarArtistas();
        panelAlbumes.cargarAlbumes();
        panelCanciones.cargarCanciones();
        try {
            setGeneros();
        } catch (NegocioException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonAgregarArtistasActionPerformed

    private void jButtonAlbumesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlbumesActionPerformed
        mostrarPanel("Albumes");
    }//GEN-LAST:event_jButtonAlbumesActionPerformed

    private void jButtonArtistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonArtistasActionPerformed
        mostrarPanel("Artistas");
    }//GEN-LAST:event_jButtonArtistasActionPerformed

    private void jButtonCancionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancionesActionPerformed
        mostrarPanel("Canciones");
    }//GEN-LAST:event_jButtonCancionesActionPerformed

    private void jButtonIconoActionPerformed(java.awt.event.ActionEvent evt) {
        mostrarPanel("Perfil");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregarArtistas;
    private javax.swing.JButton jButtonAlbumes;
    private javax.swing.JButton jButtonArtistas;
    private javax.swing.JButton jButtonCanciones;
    private javax.swing.JButton jButtonFavoritos;
    private javax.swing.JButton jButtonHome;
    private javax.swing.JButton jButtonIcono;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JPanel jPanelPaneles;
    // End of variables declaration//GEN-END:variables
}
