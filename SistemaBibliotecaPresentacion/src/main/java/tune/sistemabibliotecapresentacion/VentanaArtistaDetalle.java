/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tune.sistemabibliotecapresentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import tune.sistemabibliotecadominio.dtos.AlbumConArtistaDTO;
import tune.sistemabibliotecadominio.dtos.ArtistaDTO;
import tune.sistemabibliotecadominio.dtos.CancionConArtistaDTO;
import tune.sistemabibliotecadominio.dtos.IntegranteDTO;
import tune.sistemabibliotecanegocio.interfaces.IAlbumesBO;
import tune.sistemabibliotecanegocio.interfaces.IArtistasBO;
import tune.sistemabibliotecanegocio.interfaces.IUsuariosBO;
import tune.sistemabibliotecapresentacion.control.ControlNavegacion;
import tune.sistemabibliotecapresentacion.formatos.PanelAlbumItem;
import tune.sistemabibliotecapresentacion.formatos.PanelCancionItem;
import tune.sistemabibliotecapresentacion.formatos.PanelIntegranteItem;
import tune.sistemabibliotecapresentacion.utils.FontManager;

/**
 *
 * @author Dana Chavez
 */
public class VentanaArtistaDetalle extends javax.swing.JFrame {

    private String artistaId;
    private IArtistasBO artistasBO;
    private IUsuariosBO usuariosBO;
    private ControlNavegacion control;
    FontManager fontManager = new FontManager();
    private PanelPerfilUsuario panelPerfilUsuario;
    IAlbumesBO albumesBO;
    
    public VentanaArtistaDetalle(IArtistasBO artistasBO, String artistaId, IUsuariosBO usuariosBO, ControlNavegacion control, PanelPerfilUsuario panelPerfilUsuario, IAlbumesBO albumesBO) {
        initComponents();
        this.artistasBO = artistasBO;
        this.artistaId = artistaId;
        this.usuariosBO = usuariosBO;
        this.control = control;
        this.panelPerfilUsuario = panelPerfilUsuario;
        this.albumesBO = albumesBO;
        setLocationRelativeTo(null);
        
        jPanelInformacion.setOpaque(false);
        jPanelCanciones.setOpaque(false);
        jPanelAlbumes.setOpaque(false);
        jPanelIntegrantes.setOpaque(false);
        jPanelNombre.setOpaque(false);
        
        jScrollPaneCanciones.setOpaque(false);
        jScrollPaneAlbumes.setOpaque(false);
        jScrollPaneIntegrantes.setOpaque(false);
        jScrollPaneCanciones.getViewport().setOpaque(false);
        jScrollPaneAlbumes.getViewport().setOpaque(false);
        jScrollPaneIntegrantes.getViewport().setOpaque(false);

        jScrollPaneCanciones.setBorder(null);
        jScrollPaneAlbumes.setBorder(null);
        jScrollPaneIntegrantes.setBorder(null);

        cargarInformacionArtista();
    }
    
    private void cargarInformacionArtista() {
        try {

            ArtistaDTO artista = artistasBO.obtenerArtistaPorId(artistaId);

            // Mostrar nombre
            jPanelNombre.removeAll();
            JLabel lblNombre = new JLabel(artista.getNombre());
            lblNombre.setFont(fontManager.getAfacadBold(60f));
            lblNombre.setForeground(Color.WHITE);
            lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
            lblNombre.setAlignmentX(Component.CENTER_ALIGNMENT);

            jPanelNombre.setLayout(new BorderLayout());
            jPanelNombre.add(lblNombre, BorderLayout.CENTER);
            jPanelNombre.revalidate();
            jPanelNombre.repaint();

            // Mostrar info 
            jPanelInformacion.removeAll();
            jPanelInformacion.setLayout(new BoxLayout(jPanelInformacion, BoxLayout.Y_AXIS));

            // Imagen
            JLabel lblImagen = new JLabel();
            try {
                ImageIcon icon = new ImageIcon(new URL(artista.getImagen()));
                Image img = icon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
                lblImagen.setIcon(new ImageIcon(img));
            } catch (Exception e) {
                lblImagen.setText("🎤");
                lblImagen.setFont(new Font("SansSerif", Font.PLAIN, 100));
                lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
            }
            lblImagen.setAlignmentX(Component.CENTER_ALIGNMENT);
            jPanelInformacion.add(lblImagen);

            // Género
            JLabel lblGenero = new JLabel("Género: " + (artista.getGeneroMusical() != null ? artista.getGeneroMusical() : "N/A"));
            lblGenero.setForeground(Color.WHITE);
            lblGenero.setFont(fontManager.getAfacadMedium(20f));
            lblGenero.setAlignmentX(Component.CENTER_ALIGNMENT);
            jPanelInformacion.add(Box.createVerticalStrut(10));
            jPanelInformacion.add(lblGenero);

            jPanelInformacion.revalidate();
            jPanelInformacion.repaint();

            // Mostrar álbumes
            jPanelAlbumes.removeAll();
            jPanelAlbumes.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15));

            List<AlbumConArtistaDTO> albumes = artistasBO.obtenerAlbumesPorArtista(artistaId);
            for (AlbumConArtistaDTO album : albumes) {
                PanelAlbumItem panelAlbum = new PanelAlbumItem(album, usuariosBO, control, panelPerfilUsuario);
                jPanelAlbumes.add(panelAlbum);
            }
            jPanelAlbumes.revalidate();
            jPanelAlbumes.repaint();

            // Mostrar canciones 
            jPanelCanciones.removeAll();
            jPanelCanciones.setLayout(new BoxLayout(jPanelCanciones, BoxLayout.Y_AXIS));

            List<CancionConArtistaDTO> canciones = artistasBO.obtenerCancionesPorArtista(artistaId);
            int indice = 1;
            for (CancionConArtistaDTO cancion : canciones) {
                PanelCancionItem panelCancion = new PanelCancionItem(cancion, indice, usuariosBO, control, panelPerfilUsuario);
                jPanelCanciones.add(panelCancion);
                indice++;
            }
            jPanelCanciones.revalidate();
            jPanelCanciones.repaint();

            // Mostrar integrantes
            List<IntegranteDTO> integrantes = artista.getIntegrantes();
            jPanelIntegrantes.removeAll();

            if (integrantes != null && !integrantes.isEmpty()) {
                jPanelIntegrantes.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15));
                for (IntegranteDTO integrante : integrantes) {
                    PanelIntegranteItem panelIntegrante = new PanelIntegranteItem(integrante);
                    jPanelIntegrantes.add(panelIntegrante);
                }
            }
            jPanelIntegrantes.revalidate();
            jPanelIntegrantes.repaint();

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error cargando la información del artista.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void mostrar() {
        setVisible(true);
    }

    public void cerrar() {
        setVisible(false);
        dispose();
    }

    
    public void mostrarPanelAñadirAlbumFlotante() {
    try {
        JPanel fondoOscuro = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.setColor(new Color(0, 0, 0, 150));
                g.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            }
        };
        fondoOscuro.setOpaque(false);
        fondoOscuro.setLayout(new GridBagLayout());

        PanelAñadirAlbum panelAñadirAlbum = new PanelAñadirAlbum(albumesBO, control, artistaId);
        panelAñadirAlbum.setOpaque(true);
        panelAñadirAlbum.setPreferredSize(new Dimension(860, 500));

        fondoOscuro.add(panelAñadirAlbum);

        JDialog dialogo = new JDialog((Frame) null, Dialog.ModalityType.APPLICATION_MODAL);
        dialogo.setUndecorated(true);
        dialogo.setBackground(new Color(0, 0, 0, 0));
        dialogo.setContentPane(fondoOscuro);
        dialogo.pack();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - dialogo.getWidth()) / 2;
        int y = (screenSize.height - dialogo.getHeight()) / 2;
        dialogo.setLocation(x, y);

        dialogo.setVisible(true);

    } catch (Exception e) {
        e.printStackTrace();
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

        jPanelInformacion = new javax.swing.JPanel();
        jScrollPaneCanciones = new javax.swing.JScrollPane();
        jPanelCanciones = new javax.swing.JPanel();
        jScrollPaneAlbumes = new javax.swing.JScrollPane();
        jPanelAlbumes = new javax.swing.JPanel();
        jScrollPaneIntegrantes = new javax.swing.JScrollPane();
        jPanelIntegrantes = new javax.swing.JPanel();
        jPanelNombre = new javax.swing.JPanel();
        jButtonCerrar = new javax.swing.JButton();
        jButtonAñadirAlbum = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanelInformacionLayout = new javax.swing.GroupLayout(jPanelInformacion);
        jPanelInformacion.setLayout(jPanelInformacionLayout);
        jPanelInformacionLayout.setHorizontalGroup(
            jPanelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        jPanelInformacionLayout.setVerticalGroup(
            jPanelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        getContentPane().add(jPanelInformacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 190, 300, 300));

        jScrollPaneCanciones.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        javax.swing.GroupLayout jPanelCancionesLayout = new javax.swing.GroupLayout(jPanelCanciones);
        jPanelCanciones.setLayout(jPanelCancionesLayout);
        jPanelCancionesLayout.setHorizontalGroup(
            jPanelCancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 684, Short.MAX_VALUE)
        );
        jPanelCancionesLayout.setVerticalGroup(
            jPanelCancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 504, Short.MAX_VALUE)
        );

        jScrollPaneCanciones.setViewportView(jPanelCanciones);

        getContentPane().add(jScrollPaneCanciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 690, 430));

        jScrollPaneAlbumes.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        javax.swing.GroupLayout jPanelAlbumesLayout = new javax.swing.GroupLayout(jPanelAlbumes);
        jPanelAlbumes.setLayout(jPanelAlbumesLayout);
        jPanelAlbumesLayout.setHorizontalGroup(
            jPanelAlbumesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 688, Short.MAX_VALUE)
        );
        jPanelAlbumesLayout.setVerticalGroup(
            jPanelAlbumesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 222, Short.MAX_VALUE)
        );

        jScrollPaneAlbumes.setViewportView(jPanelAlbumes);

        getContentPane().add(jScrollPaneAlbumes, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 610, 690, 220));

        javax.swing.GroupLayout jPanelIntegrantesLayout = new javax.swing.GroupLayout(jPanelIntegrantes);
        jPanelIntegrantes.setLayout(jPanelIntegrantesLayout);
        jPanelIntegrantesLayout.setHorizontalGroup(
            jPanelIntegrantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );
        jPanelIntegrantesLayout.setVerticalGroup(
            jPanelIntegrantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 312, Short.MAX_VALUE)
        );

        jScrollPaneIntegrantes.setViewportView(jPanelIntegrantes);

        getContentPane().add(jScrollPaneIntegrantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 500, 300, 330));

        javax.swing.GroupLayout jPanelNombreLayout = new javax.swing.GroupLayout(jPanelNombre);
        jPanelNombre.setLayout(jPanelNombreLayout);
        jPanelNombreLayout.setHorizontalGroup(
            jPanelNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        jPanelNombreLayout.setVerticalGroup(
            jPanelNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        getContentPane().add(jPanelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 900, 130));

        jButtonCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BotonCerrar.png"))); // NOI18N
        jButtonCerrar.setBorderPainted(false);
        jButtonCerrar.setContentAreaFilled(false);
        jButtonCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 30, 40, 40));

        jButtonAñadirAlbum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/AñadirArtistaBoton.png"))); // NOI18N
        jButtonAñadirAlbum.setBorderPainted(false);
        jButtonAñadirAlbum.setContentAreaFilled(false);
        jButtonAñadirAlbum.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAñadirAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAñadirAlbumActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAñadirAlbum, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 100, -1, -1));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoSimple.png"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed
        cerrar();
    }//GEN-LAST:event_jButtonCerrarActionPerformed

    private void jButtonAñadirAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAñadirAlbumActionPerformed
        mostrarPanelAñadirAlbumFlotante();
    }//GEN-LAST:event_jButtonAñadirAlbumActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAñadirAlbum;
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JPanel jPanelAlbumes;
    private javax.swing.JPanel jPanelCanciones;
    private javax.swing.JPanel jPanelInformacion;
    private javax.swing.JPanel jPanelIntegrantes;
    private javax.swing.JPanel jPanelNombre;
    private javax.swing.JScrollPane jScrollPaneAlbumes;
    private javax.swing.JScrollPane jScrollPaneCanciones;
    private javax.swing.JScrollPane jScrollPaneIntegrantes;
    // End of variables declaration//GEN-END:variables
}
