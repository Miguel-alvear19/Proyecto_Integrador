package com.proyecto.modelo;


public class ReservarEvento {

    private int idEvento; 
    private int idCliente; 
    private String fechaReserva;
    private String horaReserva;
    private String servicio;

    public ReservarEvento(int idEvento, int idCliente, String fechaReserva, String horaReserva, String servicio) {
        this.idEvento = idEvento;
        this.idCliente = idCliente;
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

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    

}
