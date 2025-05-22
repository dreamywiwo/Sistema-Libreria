/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package tune.sistemabibliotecapresentacion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import tune.sistemabibliotecapresentacion.buscadores.BuscadorArtistas;
import tune.sistemabibliotecapresentacion.buscadores.BusquedaListener;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import tune.sistemabibliotecadominio.entidades.Artista;
import tune.sistemabibliotecanegocio.interfaces.IArtistasBO;
import tune.sistemabibliotecanegocio.interfaces.IUsuariosBO;
import tune.sistemabibliotecapresentacion.control.ControlNavegacion;
import tune.sistemabibliotecapresentacion.formatos.PanelArtistaItem;
import tune.sistemabibliotecapresentacion.utils.FontManager;
import tune.sistemabibliotecapresentacion.utils.WrapLayout;

/**
 *
 * @author Dana Chavez
 */
public class PanelArtistas extends javax.swing.JPanel implements BusquedaListener {

    FontManager fontManager = new FontManager();
    
    private IUsuariosBO usuariosBO;
    private IArtistasBO artistasBO;
    private ControlNavegacion control;
    private PanelPerfilUsuario panelPerfilUsuario;

    public PanelArtistas(IArtistasBO artistasBO, IUsuariosBO usuariosBO, ControlNavegacion control, PanelPerfilUsuario panelPerfilUsuario) {
        initComponents();
        this.artistasBO = artistasBO;
        this.usuariosBO = usuariosBO;
        this.control = control;
        this.panelPerfilUsuario = panelPerfilUsuario;
        this.setOpaque(false);

        jScrollPaneArtistas.setOpaque(false);
        jScrollPaneArtistas.getViewport().setOpaque(false);
        jScrollPaneArtistas.setBorder(null);
        jPanelArtistas.setOpaque(false);

        BuscadorArtistas buscador = new BuscadorArtistas();
        buscador.setBusquedaListener(this);

        jPanelContenedor.setOpaque(false);
        jPanelContenedor.removeAll();
        jPanelContenedor.setLayout(new java.awt.BorderLayout());
        jPanelContenedor.add(buscador, java.awt.BorderLayout.CENTER);
        jPanelContenedor.revalidate();
        jPanelContenedor.repaint();

        //cargarArtistas();
        cargarArtistasPorGenero();

    }

    public void mostrarArtistas(List<Artista> artistas) {
        jPanelArtistas.removeAll();
        jPanelArtistas.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        for (Artista artista : artistas) {
            PanelArtistaItem panel = new PanelArtistaItem(artista, usuariosBO, control, panelPerfilUsuario);
            jPanelArtistas.add(panel);
        }

        jPanelArtistas.revalidate();
        jPanelArtistas.repaint();
    }

    public void cargarArtistas() {
        try {
            List<Artista> artistas = artistasBO.obtenerTodosLosArtistas();
            mostrarArtistas(artistas);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Artista> cargarArtistasExterior() {
        List<Artista> artistas = null;
        try {
            artistas = artistasBO.obtenerTodosLosArtistas();
            mostrarArtistas(artistas);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return artistas;
    }

    private void cargarArtistasPorGenero() {
        try {
            List<Artista> todosArtistas = artistasBO.obtenerTodosLosArtistas();

            Map<String, List<Artista>> artistasPorGenero = new LinkedHashMap<>();
            for (Artista artista : todosArtistas) {
                String genero = artista.getGeneroMusical() != null ? artista.getGeneroMusical() : "Sin género";
                artistasPorGenero.computeIfAbsent(genero, k -> new ArrayList<>()).add(artista);
            }

            jPanelArtistas.removeAll();
            jPanelArtistas.setLayout(new javax.swing.BoxLayout(jPanelArtistas, javax.swing.BoxLayout.Y_AXIS));

            for (Map.Entry<String, List<Artista>> entry : artistasPorGenero.entrySet()) {
                String genero = entry.getKey();
                List<Artista> artistas = entry.getValue();

                JLabel lblGenero = new JLabel(genero);
                lblGenero.setForeground(Color.WHITE);
                lblGenero.setFont(new Font("SansSerif", Font.BOLD, 18));
                lblGenero.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                jPanelArtistas.add(lblGenero);

                JPanel panelArtistasGenero = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
                panelArtistasGenero.setBackground(new Color(0, 33, 27));

                for (Artista artista : artistas) {
                    PanelArtistaItem item = new PanelArtistaItem(artista, usuariosBO, control, panelPerfilUsuario);
                    panelArtistasGenero.add(item);
                }

                JScrollPane scrollPane = new JScrollPane(panelArtistasGenero,
                        JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

                scrollPane.setPreferredSize(new Dimension(800, 200));
                scrollPane.setBorder(BorderFactory.createEmptyBorder());
                scrollPane.getHorizontalScrollBar().setUnitIncrement(16);

                jPanelArtistas.add(scrollPane);
            }

            jPanelArtistas.revalidate();
            jPanelArtistas.repaint();

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
        jScrollPaneArtistas = new javax.swing.JScrollPane();
        jPanelArtistas = new javax.swing.JPanel();

        setBackground(new java.awt.Color(0, 33, 27));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitulo.setFont(fontManager.getAfacadBold(128f));
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setText("Artistas");
        add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 470, 130));

        javax.swing.GroupLayout jPanelContenedorLayout = new javax.swing.GroupLayout(jPanelContenedor);
        jPanelContenedor.setLayout(jPanelContenedorLayout);
        jPanelContenedorLayout.setHorizontalGroup(
            jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanelContenedorLayout.setVerticalGroup(
            jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        add(jPanelContenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 170, 400, 50));

        javax.swing.GroupLayout jPanelArtistasLayout = new javax.swing.GroupLayout(jPanelArtistas);
        jPanelArtistas.setLayout(jPanelArtistasLayout);
        jPanelArtistasLayout.setHorizontalGroup(
            jPanelArtistasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 934, Short.MAX_VALUE)
        );
        jPanelArtistasLayout.setVerticalGroup(
            jPanelArtistasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 484, Short.MAX_VALUE)
        );

        jScrollPaneArtistas.setViewportView(jPanelArtistas);

        add(jScrollPaneArtistas, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 930, 490));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelArtistas;
    private javax.swing.JPanel jPanelContenedor;
    private javax.swing.JScrollPane jScrollPaneArtistas;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onBusquedaActualizada(String textoBusqueda) {
        try {
            if (textoBusqueda == null || textoBusqueda.trim().isEmpty()) {
                cargarArtistasPorGenero();
                return;
            }

            List<Artista> artistasFiltrados = artistasBO.obtenerPorNombre(textoBusqueda);

            jPanelArtistas.removeAll();
            jPanelArtistas.setLayout(new WrapLayout(FlowLayout.CENTER, 20, 20));

            for (Artista artista : artistasFiltrados) {
                PanelArtistaItem panel = new PanelArtistaItem(artista, usuariosBO, control, panelPerfilUsuario);
                jPanelArtistas.add(panel);
            }

            jPanelArtistas.revalidate();
            jPanelArtistas.repaint();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
