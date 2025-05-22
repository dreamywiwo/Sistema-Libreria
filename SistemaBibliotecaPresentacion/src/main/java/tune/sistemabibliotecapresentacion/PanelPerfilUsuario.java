
package tune.sistemabibliotecapresentacion;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.bson.types.ObjectId;
import tune.sistemabibliotecadominio.dtos.AlbumConArtistaDTO;
import tune.sistemabibliotecadominio.dtos.CancionConArtistaDTO;
import tune.sistemabibliotecadominio.entidades.Artista;
import tune.sistemabibliotecadominio.entidades.Usuario;
import tune.sistemabibliotecanegocio.exception.NegocioException;
import tune.sistemabibliotecanegocio.interfaces.IAlbumesBO;
import tune.sistemabibliotecanegocio.interfaces.IArtistasBO;
import tune.sistemabibliotecanegocio.interfaces.ICancionesBO;
import tune.sistemabibliotecanegocio.interfaces.IUsuariosBO;
import tune.sistemabibliotecapresentacion.control.ControlNavegacion;
import tune.sistemabibliotecapresentacion.formatos.PanelAlbumItem;
import tune.sistemabibliotecapresentacion.formatos.PanelArtistaItem;
import tune.sistemabibliotecapresentacion.formatos.PanelCancionItem;
import tune.sistemabibliotecapresentacion.utils.FontManager;

public class PanelPerfilUsuario extends javax.swing.JPanel {

    FontManager fontManager = new FontManager();
    ControlNavegacion control;
    VentanaPrincipal ventanaPrincipal;
    Usuario usuarioActual;
    IUsuariosBO usuariosBO;
    IArtistasBO artistasBO;
    IAlbumesBO albumesBO;
    ICancionesBO cancionesBO;
    List<String> generos;

    public PanelPerfilUsuario(ControlNavegacion control, VentanaPrincipal ventanaPrincipal, IUsuariosBO usuariosBO, List<String> generos, 
                                IArtistasBO artistasBO, IAlbumesBO albumesBO, ICancionesBO cancionesBO) throws NegocioException {
        initComponents();
        this.control = control;
        this.ventanaPrincipal = ventanaPrincipal;
        this.usuariosBO = usuariosBO;
        this.albumesBO = albumesBO;
        this.artistasBO = artistasBO;
        this.cancionesBO = cancionesBO;
        this.usuarioActual = control.obtenerUsuarioActual();
        this.generos = generos;
        jLabelNombreUsuario.setFont(fontManager.getAfacadBold(96));
        jButtonEditarPerfil.setFont(fontManager.getAfacadMedium(20));
        jLabelPerfilTexto.setFont(fontManager.getAfacadMedium(20));
        
        jPanelFavoritos.setOpaque(false);
        jScrollPaneFavoritos.setOpaque(false);
        jScrollPaneFavoritos.getViewport().setOpaque(false);
        jScrollPaneFavoritos.setBorder(null);
        
               
        establecerDatos();
        mostrarFavoritos();
    }

    public void establecerDatos() {
        jLabelNombreUsuario.setText(usuarioActual.getNombreusuario());
        String rutaImagen = usuarioActual.getImagenPerfil();
        if (rutaImagen != null && !rutaImagen.isEmpty()) {
            ImageIcon originalIcon = new ImageIcon(rutaImagen);
            if (originalIcon.getIconWidth() > 0 && originalIcon.getIconHeight() > 0) {
                Image imagenEscalada = originalIcon.getImage().getScaledInstance(
                        200,
                        200,
                        Image.SCALE_SMOOTH
                );
                jLabelImagenPerfil.setIcon(new ImageIcon(imagenEscalada));
            } else {
                jLabelImagenPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/NoImagenPerfil.png")));
            }
        } else {
            jLabelImagenPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/NoImagenPerfil.png")));
        }
    }

    public void mostrarPanelEditarUsuarioFlotante() {
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

            PanelEditarUsuario panelEditar = new PanelEditarUsuario(usuarioActual, control, ventanaPrincipal, usuariosBO, this);
            panelEditar.setOpaque(true);
            panelEditar.setPreferredSize(new Dimension(850, 500));
            fondoOscuro.add(panelEditar);

            JDialog dialogo = new JDialog((Frame) null, Dialog.ModalityType.APPLICATION_MODAL);
            dialogo.setUndecorated(true);
            dialogo.setBackground(new Color(0, 0, 0, 0));
            dialogo.setContentPane(fondoOscuro);
            dialogo.setSize(1138, 868);

            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int x = (screenSize.width - dialogo.getWidth()) / 2;
            int y = (screenSize.height - dialogo.getHeight()) / 2 - 9;
            dialogo.setLocation(x, y);

            dialogo.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarPanelGenerosFlotante() {
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

            PanelGeneros panelGeneros = new PanelGeneros(usuariosBO, generos, this, control);
            panelGeneros.setOpaque(true);
            panelGeneros.setPreferredSize(new Dimension(830, 561));
            panelGeneros.cargarGeneros();
            fondoOscuro.add(panelGeneros);

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

    public void actualizarDatos() {
        usuarioActual = usuariosBO.obtenerUsuarioActual();
        establecerDatos();
    }

    public void mostrarFavoritos() throws NegocioException {

        Usuario usuario = control.obtenerUsuarioActual();
        if (usuario == null) return;
        
        List<CancionConArtistaDTO> cancionesFavoritas = cancionesBO.obtenerCancionesPorIds(usuario.getCanciones());
        List<Artista> artistasFavoritos = artistasBO.obtenerArtistasPorIds(usuario.getArtistas());
        List<AlbumConArtistaDTO> albumesFavoritos = albumesBO.obtenerAlbumsPorIds(usuario.getAlbumes());

        JPanel panelCanciones = new JPanel();
        panelCanciones.setLayout(new BoxLayout(panelCanciones, BoxLayout.Y_AXIS));
        panelCanciones.setOpaque(false);

        int indice = 1;
        for (CancionConArtistaDTO cancion : cancionesFavoritas) {
            PanelCancionItem panelCancion = new PanelCancionItem(cancion, indice++, usuariosBO, control, this);
            panelCanciones.add(panelCancion);
        }

        JPanel panelArtistas = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        panelArtistas.setPreferredSize(new Dimension(980, 200));
        panelArtistas.setOpaque(false);

        for (Artista artista : artistasFavoritos) {
            PanelArtistaItem panelArtista = new PanelArtistaItem(artista, usuariosBO, control, this);
            panelArtistas.add(panelArtista);
        }

        JPanel panelAlbums = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        panelAlbums.setPreferredSize(new Dimension(980, 200));
        panelAlbums.setOpaque(false);

        for (AlbumConArtistaDTO album : albumesFavoritos) {
            PanelAlbumItem panelAlbum = new PanelAlbumItem(album, usuariosBO, control, this);
            panelAlbums.add(panelAlbum);
        }

        JLabel lblCanciones = new JLabel("Canciones Favoritas");
        lblCanciones.setFont(fontManager.getAfacadBold(24f));
        lblCanciones.setForeground(Color.WHITE);

        JLabel lblArtistas = new JLabel("Artistas Favoritos");
        lblArtistas.setFont(fontManager.getAfacadBold(24f));
        lblArtistas.setForeground(Color.WHITE);

        JLabel lblAlbums = new JLabel("Álbumes Favoritos");
        lblAlbums.setFont(fontManager.getAfacadBold(24f));
        lblAlbums.setForeground(Color.WHITE);

        jPanelFavoritos.removeAll();
        jPanelFavoritos.setLayout(new BoxLayout(jPanelFavoritos, BoxLayout.Y_AXIS));
        jPanelFavoritos.setOpaque(false);

        jPanelFavoritos.add(lblCanciones);
        jPanelFavoritos.add(panelCanciones);

        jPanelFavoritos.add(lblArtistas);
        jPanelFavoritos.add(panelArtistas);

        jPanelFavoritos.add(lblAlbums);
        jPanelFavoritos.add(panelAlbums);

        jPanelFavoritos.revalidate();
        jPanelFavoritos.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelImagenPerfil = new javax.swing.JLabel();
        jLabelNombreUsuario = new javax.swing.JLabel();
        jButtonEditarPerfil = new javax.swing.JButton();
        jButtonGeneros = new javax.swing.JButton();
        jLabelPerfilTexto = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();
        jScrollPaneFavoritos = new javax.swing.JScrollPane();
        jPanelFavoritos = new javax.swing.JPanel();

        setBackground(new java.awt.Color(0, 33, 27));
        setMinimumSize(new java.awt.Dimension(1020, 763));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelImagenPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/NoImagenPerfil.png"))); // NOI18N
        add(jLabelImagenPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 210, 180));

        jLabelNombreUsuario.setFont(new java.awt.Font("Segoe UI", 0, 96)); // NOI18N
        jLabelNombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNombreUsuario.setText("Usuario");
        add(jLabelNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 730, 90));

        jButtonEditarPerfil.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButtonEditarPerfil.setForeground(new java.awt.Color(153, 173, 170));
        jButtonEditarPerfil.setText("Editar perfil");
        jButtonEditarPerfil.setBorderPainted(false);
        jButtonEditarPerfil.setContentAreaFilled(false);
        jButtonEditarPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEditarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarPerfilActionPerformed(evt);
            }
        });
        add(jButtonEditarPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 150, 30));

        jButtonGeneros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BotonGenerosExcluidos.png"))); // NOI18N
        jButtonGeneros.setBorderPainted(false);
        jButtonGeneros.setContentAreaFilled(false);
        jButtonGeneros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonGeneros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerosActionPerformed(evt);
            }
        });
        add(jButtonGeneros, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 20, -1, -1));

        jLabelPerfilTexto.setForeground(new java.awt.Color(153, 173, 170));
        jLabelPerfilTexto.setText("Perfil");
        add(jLabelPerfilTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 120, 30));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Degradado.png"))); // NOI18N
        add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 260));

        jScrollPaneFavoritos.setViewportView(jPanelFavoritos);

        add(jScrollPaneFavoritos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 1000, 500));
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEditarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarPerfilActionPerformed
        mostrarPanelEditarUsuarioFlotante();
    }//GEN-LAST:event_jButtonEditarPerfilActionPerformed

    private void jButtonGenerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerosActionPerformed
        mostrarPanelGenerosFlotante();
    }//GEN-LAST:event_jButtonGenerosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEditarPerfil;
    private javax.swing.JButton jButtonGeneros;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelImagenPerfil;
    private javax.swing.JLabel jLabelNombreUsuario;
    private javax.swing.JLabel jLabelPerfilTexto;
    private javax.swing.JPanel jPanelFavoritos;
    private javax.swing.JScrollPane jScrollPaneFavoritos;
    // End of variables declaration//GEN-END:variables
}
