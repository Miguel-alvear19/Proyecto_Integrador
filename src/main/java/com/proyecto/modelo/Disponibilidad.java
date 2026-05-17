package com.proyecto.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.proyecto.config.ConexionMySQLDatabase;

public class Disponibilidad {

    // Valida que la fecha/hora sea futura y que no esté ocupada
    public static boolean validarDisponibilidad(int idEvento, String fecha, String hora) {
        try {
            // 1. Validar que la fecha/hora ingresada sea futura
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime fechaHoraIngresada = LocalDateTime.parse(fecha + " " + hora, formatter);
            LocalDateTime ahora = LocalDateTime.now();

            if (fechaHoraIngresada.isBefore(ahora)) {
                System.out.println("❌ La fecha/hora ingresada ya pasó.");
                return false;
            }

            // 2. Validar que no exista otra reserva en esa fecha/hora para el mismo evento
            try (Connection conn = ConexionMySQLDatabase.getConnection()) {
                String sql = "SELECT COUNT(*) FROM reservas WHERE idEvento = ? AND fechaReserva = ? AND horaReserva = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, idEvento);
                ps.setString(2, fecha);
                ps.setString(3, hora);
                ResultSet rs = ps.executeQuery();

                if (rs.next() && rs.getInt(1) > 0) {
                    System.out.println("❌ La fecha/hora ya está ocupada para este evento.");
                    return false;
                }
            }

            return true;

        } catch (Exception e) {
            System.out.println("❌ Error al validar disponibilidad: " + e.getMessage());
            return false;
        }
    }
}
