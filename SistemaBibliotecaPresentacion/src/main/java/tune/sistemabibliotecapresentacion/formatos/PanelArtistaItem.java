package tune.sistemabibliotecapresentacion.formatos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import tune.sistemabibliotecadominio.entidades.Artista;
import tune.sistemabibliotecapresentacion.control.ControlNavegacion;
import tune.sistemabibliotecapresentacion.utils.FontManager;

public class PanelArtistaItem extends JPanel {

    private final Artista artista;
    private final Color normalColor = new Color(30, 30, 30);
    private final Color hoverColor = new Color(50, 50, 50);
    FontManager fontManager = new FontManager();
    ControlNavegacion controlNavegacion = new ControlNavegacion();

    public PanelArtistaItem(Artista artista) {
        this.artista = artista;
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(176, 176));
        setMinimumSize(new Dimension(176, 176));
        setMaximumSize(new Dimension(176, 176));
        setBackground(normalColor);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblImagen = new JLabel();
        lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
        try {
            ImageIcon icon = new ImageIcon(new URL(artista.getImagen()));
            Image img = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            lblImagen.setIcon(new ImageIcon(img));
        } catch (Exception e) {
            lblImagen.setText("🎤");
            lblImagen.setFont(new Font("SansSerif", Font.PLAIN, 60));
            lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
        }

        JLabel lblNombre = new JLabel(artista.getNombre());
        lblNombre.setFont(fontManager.getAfacadMedium(16f));
        lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
        lblNombre.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        lblNombre.setForeground(Color.WHITE);

        add(lblImagen, BorderLayout.CENTER);
        add(lblNombre, BorderLayout.SOUTH);

        // Mouse listener para efectos y acción
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(normalColor);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                String artistaId = artista.getId().toHexString(); 
                controlNavegacion.mostrarVentanaArtistaDetalle(artistaId);
                System.out.println("Artista seleccionado: " + artista.getNombre() + " (ID: " + artista.getId() + ")");

            }
        });
    }
}


