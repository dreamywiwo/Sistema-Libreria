/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package tune.sistemabibliotecapresentacion;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import tune.sistemabibliotecadominio.dtos.NuevoUsuarioDTO;
import tune.sistemabibliotecanegocio.exception.NegocioException;
import tune.sistemabibliotecapresentacion.control.ControlNavegacion;
import tune.sistemabibliotecapresentacion.utils.FontManager;

/**
 *
 * @author Dana Chavez
 */
public class InicioSesion extends javax.swing.JPanel {

    FontManager fontManager = new FontManager();
    VentanaRegistro ventanaPrincipal;
    ControlNavegacion control;

    public InicioSesion(ControlNavegacion control, VentanaRegistro ventanaPrincipal) {
        initComponents();
        this.ventanaPrincipal = ventanaPrincipal;
        this.control = control;
        setOpaque(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelLogo = new javax.swing.JLabel();
        jButtonRegistro = new javax.swing.JButton();
        jTextFieldCorreo1 = new javax.swing.JTextField();
        jPassword1 = new javax.swing.JPasswordField();
        jButtonContinuar1 = new javax.swing.JButton();
        jLabelRegistro = new javax.swing.JLabel();
        jLabelTitulo = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(580, 570));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LogoMusica.png"))); // NOI18N
        add(jLabelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 6, 240, 250));

        jButtonRegistro.setFont(fontManager.getAfacadMedium(15f));
        jButtonRegistro.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRegistro.setText("Registrate aqui.");
        jButtonRegistro.setBorder(null);
        jButtonRegistro.setContentAreaFilled(false);
        jButtonRegistro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistroActionPerformed(evt);
            }
        });
        add(jButtonRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 510, -1, -1));

        jTextFieldCorreo1.setBackground(new java.awt.Color(7, 76, 64));
        jTextFieldCorreo1.setFont(fontManager.getAfacadRegular(20f));
        jTextFieldCorreo1.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldCorreo1.setText("   E-mail");
        jTextFieldCorreo1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTextFieldCorreo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCorreo1ActionPerformed(evt);
            }
        });
        add(jTextFieldCorreo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 248, 49));

        jPassword1.setBackground(new java.awt.Color(7, 76, 64));
        jPassword1.setFont(fontManager.getAfacadRegular(20f));
        jPassword1.setForeground(new java.awt.Color(255, 255, 255));
        jPassword1.setText("Contrasena");
        jPassword1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        add(jPassword1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 380, 248, 49));

        jButtonContinuar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonContinuar.png"))); // NOI18N
        jButtonContinuar1.setBorder(null);
        jButtonContinuar1.setContentAreaFilled(false);
        jButtonContinuar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonContinuar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonContinuar1ActionPerformed(evt);
            }
        });
        add(jButtonContinuar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 440, -1, -1));

        jLabelRegistro.setFont(fontManager.getAfacadMedium(15f));
        jLabelRegistro.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRegistro.setText("No tienes una cuenta?");
        add(jLabelRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 510, 129, -1));

        jLabelTitulo.setFont(fontManager.getAfacadBold(52f));
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setText("Iniciar Sesion");
        add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 281, 65));
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonContinuar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonContinuar1ActionPerformed
        NuevoUsuarioDTO usuario = new NuevoUsuarioDTO();
        usuario.setCorreo(jTextFieldCorreo1.getText());
        usuario.setContrasena(jPassword1.getText());

        try {
            control.iniciarSesion(usuario);
            ventanaPrincipal.cerrar();
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Error al iniciar sesión",
                    JOptionPane.ERROR_MESSAGE
            );
            Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonContinuar1ActionPerformed

    private void jButtonRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistroActionPerformed
        ventanaPrincipal.mostrarRegistro();
    }//GEN-LAST:event_jButtonRegistroActionPerformed

    private void jTextFieldCorreo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCorreo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCorreo1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonContinuar1;
    private javax.swing.JButton jButtonRegistro;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelRegistro;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPasswordField jPassword1;
    private javax.swing.JTextField jTextFieldCorreo1;
    // End of variables declaration//GEN-END:variables
}
