package com.proyecto.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.proyecto.config.ConexionMySQLDatabase;
import com.proyecto.modelo.Disponibilidad;

public class ReservaDao {

    public boolean reservarEvento(int idEvento, int idCliente, String fechaReserva, String horaReserva, String servicio) {
        try (Connection conn = ConexionMySQLDatabase.getConnection()) {

            // 1. Validar disponibilidad con la clase Disponibilidad
            if (!Disponibilidad.validarDisponibilidad(idEvento, fechaReserva, horaReserva)) {
                System.out.println("❌ No se puede reservar: la fecha/hora ingresada ya pasó.");
                return false;
            }

            // 2. Insertar la reserva en la tabla
            String sqlInsert = "INSERT INTO reservas (idEvento, idCliente, fechaReserva, horaReserva, servicio) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement psInsert = conn.prepareStatement(sqlInsert);
            psInsert.setInt(1, idEvento);
            psInsert.setInt(2, idCliente);
            psInsert.setString(3, fechaReserva);
            psInsert.setString(4, horaReserva);
            psInsert.setString(5, servicio);
            psInsert.executeUpdate();

            System.out.println("✅ Reserva realizada con éxito.");
            return true;

        } catch (SQLException e) {
            System.out.println("Error al reservar evento: " + e.getMessage());
            return false;
        }
    }
}