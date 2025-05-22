/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package tune.sistemabibliotecapresentacion;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import tune.sistemabibliotecadominio.dtos.NuevoUsuarioDTO;
import tune.sistemabibliotecadominio.entidades.Usuario;
import tune.sistemabibliotecanegocio.interfaces.IUsuariosBO;
import tune.sistemabibliotecapresentacion.control.ControlNavegacion;
import tune.sistemabibliotecapresentacion.utils.FontManager;

/**
 *
 * @author leoca
 */
public class PanelEditarUsuario extends javax.swing.JPanel {

    /**
     * Creates new form PanelEditarUsuario
     */
    FontManager fontManager = new FontManager();
    Usuario usuarioActual;
    ControlNavegacion control;
    VentanaPrincipal ventanaPrincipal;
    IUsuariosBO usuariosBO;
    String contraseñaNueva;
    String rutaImagenSeleccionada;
    PanelPerfilUsuario panelPerfilUsuario;

    public PanelEditarUsuario(Usuario usuarioActual, ControlNavegacion control, VentanaPrincipal ventanaPrincipal, IUsuariosBO usuariosBO, PanelPerfilUsuario panelPerfilUsuario) {
        initComponents();
        this.control = control;
        this.ventanaPrincipal = ventanaPrincipal;
        this.usuariosBO = usuariosBO;
        this.usuarioActual = usuarioActual;
        this.panelPerfilUsuario = panelPerfilUsuario;
        establecerFormatos();
        establecerDatos();
    }

    public void establecerFormatos() {
        jTextFieldNombreUsuario.setFont(fontManager.getAfacadRegular(20));
        jTextFieldCorreo.setFont(fontManager.getAfacadRegular(20));
        jButtonCambiarContraseña.setFont(fontManager.getAfacadRegular(20));
        jTextFieldNombreUsuario.setBorder(new EmptyBorder(0, 20, 0, 0));
        jTextFieldCorreo.setBorder(new EmptyBorder(0, 20, 0, 0));
    }

    public void establecerDatos() {
        jTextFieldNombreUsuario.setText(usuarioActual.getNombreusuario());
        jTextFieldCorreo.setText(usuarioActual.getCorreo());
        String rutaImagen = usuarioActual.getImagenPerfil();
        if (rutaImagen != null && !rutaImagen.isEmpty()) {
            ImageIcon originalIcon = new ImageIcon(rutaImagen);
            if (originalIcon.getIconWidth() > 0 && originalIcon.getIconHeight() > 0) {
                Image imagenEscalada = originalIcon.getImage().getScaledInstance(
                        300,
                        300,
                        Image.SCALE_SMOOTH
                );
                jButtonImagenPerfil.setIcon(new ImageIcon(imagenEscalada));
            } else {
                jButtonImagenPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonAgregarImagen.png")));
            }
        } else {
            jButtonImagenPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonAgregarImagen.png")));
        }
    }

    public void mostrarPanelIngresarNuevaContraseñaFlotante() {
        JPanel fondoOscuro = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.setColor(new Color(0, 0, 0, 150));
                g.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            }
        };
        fondoOscuro.setOpaque(false);
        fondoOscuro.setLayout(new GridBagLayout());

        PanelIngresarNuevaContraseña panel = new PanelIngresarNuevaContraseña(control, ventanaPrincipal, usuariosBO, this);
        panel.setPreferredSize(new Dimension(774, 342));
        panel.setOpaque(true);
        fondoOscuro.add(panel);

        JDialog dialogo = new JDialog(ventanaPrincipal, Dialog.ModalityType.APPLICATION_MODAL);
        dialogo.setUndecorated(true);
        dialogo.setContentPane(fondoOscuro);
        dialogo.setSize(1138, 868); // Tamaño igual al frame principal o al fondo total
        dialogo.setLocationRelativeTo(ventanaPrincipal); // 🔥 Esto lo centra automáticamente
        dialogo.setBackground(new Color(0, 0, 0, 0));
        dialogo.setVisible(true);
    }

    public void setContraseñaNueva(String nuevaContraseña) {
        this.contraseñaNueva = nuevaContraseña;
        System.out.println("Contraseña nueva recibida: " + nuevaContraseña);
    }

    public void guardarCambios() {
        String nuevoNombre = jTextFieldNombreUsuario.getText().trim();
        String nuevoCorreo = jTextFieldCorreo.getText().trim();

        String rutaImagenPerfil = rutaImagenSeleccionada != null ? rutaImagenSeleccionada : usuarioActual.getImagenPerfil();

        NuevoUsuarioDTO dto = new NuevoUsuarioDTO();
        dto.setNombreusuario(nuevoNombre);
        dto.setCorreo(nuevoCorreo);
        dto.setImagenPerfil(rutaImagenPerfil);

        if (contraseñaNueva != null && !contraseñaNueva.isBlank()) {
            dto.setContrasena(contraseñaNueva);
        }

        try {
            usuariosBO.editarUsuario(dto);
            JOptionPane.showMessageDialog(this, "Usuario actualizado correctamente.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al guardar los cambios: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonImagenPerfil = new javax.swing.JButton();
        jTextFieldNombreUsuario = new javax.swing.JTextField();
        jTextFieldCorreo = new javax.swing.JTextField();
        jButtonCambiarContraseña = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonImagenPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonAgregarImagen.png"))); // NOI18N
        jButtonImagenPerfil.setBorderPainted(false);
        jButtonImagenPerfil.setContentAreaFilled(false);
        jButtonImagenPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonImagenPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImagenPerfilActionPerformed(evt);
            }
        });
        add(jButtonImagenPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 230, 200));

        jTextFieldNombreUsuario.setBackground(new java.awt.Color(66, 73, 64));
        jTextFieldNombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldNombreUsuario.setText("Usuario");
        jTextFieldNombreUsuario.setBorder(null);
        jTextFieldNombreUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        add(jTextFieldNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 390, 50));

        jTextFieldCorreo.setBackground(new java.awt.Color(66, 73, 64));
        jTextFieldCorreo.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldCorreo.setText("Correo");
        jTextFieldCorreo.setBorder(null);
        add(jTextFieldCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, 390, 50));

        jButtonCambiarContraseña.setBackground(new java.awt.Color(66, 73, 64));
        jButtonCambiarContraseña.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCambiarContraseña.setText("Cambiar contraseña");
        jButtonCambiarContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCambiarContraseñaActionPerformed(evt);
            }
        });
        add(jButtonCambiarContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, 390, 50));

        jButtonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BotonGuardar.png"))); // NOI18N
        jButtonGuardar.setBorderPainted(false);
        jButtonGuardar.setContentAreaFilled(false);
        jButtonGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });
        add(jButtonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 410, -1, -1));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/PanelEditarUsuario.png"))); // NOI18N
        add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCambiarContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCambiarContraseñaActionPerformed
        mostrarPanelIngresarNuevaContraseñaFlotante();

    }//GEN-LAST:event_jButtonCambiarContraseñaActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        guardarCambios();
        panelPerfilUsuario.actualizarDatos();
        SwingUtilities.getWindowAncestor(this).dispose();
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonImagenPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImagenPerfilActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Imágenes", "jpg", "png", "jpeg", "gif"));
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            rutaImagenSeleccionada = selectedFile.getAbsolutePath();

            ImageIcon originalIcon = new ImageIcon(rutaImagenSeleccionada);
            Image scaledImage = originalIcon.getImage().getScaledInstance(
                    jButtonImagenPerfil.getWidth(),
                    jButtonImagenPerfil.getHeight(),
                    Image.SCALE_SMOOTH
            );
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            jButtonImagenPerfil.setIcon(scaledIcon);

            JOptionPane.showMessageDialog(this, "Imagen de perfil cargada correctamente.");
        }
    }//GEN-LAST:event_jButtonImagenPerfilActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCambiarContraseña;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonImagenPerfil;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JTextField jTextFieldCorreo;
    private javax.swing.JTextField jTextFieldNombreUsuario;
    // End of variables declaration//GEN-END:variables
}
