package tune.sistemabibliotecapresentacion.formatos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.bson.types.ObjectId;
import tune.sistemabibliotecadominio.dtos.CancionConArtistaDTO;
import tune.sistemabibliotecanegocio.exception.NegocioException;
import tune.sistemabibliotecanegocio.interfaces.IUsuariosBO;
import tune.sistemabibliotecapresentacion.PanelPerfilUsuario;
import tune.sistemabibliotecapresentacion.control.ControlNavegacion;
import tune.sistemabibliotecapresentacion.utils.FontManager;

public class PanelCancionItem extends JPanel {

    private static final int PANEL_HEIGHT = 70;
    private final FontManager fontManager = new FontManager();

    private final CancionConArtistaDTO cancion;
    private final IUsuariosBO usuariosBO;
    private final ControlNavegacion control;
    private boolean esFavorito = false;
    private final JButton btnFavorito;

    private PanelPerfilUsuario panelPerfilUsuario;

    public PanelCancionItem(CancionConArtistaDTO cancion, int indice, IUsuariosBO usuariosBO, ControlNavegacion control, PanelPerfilUsuario panelPerfilUsuario) {
        this.cancion = cancion;
        this.usuariosBO = usuariosBO;
        this.control = control;
        this.panelPerfilUsuario = panelPerfilUsuario;

        setLayout(new BorderLayout());
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        JPanel izquierda = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        izquierda.setOpaque(false);

        JLabel lblIndice = new JLabel(String.valueOf(indice));
        lblIndice.setForeground(Color.GRAY);
        lblIndice.setPreferredSize(new Dimension(20, 50));

        JLabel lblImagen = new JLabel();
        if (cancion.getUrlImagenAlbum() != null) {
            try {
                ImageIcon icon = new ImageIcon(new java.net.URL(cancion.getUrlImagenAlbum()));
                Image img = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                lblImagen.setIcon(new ImageIcon(img));
            } catch (Exception e) {
                lblImagen.setText("/");
            }
        }

        izquierda.add(lblIndice);
        izquierda.add(lblImagen);

        // Panel central: titulo + artista (solo etiquetas)
        JPanel centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
        centro.setOpaque(false);

        JLabel lblTitulo = new JLabel(cancion.getNombreCancion());
        lblTitulo.setFont(fontManager.getAfacadMedium(16f));
        lblTitulo.setForeground(Color.WHITE);

        JLabel lblArtista = new JLabel(cancion.getNombreArtista());
        lblArtista.setForeground(Color.LIGHT_GRAY);
        lblArtista.setFont(fontManager.getAfacadRegular(12f));

        centro.add(lblTitulo);
        centro.add(lblArtista);

        JPanel derecha = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        derecha.setOpaque(false);
        derecha.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JLabel lblAlbum = new JLabel(cancion.getNombreAlbum());
        lblAlbum.setForeground(Color.WHITE);
        lblAlbum.setFont(fontManager.getAfacadRegular(12f));
        lblAlbum.setAlignmentX(Component.RIGHT_ALIGNMENT);

        JLabel lblDuracion = new JLabel(cancion.getDuracion());
        lblDuracion.setForeground(Color.WHITE);
        lblDuracion.setFont(fontManager.getAfacadRegular(12f));
        lblDuracion.setAlignmentX(Component.RIGHT_ALIGNMENT);

        btnFavorito = new JButton("♥");
        btnFavorito.setFont(new Font("SansSerif", Font.BOLD, 18));
        btnFavorito.setContentAreaFilled(false);
        btnFavorito.setBorderPainted(false);
        btnFavorito.setFocusPainted(false);
        btnFavorito.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnFavorito.setToolTipText("Agregar/Eliminar favorito");
        actualizarColorFavorito();

        btnFavorito.addActionListener(ev -> {
            try {
                ObjectId usuarioId = control.obtenerUsuarioActual().getId();
                ObjectId cancionId = cancion.getId();

                if (cancionId == null) {
                    System.err.println("ID de canción es null, no se puede agregar a favoritos");
                    return;
                }

                if (esFavorito) {
                    usuariosBO.eliminarCancionFavorito(usuarioId, cancionId);
                    System.out.println("Canción eliminada de favoritos: " + cancion.getNombreCancion());
                    esFavorito = false;
                } else {
                    usuariosBO.agregarCancionFavorito(usuarioId, cancionId);
                    System.out.println("Canción agregada a favoritos: " + cancion.getNombreCancion());
                    esFavorito = true;
                }
                actualizarColorFavorito();
                panelPerfilUsuario.mostrarFavoritos();

            } catch (NegocioException ex) {
                System.err.println("Error al modificar favoritos: " + ex.getMessage());
            }
        });

        derecha.add(lblAlbum);
        derecha.add(lblDuracion);
        derecha.add(btnFavorito);

        add(izquierda, BorderLayout.WEST);
        add(centro, BorderLayout.CENTER);
        add(derecha, BorderLayout.EAST);

        setPreferredSize(new Dimension(900, PANEL_HEIGHT));
        setMaximumSize(new Dimension(900, PANEL_HEIGHT));
    }

    private void actualizarColorFavorito() {
        btnFavorito.setForeground(esFavorito ? Color.PINK : Color.GRAY);
    }

    public void setEsFavorito(boolean esFavorito) {
        this.esFavorito = esFavorito;
        actualizarColorFavorito();
    }

    public boolean isEsFavorito() {
        return esFavorito;
    }
}
