package com.proyecto.modelo;

public class IniciarSesion {

    protected String Usuario;
    protected String Contraseña;
    private int idCliente;

    public IniciarSesion(String usuario, String contraseña, int idCliente) {
        this.Usuario = usuario;
        this.Contraseña = contraseña;
        this.idCliente = idCliente;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    

    

}
