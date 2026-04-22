package com.proyecto.modelo;

public class RegistrarEvento {

    private String nombreEvento;
    private int capacidadMaxima;
    private String lugarEvento;
    private String descripcion;
    private String telefonoContacto;

    public RegistrarEvento(String nombreEvento, int capacidadMaxima, String lugarEvento, String descripcion,
            String telefonoContacto2) {
        this.nombreEvento = nombreEvento;
        this.capacidadMaxima = capacidadMaxima;
        this.lugarEvento = lugarEvento;
        this.descripcion = descripcion;
        this.telefonoContacto = telefonoContacto2;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public String getLugarEvento() {
        return lugarEvento;
    }

    public void setLugarEvento(String lugarEvento) {
        this.lugarEvento = lugarEvento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    

}
