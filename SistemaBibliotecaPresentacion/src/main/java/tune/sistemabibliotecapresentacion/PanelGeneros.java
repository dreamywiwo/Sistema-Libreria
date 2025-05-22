/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package tune.sistemabibliotecapresentacion;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;
import tune.sistemabibliotecanegocio.interfaces.IUsuariosBO;
import tune.sistemabibliotecapresentacion.control.ControlNavegacion;
import tune.sistemabibliotecapresentacion.formatos.PanelGeneroItem;

/**
 *
 * @author leoca
 */
public class PanelGeneros extends javax.swing.JPanel {

    IUsuariosBO usuariosBO;
    List<String> generos;
    List<String> generosRestringidos;
    PanelPerfilUsuario panelPerfilUsuario;
    ControlNavegacion control;

    public PanelGeneros(IUsuariosBO usuariosBO, List<String> generos, PanelPerfilUsuario panelPerfilUsuario, ControlNavegacion control) {
        this.control = control;
        this.usuariosBO = usuariosBO;
        this.generos = generos;
        this.panelPerfilUsuario = panelPerfilUsuario;
        this.generosRestringidos = usuariosBO.obtenerUsuarioActual().getGenerosRestringidos();
        if (this.generosRestringidos == null) {
            this.generosRestringidos = new ArrayList<>();
        }
        initComponents();

        this.setOpaque(false);

        jScrollPaneGeneros.setOpaque(false);
        jScrollPaneGeneros.getViewport().setOpaque(false);
        jScrollPaneGeneros.setBorder(null);
        jPanelGeneros.setOpaque(false);
    }

    public void cargarGeneros() {
        jPanelGeneros.removeAll();
        jPanelGeneros.setLayout(new tune.sistemabibliotecapresentacion.utils.WrapLayout(FlowLayout.LEFT, 20, 20));

        for (String genero : generos) {
            PanelGeneroItem item = new PanelGeneroItem(genero, this);
            if (generosRestringidos != null) {
                if (generosRestringidos.contains(genero)) {
                    item.setSeleccionado(true);
                }
            }
            jPanelGeneros.add(item);
        }

        jPanelGeneros.revalidate();
        jPanelGeneros.repaint();
    }

    public void agregarGeneroRestringido(String genero) {
        if (!generosRestringidos.contains(genero)) {
            generosRestringidos.add(genero);
        }
    }

    public void quitarGeneroRestringido(String genero) {
        generosRestringidos.remove(genero);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPaneGeneros = new javax.swing.JScrollPane();
        jPanelGeneros = new javax.swing.JPanel();
        jButtonAceptar = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanelGenerosLayout = new javax.swing.GroupLayout(jPanelGeneros);
        jPanelGeneros.setLayout(jPanelGenerosLayout);
        jPanelGenerosLayout.setHorizontalGroup(
            jPanelGenerosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 748, Short.MAX_VALUE)
        );
        jPanelGenerosLayout.setVerticalGroup(
            jPanelGenerosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
        );

        jScrollPaneGeneros.setViewportView(jPanelGeneros);

        add(jScrollPaneGeneros, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 750, 310));

        jButtonAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BotonAceptar.png"))); // NOI18N
        jButtonAceptar.setBorderPainted(false);
        jButtonAceptar.setContentAreaFilled(false);
        jButtonAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });
        add(jButtonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 480, -1, -1));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoGeneros.png"))); // NOI18N
        add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        try {
            usuariosBO.actualizarGenerosRestringidos(generosRestringidos);
            control.actualizarPaneles();
            SwingUtilities.getWindowAncestor(this).dispose();
            javax.swing.JOptionPane.showMessageDialog(this, "Géneros restringidos actualizados correctamente.", "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } catch (tune.sistemabibliotecanegocio.exception.NegocioException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JPanel jPanelGeneros;
    private javax.swing.JScrollPane jScrollPaneGeneros;
    // End of variables declaration//GEN-END:variables
}
