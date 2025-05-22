/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package tune.sistemabibliotecapresentacion;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
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

/**
 *
 * @author Dana Chavez
 */
public class PanelPrincipal extends javax.swing.JPanel {

    FontManager fontManager = new FontManager();

    private IArtistasBO artistasBO;
    private IAlbumesBO albumesBO;
    private IUsuariosBO usuariosBO;
    private ICancionesBO cancionesBO;
    private ControlNavegacion control;
    private CancionConArtistaDTO cancion;
    private PanelPerfilUsuario panel;

    public PanelPrincipal(IArtistasBO artistasBO, IAlbumesBO albumesBO, ICancionesBO cancionesBO, ControlNavegacion control, CancionConArtistaDTO cancion, PanelPerfilUsuario panel, IUsuariosBO usuariosBO) throws NegocioException {
        initComponents();
        this.artistasBO = artistasBO;
        this.albumesBO = albumesBO;
        this.cancionesBO = cancionesBO;
        this.control = control;
        this.cancion = cancion;
        this.panel = panel;
        this.usuariosBO = usuariosBO;

        jScrollPanePrincipal.setOpaque(false);
        jScrollPanePrincipal.setBorder(null);
        jScrollPanePrincipal.getViewport().setOpaque(false);

        jPanelPrincipal.setOpaque(false);

        mostrarCatalogo();
    }

    public void mostrarCatalogo() throws NegocioException {
        Usuario usuario = control.obtenerUsuarioActual();
        if (usuario == null) {
            return;
        }

        List<CancionConArtistaDTO> canciones = cancionesBO.obtenerTodasLasCancionesConNombreArtista(usuario.getGenerosRestringidos());
        List<Artista> artistas = artistasBO.obtenerTodosLosArtistas(usuario.getGenerosRestringidos());
        List<AlbumConArtistaDTO> albumes = albumesBO.obtenerAlbumsConNombreArtista(usuario.getGenerosRestringidos());

        // Panel para canciones en vertical
        JPanel panelCanciones = new JPanel();
        panelCanciones.setLayout(new BoxLayout(panelCanciones, BoxLayout.Y_AXIS));
        panelCanciones.setOpaque(false);

        int indice = 1;
        for (int i = 0; i < Math.min(10, canciones.size()); i++) {
            CancionConArtistaDTO cancion = canciones.get(i);
            PanelCancionItem panelCancion = new PanelCancionItem(cancion, indice++, usuariosBO, control, panel);
            panelCanciones.add(panelCancion);
        }

        // Panel para artistas en FlowLayout horizontal
        JPanel panelArtistas = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        panelArtistas.setPreferredSize(new Dimension(980, 200));
        panelArtistas.setOpaque(false);

        for (Artista artista : artistas) {
            PanelArtistaItem panelArtista = new PanelArtistaItem(artista, usuariosBO, control, panel);
            panelArtistas.add(panelArtista);
        }

        // Panel para álbumes en FlowLayout horizontal
        JPanel panelAlbumes = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        panelAlbumes.setPreferredSize(new Dimension(980, 200));
        panelAlbumes.setOpaque(false);

        for (AlbumConArtistaDTO album : albumes) {
            PanelAlbumItem panelAlbum = new PanelAlbumItem(album, usuariosBO, control, panel);
            panelAlbumes.add(panelAlbum);
        }

        // Etiquetas con estilo
        JLabel lblCanciones = new JLabel("Canciones Favoritas");
        lblCanciones.setFont(fontManager.getAfacadBold(24f));
        lblCanciones.setForeground(Color.WHITE);

        JLabel lblArtistas = new JLabel("Artistas Favoritos");
        lblArtistas.setFont(fontManager.getAfacadBold(24f));
        lblArtistas.setForeground(Color.WHITE);

        JLabel lblAlbumes = new JLabel("Álbumes Favoritos");
        lblAlbumes.setFont(fontManager.getAfacadBold(24f));
        lblAlbumes.setForeground(Color.WHITE);

        lblCanciones.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblArtistas.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblAlbumes.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Limpiar jPanelPrincipal y agregar todo con BoxLayout vertical
        jPanelPrincipal.removeAll();
        jPanelPrincipal.setLayout(new BoxLayout(jPanelPrincipal, BoxLayout.Y_AXIS));
        jPanelPrincipal.setOpaque(false);

        jPanelPrincipal.add(lblCanciones);
        jPanelPrincipal.add(panelCanciones);
        jPanelPrincipal.add(lblArtistas);
        jPanelPrincipal.add(panelArtistas);
        jPanelPrincipal.add(lblAlbumes);
        jPanelPrincipal.add(panelAlbumes);

        jPanelPrincipal.revalidate();
        jPanelPrincipal.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPanePrincipal = new javax.swing.JScrollPane();
        jPanelPrincipal = new javax.swing.JPanel();

        setBackground(new java.awt.Color(0, 33, 27));

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1008, Short.MAX_VALUE)
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 748, Short.MAX_VALUE)
        );

        jScrollPanePrincipal.setViewportView(jPanelPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPanePrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 1010, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPanePrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JScrollPane jScrollPanePrincipal;
    // End of variables declaration//GEN-END:variables
}
