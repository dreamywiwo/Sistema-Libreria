/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tune.sistemabibliotecapresentacion.formatos;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import tune.sistemabibliotecadominio.dtos.AlbumConArtistaDTO;
import tune.sistemabibliotecapresentacion.control.ControlNavegacion;
import tune.sistemabibliotecapresentacion.utils.FontManager;

public class PanelAlbumItem extends JPanel {

    private final AlbumConArtistaDTO album;
    private final Color hoverColor = new Color(50, 50, 50);
    private final Color normalColor = new Color(30, 30, 30);
    private FontManager fontManager = new FontManager();
    private ControlNavegacion controlNavegacion = new ControlNavegacion();
   

    public PanelAlbumItem(AlbumConArtistaDTO album) {
        this.album = album;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(normalColor);
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        setPreferredSize(new Dimension(176, 235));
        setMinimumSize(new Dimension(176, 235));
        setMaximumSize(new Dimension(176, 235));


        JLabel lblImagen = new JLabel();
        lblImagen.setAlignmentX(Component.CENTER_ALIGNMENT);
        try {
            ImageIcon icon = new ImageIcon(new URL(album.getUrlImagenAlbum()));
            Image img = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            lblImagen.setIcon(new ImageIcon(img));
        } catch (Exception e) {
            lblImagen.setText("🎵");
            lblImagen.setFont(new Font("SansSerif", Font.PLAIN, 100));
            lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
        }

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

        add(lblImagen);
        add(Box.createVerticalStrut(5));
        add(lblNombre);
        add(Box.createVerticalStrut(3));
        add(lblArtista);

        // Mouse events
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Álbum seleccionado: " + album.getNombreAlbum() + " (ID: " + album.getIdAlbum() + ")");
                String albumId = album.getIdAlbum().toHexString(); 
                controlNavegacion.mostrarVentanaAlbumDetalle(albumId);
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
    }
}

