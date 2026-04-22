package com.proyecto.controlador;

import com.proyecto.DAO.EventoDao;

import com.proyecto.modelo.RegistrarEvento;


public class controladorEvento {
    private EventoDao eventoDao;

    public controladorEvento() {
        eventoDao = new EventoDao();
    }

    public void registrarEvento(String nombreEvento, int capacidadMaxima, String lugarEvento,
            String descripcion, String telefonoContacto) {
        RegistrarEvento evento = new RegistrarEvento(nombreEvento, capacidadMaxima, lugarEvento, descripcion, telefonoContacto);
        boolean guardado = eventoDao.insertarEvento(evento);

        if (guardado) {
            System.out.println("Evento registrado correctamente.");
        } else {
            System.out.println("Error al registrar el evento.");
        }
    }
}
