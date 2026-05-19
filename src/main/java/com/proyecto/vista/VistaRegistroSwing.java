package com.proyecto.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.proyecto.DAO.usuarioDao;
import com.proyecto.modelo.Registrarse;

public class VistaRegistroSwing extends JFrame implements ActionListener {

    private JTextField txtNombre, txtApellido, txtCorreo, txtCedula, txtTelefono, txtUsuario;
    private JPasswordField txtPassword;
    private JButton btnGuardar;

    public VistaRegistroSwing() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Registro de Usuario");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(8, 2, 10, 10));

        panel.add(new JLabel("Nombre:", SwingConstants.CENTER));
        txtNombre = new JTextField();
        panel.add(txtNombre);

        panel.add(new JLabel("Apellido:", SwingConstants.CENTER));
        txtApellido = new JTextField();
        panel.add(txtApellido);

        panel.add(new JLabel("Correo:", SwingConstants.CENTER));
        txtCorreo = new JTextField();
        panel.add(txtCorreo);

        panel.add(new JLabel("Cédula:", SwingConstants.CENTER));
        txtCedula = new JTextField();
        panel.add(txtCedula);

        panel.add(new JLabel("Teléfono:", SwingConstants.CENTER));
        txtTelefono = new JTextField();
        panel.add(txtTelefono);

        panel.add(new JLabel("Usuario:", SwingConstants.CENTER));
        txtUsuario = new JTextField();
        panel.add(txtUsuario);

        panel.add(new JLabel("Contraseña:", SwingConstants.CENTER));
        txtPassword = new JPasswordField();
        panel.add(txtPassword);

        btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(this);
        panel.add(btnGuardar);

        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            String correo = txtCorreo.getText();
            int cedula = Integer.parseInt(txtCedula.getText());
            String telefono = txtTelefono.getText();
            String usuario = txtUsuario.getText();
            String contraseña = new String(txtPassword.getPassword());

            Registrarse nuevo = new Registrarse(nombre, apellido, correo, cedula, telefono, usuario, contraseña);

            usuarioDao dao = new usuarioDao();
            dao.insertarUsuario(nuevo);

            JOptionPane.showMessageDialog(this, "✅ Usuario registrado con éxito");
            this.dispose(); // cerrar ventana de registro
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "❌ Error al registrar usuario: " + ex.getMessage());
        }
    }
}