package com.proyecto.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.proyecto.config.ConexionMySQLDatabase;
import com.proyecto.modelo.Registrarse;

public class usuarioDao {

        public void insertarUsuario(Registrarse usuario) {
            try (Connection conn = ConexionMySQLDatabase.getConnection()) {
                String sql = "INSERT INTO usuarios (nombre, apellido, correo, numeroCedula, telefono, usuario, contraseña) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, usuario.getNombre());
                ps.setString(2, usuario.getApellido());
                ps.setString(3, usuario.getCorreo());
                ps.setInt(4, usuario.getNumeroCedula());
                ps.setString(5, usuario.getTelefono());
                ps.setString(6, usuario.getUsuario());
                ps.setString(7, usuario.getContraseña());
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }




