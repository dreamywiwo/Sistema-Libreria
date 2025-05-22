/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tune.sistemabibliotecapresentacion.formatos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import tune.sistemabibliotecapresentacion.PanelGeneros;

public class PanelGeneroItem extends JPanel {

    private String genero;
    private boolean seleccionado = false;
    private final JLabel label;
    private final PanelGeneros panelGeneros;

    private static final Color COLOR_SELECCIONADO = new Color(0xCEC8D4);
    private static final Color COLOR_TEXTO = Color.WHITE;

    public PanelGeneroItem(String genero, PanelGeneros panelGeneros) {
        this.genero = genero;
        this.panelGeneros = panelGeneros;
        setPreferredSize(new Dimension(125, 50));
        setMaximumSize(new Dimension(125, 50));
        setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        label = new JLabel(genero, SwingConstants.CENTER);
        label.setForeground(COLOR_TEXTO);
        label.setFont(new Font("SansSerif", Font.PLAIN, 14));
        setLayout(new BorderLayout());
        add(label, BorderLayout.CENTER);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionado = !seleccionado;
                repaint();
                if (seleccionado) {
                    panelGeneros.agregarGeneroRestringido(genero);
                } else {
                    panelGeneros.quitarGeneroRestringido(genero);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        });
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
        repaint();
    }

    public String getGenero() {
        return genero;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (seleccionado) {
            g2.setColor(COLOR_SELECCIONADO);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        }

        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(2));
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);

        g2.dispose();
    }
}
