package tune.sistemabibliotecapresentacion.formatos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import org.bson.types.ObjectId;
import tune.sistemabibliotecadominio.dtos.AlbumConArtistaDTO;
import tune.sistemabibliotecanegocio.exception.NegocioException;
import tune.sistemabibliotecanegocio.interfaces.IUsuariosBO;
import tune.sistemabibliotecapresentacion.PanelPerfilUsuario;
import tune.sistemabibliotecapresentacion.control.ControlNavegacion;
import tune.sistemabibliotecapresentacion.utils.FontManager;

public class PanelAlbumItem extends JPanel {

    private final AlbumConArtistaDTO album;
    private final Color hoverColor = new Color(50, 50, 50);
    private final Color normalColor = new Color(30, 30, 30);
    private final FontManager fontManager = new FontManager();
    private final ControlNavegacion controlNavegacion = new ControlNavegacion();
    private final IUsuariosBO usuariosBO;
    private final ControlNavegacion control;
    private boolean esFavorito = false; 
    private final JButton btnFavorito;
    
    private PanelPerfilUsuario panelPerfilUsuario;

    public PanelAlbumItem(AlbumConArtistaDTO album, IUsuariosBO usuariosBO, ControlNavegacion control, PanelPerfilUsuario panelPerfilUsuario) {
        this.album = album;
        this.usuariosBO = usuariosBO;
        this.control = control;
        this.panelPerfilUsuario = panelPerfilUsuario;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(normalColor);
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setPreferredSize(new Dimension(176, 235));
        setMinimumSize(new Dimension(176, 235));
        setMaximumSize(new Dimension(176, 235));

        JPanel panelCentro = new JPanel(new BorderLayout());
        panelCentro.setOpaque(false);

        JLabel lblImagen = new JLabel();
        lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
        lblImagen.setCursor(new Cursor(Cursor.HAND_CURSOR));
        try {
            ImageIcon icon = new ImageIcon(new URL(album.getUrlImagenAlbum()));
            Image img = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            lblImagen.setIcon(new ImageIcon(img));
        } catch (Exception e) {
            lblImagen.setText("🎵");
            lblImagen.setFont(new Font("SansSerif", Font.PLAIN, 100));
            lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
        }

        lblImagen.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String albumId = album.getIdAlbum().toHexString();
                try {
                    controlNavegacion.mostrarVentanaAlbumDetalle(albumId);
                } catch (NegocioException ex) {
                    Logger.getLogger(PanelAlbumItem.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Álbum seleccionado: " + album.getNombreAlbum() + " (ID: " + album.getIdAlbum() + ")");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(normalColor);
            }
        });

        btnFavorito = new JButton("♥");
        btnFavorito.setFont(new Font("SansSerif", Font.BOLD, 24));
        actualizarColorFavorito();
        btnFavorito.setContentAreaFilled(false);
        btnFavorito.setBorderPainted(false);
        btnFavorito.setFocusPainted(false);
        btnFavorito.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnFavorito.setToolTipText("Agregar/Eliminar favorito");

        btnFavorito.addActionListener(ev -> {
            try {
                ObjectId usuarioId = control.obtenerUsuarioActual().getId();
                ObjectId albumId = album.getIdAlbum();

                if (esFavorito) {
                    usuariosBO.eliminarAlbumFavorito(usuarioId, albumId);
                    System.out.println("Álbum eliminado de favoritos: " + album.getNombreAlbum());
                    esFavorito = false;
                } else {
                    usuariosBO.agregarAlbumFavorito(usuarioId, albumId);
                    System.out.println("Álbum agregado a favoritos: " + album.getNombreAlbum());
                    esFavorito = true;
                }
                actualizarColorFavorito();
                panelPerfilUsuario.mostrarFavoritos();
            } catch (NegocioException ex) {
                System.err.println("Error al modificar favoritos: " + ex.getMessage());
            }
        });

        panelCentro.add(lblImagen, BorderLayout.CENTER);

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        panelBoton.setOpaque(false);
        panelBoton.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 10));
        panelBoton.add(btnFavorito);

        panelCentro.add(panelBoton, BorderLayout.SOUTH);

        JLabel lblNombre = new JLabel(album.getNombreAlbum());
        lblNombre.setFont(fontManager.getAfacadMedium(16f));
        lblNombre.setMaximumSize(new Dimension(156, 40));
        lblNombre.setToolTipText(album.getNombreAlbum());
        lblNombre.setForeground(Color.WHITE);
        lblNombre.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblArtista = new JLabel(album.getNombreArtista());
        lblArtista.setFont(fontManager.getAfacadRegular(14f));
        lblArtista.setForeground(Color.LIGHT_GRAY);
        lblArtista.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(panelCentro);
        add(Box.createVerticalStrut(5));
        add(lblNombre);
        add(Box.createVerticalStrut(3));
        add(lblArtista);
    }

    private void actualizarColorFavorito() {
        if (esFavorito) {
            btnFavorito.setForeground(Color.PINK);
        } else {
            btnFavorito.setForeground(Color.GRAY);
        }
    }
}
