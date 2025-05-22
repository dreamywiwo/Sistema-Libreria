/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package tune.sistemabibliotecapresentacion;

import java.awt.FlowLayout;
import java.util.List;
import tune.sistemabibliotecadominio.dtos.AlbumConArtistaDTO;
import tune.sistemabibliotecanegocio.interfaces.IAlbumesBO;
import tune.sistemabibliotecanegocio.interfaces.IUsuariosBO;
import tune.sistemabibliotecapresentacion.buscadores.BuscadorAlbumes;
import tune.sistemabibliotecapresentacion.buscadores.BusquedaAlbumListener;
import tune.sistemabibliotecapresentacion.control.ControlNavegacion;
import tune.sistemabibliotecapresentacion.formatos.PanelAlbumItem;
import tune.sistemabibliotecapresentacion.utils.FontManager;
import tune.sistemabibliotecapresentacion.utils.WrapLayout;

/**
 *
 * @author Dana Chavez
 */
public class PanelAlbumes extends javax.swing.JPanel implements BusquedaAlbumListener {

    FontManager fontManager = new FontManager();
    private IAlbumesBO albumesBO;
    private IUsuariosBO usuariosBO;
    private ControlNavegacion control;
    private PanelPerfilUsuario panelPerfilUsuario;

    public PanelAlbumes(IAlbumesBO albumesBO, IUsuariosBO usuariosBO, ControlNavegacion control, PanelPerfilUsuario panelPerfilUsuario) {
        initComponents();
        this.albumesBO = albumesBO;
        this.usuariosBO = usuariosBO;
        this.control = control;
        this.panelPerfilUsuario = panelPerfilUsuario;
        
        this.setOpaque(false);

        jScrollPaneAlbums.setOpaque(false);
        jScrollPaneAlbums.getViewport().setOpaque(false);
        jScrollPaneAlbums.setBorder(null);
        jPanelAlbums.setOpaque(false);

        BuscadorAlbumes buscador = new BuscadorAlbumes();
        buscador.setBusquedaAlbumListener(this);

        jPanelContenedor.setOpaque(false);
        jPanelContenedor.removeAll();
        jPanelContenedor.setLayout(new java.awt.BorderLayout());
        jPanelContenedor.add(buscador, java.awt.BorderLayout.CENTER);
        jPanelContenedor.revalidate();
        jPanelContenedor.repaint();

        cargarAlbumes();
    }
    
    public void mostrarAlbumes(List<AlbumConArtistaDTO> albumesDTO) {
        jPanelAlbums.removeAll();

        jPanelAlbums.setLayout(new WrapLayout(FlowLayout.CENTER, 20, 20)); 

        for (AlbumConArtistaDTO albumDTO : albumesDTO) {
            
            PanelAlbumItem panel = new PanelAlbumItem(albumDTO, usuariosBO, control, panelPerfilUsuario);
            jPanelAlbums.add(panel);
        }

        jPanelAlbums.revalidate();
        jPanelAlbums.repaint();
    }

    public void cargarAlbumes() {
        try {
            List<AlbumConArtistaDTO> albumesDTO = albumesBO.obtenerAlbumsConNombreArtista(control.obtenerUsuarioActual().getGenerosRestringidos());
            mostrarAlbumes(albumesDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<AlbumConArtistaDTO> cargarAlbumesExterior() {
        List<AlbumConArtistaDTO> albumesDTO = null;
        try {
            albumesDTO = albumesBO.obtenerAlbumsConNombreArtista(control.obtenerUsuarioActual().getGenerosRestringidos());
            mostrarAlbumes(albumesDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return albumesDTO;
    }
    
    @Override
    public void onBusquedaAlbumActualizada(String texto, String filtro) {
        try {
            List<AlbumConArtistaDTO> albumesFiltrados;

            if (texto == null || texto.isEmpty()) {
                albumesFiltrados = albumesBO.obtenerAlbumsConNombreArtista(control.obtenerUsuarioActual().getGenerosRestringidos());
            } else {
                switch (filtro) {
                    case "Filtro":
                        albumesFiltrados = albumesBO.buscarAlbumesPorTexto(texto,control.obtenerUsuarioActual().getGenerosRestringidos());
                        break;
                    case "Nombre":
                        albumesFiltrados = albumesBO.obtenerAlbumPorNombreConArtista(texto,control.obtenerUsuarioActual().getGenerosRestringidos());
                        break;
                    case "Genero":
                        albumesFiltrados = albumesBO.obtenerAlbumPorGeneroConArtista(texto,control.obtenerUsuarioActual().getGenerosRestringidos());
                        break;
                    case "Fecha Lanzamiento":
                        albumesFiltrados = albumesBO.obtenerAlbumPorFechaLanzamientoConArtista(texto,control.obtenerUsuarioActual().getGenerosRestringidos());
                        break;
                    default:
                        albumesFiltrados = albumesBO.obtenerAlbumsConNombreArtista(control.obtenerUsuarioActual().getGenerosRestringidos());
                }
            }

            System.out.println("Álbumes encontrados: " + albumesFiltrados.size());
            mostrarAlbumes(albumesFiltrados);
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

        jLabelTitulo = new javax.swing.JLabel();
        jPanelContenedor = new javax.swing.JPanel();
        jScrollPaneAlbums = new javax.swing.JScrollPane();
        jPanelAlbums = new javax.swing.JPanel();

        setBackground(new java.awt.Color(0, 33, 27));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitulo.setFont(fontManager.getAfacadBold(128f));
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setText("Albumes");
        add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 470, 130));

        javax.swing.GroupLayout jPanelContenedorLayout = new javax.swing.GroupLayout(jPanelContenedor);
        jPanelContenedor.setLayout(jPanelContenedorLayout);
        jPanelContenedorLayout.setHorizontalGroup(
            jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        jPanelContenedorLayout.setVerticalGroup(
            jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        add(jPanelContenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 200, 450, 50));

        javax.swing.GroupLayout jPanelAlbumsLayout = new javax.swing.GroupLayout(jPanelAlbums);
        jPanelAlbums.setLayout(jPanelAlbumsLayout);
        jPanelAlbumsLayout.setHorizontalGroup(
            jPanelAlbumsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 948, Short.MAX_VALUE)
        );
        jPanelAlbumsLayout.setVerticalGroup(
            jPanelAlbumsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 468, Short.MAX_VALUE)
        );

        jScrollPaneAlbums.setViewportView(jPanelAlbums);

        add(jScrollPaneAlbums, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 950, 470));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelAlbums;
    private javax.swing.JPanel jPanelContenedor;
    private javax.swing.JScrollPane jScrollPaneAlbums;
    // End of variables declaration//GEN-END:variables
}
