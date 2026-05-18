package com.proyecto.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.proyecto.config.ConexionMySQLDatabase;
import com.proyecto.modelo.RegistrarEvento;

public class EventoDao {
    public boolean insertarEvento(RegistrarEvento evento) {
        try (Connection conn = ConexionMySQLDatabase.getConnection()) {
            String sql = "INSERT INTO eventos (nombreEvento, capacidadMaxima, lugarEvento, descripcion, telefonoContacto) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, evento.getNombreEvento());
            ps.setInt(2, evento.getCapacidadMaxima());
            ps.setString(3, evento.getLugarEvento());
            ps.setString(4, evento.getDescripcion());
            ps.setString(5, evento.getTelefonoContacto());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<RegistrarEvento> listarEventos() {
        List<RegistrarEvento> lista = new ArrayList<>();
        try (Connection conn = ConexionMySQLDatabase.getConnection()) {
            String sql = "SELECT nombreEvento, lugarEvento, capacidadMaxima, descripcion, telefonoContacto FROM eventos";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                RegistrarEvento ev = new RegistrarEvento(
                        rs.getString("nombreEvento"),
                        rs.getInt("capacidadMaxima"),
                        rs.getString("lugarEvento"),
                        rs.getString("descripcion"),
                        rs.getString("telefonoContacto"));
                lista.add(ev);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar eventos: " + e.getMessage());
        }
        return lista;
    }
}
