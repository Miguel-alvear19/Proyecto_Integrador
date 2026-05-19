package com.proyecto.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.proyecto.DAO.usuarioDao; // tu DAO para validar login

public class VistaLoginSwing extends JFrame implements ActionListener {

    private JTextField txtCorreo;
    private JPasswordField txtPassword;
    private JButton btnIngresar;
    private JButton btnRegistrar;

    public VistaLoginSwing() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Inicio de Sesión");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblCorreo = new JLabel("Usuario");
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(lblCorreo, gbc);

        txtCorreo = new JTextField(20);
        gbc.gridx = 1; gbc.gridy = 0;
        panel.add(txtCorreo, gbc);

        JLabel lblPassword = new JLabel("Contraseña:");
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(lblPassword, gbc);

        txtPassword = new JPasswordField(20);
        gbc.gridx = 1; gbc.gridy = 1;
        panel.add(txtPassword, gbc);

        btnIngresar = new JButton("Ingresar");
        btnIngresar.addActionListener(this);
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(btnIngresar, gbc);

        btnRegistrar = new JButton("Registrarse");
        btnRegistrar.addActionListener(this);
        gbc.gridx = 1; gbc.gridy = 2;
        panel.add(btnRegistrar, gbc);

        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object fuente = e.getSource();

        if (fuente == btnIngresar) {
            String Usuario = txtCorreo.getText();
            String password = new String(txtPassword.getPassword());

            usuarioDao usuarioDao = new usuarioDao();
            boolean valido = usuarioDao.validarLogin(Usuario, password);

            if (valido) {
                JOptionPane.showMessageDialog(this, "✅ Inicio de sesión exitoso");
                // Abrir la ventana principal
                new VistaPrincipalSwing().setVisible(true);
                this.dispose(); // cerrar login
            } else {
                JOptionPane.showMessageDialog(this, "❌ Datos incorrectos, intente de nuevo");
            }
        } else if (fuente == btnRegistrar) {
            // Aquí puedes abrir tu formulario de registro
            JOptionPane.showMessageDialog(this, " Redirigiendo a registro...");
            new VistaRegistroSwing().setVisible(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VistaLoginSwing().setVisible(true));
    }
}

