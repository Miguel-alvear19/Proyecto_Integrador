package com.proyecto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.proyecto.config.ConexionMySQLDatabase;
import com.proyecto.controlador.controladorEvento;
import com.proyecto.vista.vistaEvento;
import com.proyecto.vista.vistaUsuario;
import com.proyecto.DAO.ReservaDao;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = ConexionMySQLDatabase.getConnection()) {
            if (conn != null) {
                System.out.println("✅ Conexión establecida correctamente.");

                // Ejemplo: ejecutar una consulta
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT NOW() AS fecha_actual");

                while (rs.next()) {
                    System.out.println("La base de datos respondió: " +
                            rs.getString("fecha_actual"));
                }
            } else {
                System.out.println("❌ No se pudo establecer la conexión.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //  vistaUsuario vista = new vistaUsuario();
        // // vista.registrarUsuario();

        // vista.inicioSesion();

        // // vistaEvento vistaEvento = new vistaEvento();
        // // vistaEvento.FormularioRegistroEvento();

        // ReservaDao reservaDAO = new ReservaDao();

        // // Caso válido: fecha futura
        // boolean resultado1 = reservaDAO.reservarEvento(1, 1, "2026-05-20", "18:00", "Entrada General");
        // System.out.println("Resultado caso válido: " + resultado1);

        // // Caso inválido: fecha pasada
        // boolean resultado2 = reservaDAO.reservarEvento(1, 1, "2025-05-10", "18:00", "Entrada General");
        // System.out.println("Resultado caso inválido: " + resultado2);

        
    }
}
