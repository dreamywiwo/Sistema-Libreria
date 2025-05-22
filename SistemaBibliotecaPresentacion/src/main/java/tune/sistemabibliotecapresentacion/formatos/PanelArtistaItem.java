package tune.sistemabibliotecapresentacion.formatos;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import org.bson.types.ObjectId;
import tune.sistemabibliotecadominio.entidades.Artista;
import tune.sistemabibliotecanegocio.exception.NegocioException;
import tune.sistemabibliotecanegocio.interfaces.IUsuariosBO;
import tune.sistemabibliotecapresentacion.PanelPerfilUsuario;
import tune.sistemabibliotecapresentacion.control.ControlNavegacion;
import tune.sistemabibliotecapresentacion.utils.FontManager;

public class PanelArtistaItem extends JPanel {

    private final Artista artista;
    private final Color normalColor = new Color(30, 30, 30);
    private final Color hoverColor = new Color(50, 50, 50);
    private final FontManager fontManager = new FontManager();
    private final ControlNavegacion controlNavegacion = new ControlNavegacion();

    private final IUsuariosBO usuariosBO;
    private final ControlNavegacion control;
    private boolean esFavorito = false;
    private final JButton btnFavorito;
    
    private PanelPerfilUsuario panelPerfilUsuario;

    public PanelArtistaItem(Artista artista, IUsuariosBO usuariosBO, ControlNavegacion control, PanelPerfilUsuario panelPerfilUsuario) {
        this.artista = artista;
        this.usuariosBO = usuariosBO;
        this.control = control;
        this.panelPerfilUsuario = panelPerfilUsuario;

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(176, 176));
        setMinimumSize(new Dimension(176, 176));
        setMaximumSize(new Dimension(176, 176));
        setBackground(normalColor);
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel panelCentro = new JPanel(new BorderLayout());
        panelCentro.setOpaque(false);

        JLabel lblImagen = new JLabel();
        lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
        lblImagen.setCursor(new Cursor(Cursor.HAND_CURSOR));
        try {
            ImageIcon icon = new ImageIcon(new URL(artista.getImagen()));
            Image img = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            lblImagen.setIcon(new ImageIcon(img));
        } catch (Exception e) {
            lblImagen.setText("🎤");
            lblImagen.setFont(new Font("SansSerif", Font.PLAIN, 60));
            lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
        }

        lblImagen.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String artistaId = artista.getId().toHexString();
                try {
                    controlNavegacion.mostrarVentanaArtistaDetalle(artistaId);
                } catch (NegocioException ex) {
                    Logger.getLogger(PanelArtistaItem.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Artista seleccionado: " + artista.getNombre() + " (ID: " + artista.getId() + ")");
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
        btnFavorito.setContentAreaFilled(false);
        btnFavorito.setBorderPainted(false);
        btnFavorito.setFocusPainted(false);
        btnFavorito.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnFavorito.setToolTipText("Agregar/Eliminar favorito");
        actualizarColorFavorito();

        btnFavorito.addActionListener(ev -> {
            try {
                ObjectId usuarioId = control.obtenerUsuarioActual().getId();
                ObjectId artistaId = artista.getId();

                if (esFavorito) {
                    usuariosBO.eliminarArtistaFavorito(usuarioId, artistaId);
                    System.out.println("Artista eliminado de favoritos: " + artista.getNombre());
                    esFavorito = false;
                } else {
                    usuariosBO.agregarArtistaFavorito(usuarioId, artistaId);
                    System.out.println("Artista agregado a favoritos: " + artista.getNombre());
                    esFavorito = true;
                }
                actualizarColorFavorito();
                

            if (panelPerfilUsuario != null) {
                SwingUtilities.invokeLater(() -> {
                    try {
                        panelPerfilUsuario.mostrarFavoritos();
                    } catch (NegocioException e) {
                        e.printStackTrace();
                    }
                });
            }
            
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

        JLabel lblNombre = new JLabel(artista.getNombre());
        lblNombre.setFont(fontManager.getAfacadMedium(16f));
        lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
        lblNombre.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        lblNombre.setForeground(Color.WHITE);

        add(panelCentro, BorderLayout.CENTER);
        add(lblNombre, BorderLayout.SOUTH);
    }

    private void actualizarColorFavorito() {
        if (esFavorito) {
            btnFavorito.setForeground(Color.PINK);
        } else {
            btnFavorito.setForeground(Color.GRAY);
        }
    }

    public void setEsFavorito(boolean esFavorito) {
        this.esFavorito = esFavorito;
        actualizarColorFavorito();
    }

    public boolean isEsFavorito() {
        return esFavorito;
    }
}
