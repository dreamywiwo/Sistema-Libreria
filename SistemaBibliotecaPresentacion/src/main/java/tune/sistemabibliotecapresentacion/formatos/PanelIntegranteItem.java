
package tune.sistemabibliotecapresentacion.formatos;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.time.format.DateTimeFormatter;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import tune.sistemabibliotecadominio.dtos.IntegranteDTO;

public class PanelIntegranteItem extends JPanel {

    private final IntegranteDTO integrante;

    public PanelIntegranteItem(IntegranteDTO integrante) {
        this.integrante = integrante;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(160, 180));
        setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
        setBackground(new Color(40, 40, 40));

        // Nombre completo
        JLabel lblNombre = new JLabel(integrante.getNombreCompleto());
        lblNombre.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblNombre.setForeground(Color.WHITE);
        lblNombre.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Rol
        JLabel lblRol = new JLabel("Rol: " + integrante.getRol());
        lblRol.setFont(new Font("SansSerif", Font.PLAIN, 12));
        lblRol.setForeground(Color.LIGHT_GRAY);
        lblRol.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Fechas 
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd MMM yyyy");
        String fechaIngreso = integrante.getFechaIngreso() != null ? integrante.getFechaIngreso().format(df) : "N/A";
        String fechaSalida = integrante.getFechaSalida() != null ? integrante.getFechaSalida().format(df) : "Presente";

        JLabel lblFechas = new JLabel("Desde: " + fechaIngreso + "  hasta: " + fechaSalida);
        lblFechas.setFont(new Font("SansSerif", Font.PLAIN, 11));
        lblFechas.setForeground(Color.LIGHT_GRAY);
        lblFechas.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Estado de actividad
        JLabel lblEstado = new JLabel("Estado: " + (integrante.getEstadoActividad() != null ? integrante.getEstadoActividad() : "Desconocido"));
        lblEstado.setFont(new Font("SansSerif", Font.PLAIN, 11));
        lblEstado.setForeground(Color.LIGHT_GRAY);
        lblEstado.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(Box.createVerticalGlue());
        add(lblNombre);
        add(Box.createVerticalStrut(5));
        add(lblRol);
        add(Box.createVerticalStrut(5));
        add(lblFechas);
        add(Box.createVerticalStrut(5));
        add(lblEstado);
        add(Box.createVerticalGlue());
    }
}
