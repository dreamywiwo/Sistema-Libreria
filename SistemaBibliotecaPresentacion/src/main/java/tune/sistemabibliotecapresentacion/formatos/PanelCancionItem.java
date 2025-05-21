/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tune.sistemabibliotecapresentacion.formatos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import tune.sistemabibliotecadominio.dtos.CancionConArtistaDTO;

import java.net.URL;
import tune.sistemabibliotecapresentacion.utils.FontManager;

public class PanelCancionItem extends JPanel {

    FontManager fontManager = new FontManager();

    private static final int PANEL_HEIGHT = 70;

    public PanelCancionItem(CancionConArtistaDTO cancion, int indice) {
        setLayout(new BorderLayout());
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        // Panel izquierda: indice + imagen
        JPanel izquierda = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        izquierda.setOpaque(false);

        JLabel lblIndice = new JLabel(String.valueOf(indice));
        lblIndice.setForeground(Color.GRAY);
        lblIndice.setPreferredSize(new Dimension(20, 50)); 

        JLabel lblImagen = new JLabel();
        if (cancion.getUrlImagenAlbum() != null) {
            try {
                ImageIcon icon = new ImageIcon(new URL(cancion.getUrlImagenAlbum()));
                Image img = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                lblImagen.setIcon(new ImageIcon(img));
            } catch (Exception e) {
                lblImagen.setText("/");
            }
        }

        izquierda.add(lblIndice);
        izquierda.add(lblImagen);

        // Panel central: titulo + artista
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

        // Panel derecha: album + duracion 
        JPanel derecha = new JPanel();
        derecha.setOpaque(false);
        derecha.setLayout(new FlowLayout(FlowLayout.RIGHT)); // FlowLayout para disposicion horizontal

        JLabel lblAlbum = new JLabel(cancion.getNombreAlbum());
        lblAlbum.setForeground(Color.WHITE);
        lblAlbum.setFont(fontManager.getAfacadRegular(12f));
        lblAlbum.setAlignmentX(Component.RIGHT_ALIGNMENT);

        JLabel lblDuracion = new JLabel(cancion.getDuracion());
        lblDuracion.setForeground(Color.WHITE);
        lblDuracion.setFont(fontManager.getAfacadRegular(12f));
        lblDuracion.setAlignmentX(Component.RIGHT_ALIGNMENT);

        // Anadir los dos elementos en linea horizontal
        derecha.add(lblAlbum);
        derecha.add(lblDuracion);

        add(izquierda, BorderLayout.WEST);
        add(centro, BorderLayout.CENTER);
        add(derecha, BorderLayout.EAST);

        // Ajustar el tamano vertical del panel
        setPreferredSize(new Dimension(900, PANEL_HEIGHT));
        setMaximumSize(new Dimension(900, PANEL_HEIGHT)); 
    }
}

