package com.proyecto.modelo;


public class ReservarEvento {

    private String fechaReserva;
    private String horaReserva;
    private String servicio;

    public ReservarEvento(String fechaReserva, String horaReserva, String servicio) {
        this.fechaReserva = fechaReserva;
        this.horaReserva = horaReserva;
        this.servicio = servicio;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getHoraReserva() {
        return horaReserva;
    }

    public void setHoraReserva(String horaReserva) {
        this.horaReserva = horaReserva;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

}
