/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tune.sistemabibliotecapresentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import tune.sistemabibliotecadominio.dtos.AlbumConArtistaDTO;
import tune.sistemabibliotecadominio.dtos.CancionConArtistaDTO;
import tune.sistemabibliotecanegocio.interfaces.IAlbumesBO;
import tune.sistemabibliotecapresentacion.control.ControlNavegacion;
import tune.sistemabibliotecapresentacion.formatos.PanelCancionItem;

/**
 *
 * @author Dana Chavez
 */
public class VentanaAlbumDetalle extends javax.swing.JFrame {

    private String albumId;
    private IAlbumesBO albumesBO;
    private ControlNavegacion control;
    
    public VentanaAlbumDetalle(IAlbumesBO albumesBO, String albumId, ControlNavegacion control) {
        initComponents();
        this.albumesBO = albumesBO;
        this.albumId = albumId;
        this.control = control;
        setLocationRelativeTo(null);
        
        jPanelCanciones.setOpaque(false);
        jPanelInfo.setOpaque(false);
        jPanelNombre.setOpaque(false);
        jScrollPaneCanciones.setOpaque(false);
        jScrollPaneCanciones.getViewport().setOpaque(false);
        jScrollPaneCanciones.setBorder(null);
        
        cargarInformacionAlbum();
    }
    private void cargarInformacionAlbum() {
        try {
            AlbumConArtistaDTO album = albumesBO.obtenerAlbumPorId(albumId);

            // Mostrar nombre e imagen 
            jPanelNombre.removeAll();
            JLabel lblImagen = new JLabel();
            try {
                ImageIcon icon = new ImageIcon(new URL(album.getUrlImagenAlbum()));
                Image img = icon.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
                lblImagen.setIcon(new ImageIcon(img));
            } catch (Exception ex) {
                lblImagen.setText("🎵");
                lblImagen.setFont(new Font("SansSerif", Font.PLAIN, 100));
                lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
            }
            JLabel lblNombre = new JLabel(album.getNombreAlbum());
            lblNombre.setFont(new Font("SansSerif", Font.BOLD, 28));
            lblNombre.setForeground(Color.WHITE);
            lblNombre.setHorizontalAlignment(SwingConstants.CENTER);

            jPanelNombre.setLayout(new BoxLayout(jPanelNombre, BoxLayout.X_AXIS));

            JPanel panelTexto = new JPanel();
            panelTexto.setLayout(new BoxLayout(panelTexto, BoxLayout.Y_AXIS));
            panelTexto.setOpaque(false);

            panelTexto.add(lblNombre);

            JLabel lblArtista = new JLabel("Por: " + album.getNombreArtista());
            lblArtista.setFont(new Font("SansSerif", Font.PLAIN, 20));
            lblArtista.setForeground(Color.LIGHT_GRAY);
            lblArtista.setHorizontalAlignment(SwingConstants.CENTER);
            panelTexto.add(lblArtista);

            jPanelNombre.add(lblImagen);
            jPanelNombre.add(panelTexto);

            jPanelNombre.revalidate();
            jPanelNombre.repaint();

            // Mostrar info
            jPanelInfo.removeAll();
            jPanelInfo.setLayout(new BorderLayout());

            String genero = albumesBO.obtenerGeneroPorAlbum(albumId);
            JLabel lblGenero = new JLabel("Género: " + (genero != null ? genero : "N/A"));
            lblGenero.setForeground(Color.WHITE);
            lblGenero.setFont(new Font("SansSerif", Font.PLAIN, 18));
            jPanelInfo.add(lblGenero, BorderLayout.WEST);

            LocalDate fechaLanzamientoDate = albumesBO.obtenerFechaLanzamientoPorAlbum(albumId);
            String fechaLanzamiento = "N/A";
            if (fechaLanzamientoDate != null) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                fechaLanzamiento = fechaLanzamientoDate.format(formatter);
            }
            JLabel lblFecha = new JLabel("Lanzamiento: " + fechaLanzamiento);
            lblFecha.setForeground(Color.WHITE);
            lblFecha.setFont(new Font("SansSerif", Font.PLAIN, 18));
            jPanelInfo.add(lblFecha, BorderLayout.EAST);

            jPanelInfo.revalidate();
            jPanelInfo.repaint();

            // Mostrar canciones 
            jPanelCanciones.removeAll();
            jPanelCanciones.setLayout(new BoxLayout(jPanelCanciones, BoxLayout.Y_AXIS));

            List<CancionConArtistaDTO> canciones = albumesBO.obtenerCancionesPorAlbum(albumId);
            int indice = 1;
            for (CancionConArtistaDTO cancion : canciones) {
                PanelCancionItem panelCancion = new PanelCancionItem(cancion, indice);
                indice++;
                jPanelCanciones.add(panelCancion);
            }
            jPanelCanciones.revalidate();
            jPanelCanciones.repaint();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar información del álbum", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void mostrar() {
        setVisible(true);
    }

    public void cerrar() {
        setVisible(false);
        dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelNombre = new javax.swing.JPanel();
        jScrollPaneCanciones = new javax.swing.JScrollPane();
        jPanelCanciones = new javax.swing.JPanel();
        jPanelInfo = new javax.swing.JPanel();
        jButtonCerrar = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanelNombreLayout = new javax.swing.GroupLayout(jPanelNombre);
        jPanelNombre.setLayout(jPanelNombreLayout);
        jPanelNombreLayout.setHorizontalGroup(
            jPanelNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 930, Short.MAX_VALUE)
        );
        jPanelNombreLayout.setVerticalGroup(
            jPanelNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );

        getContentPane().add(jPanelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 34, 930, 190));

        jScrollPaneCanciones.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        javax.swing.GroupLayout jPanelCancionesLayout = new javax.swing.GroupLayout(jPanelCanciones);
        jPanelCanciones.setLayout(jPanelCancionesLayout);
        jPanelCancionesLayout.setHorizontalGroup(
            jPanelCancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 984, Short.MAX_VALUE)
        );
        jPanelCancionesLayout.setVerticalGroup(
            jPanelCancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 594, Short.MAX_VALUE)
        );

        jScrollPaneCanciones.setViewportView(jPanelCanciones);

        getContentPane().add(jScrollPaneCanciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 990, 550));

        javax.swing.GroupLayout jPanelInfoLayout = new javax.swing.GroupLayout(jPanelInfo);
        jPanelInfo.setLayout(jPanelInfoLayout);
        jPanelInfoLayout.setHorizontalGroup(
            jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 930, Short.MAX_VALUE)
        );
        jPanelInfoLayout.setVerticalGroup(
            jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(jPanelInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 930, 40));

        jButtonCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BotonCerrar.png"))); // NOI18N
        jButtonCerrar.setBorderPainted(false);
        jButtonCerrar.setContentAreaFilled(false);
        jButtonCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 30, 40, 40));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoSimple.png"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed
        cerrar();
    }//GEN-LAST:event_jButtonCerrarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JPanel jPanelCanciones;
    private javax.swing.JPanel jPanelInfo;
    private javax.swing.JPanel jPanelNombre;
    private javax.swing.JScrollPane jScrollPaneCanciones;
    // End of variables declaration//GEN-END:variables
}
