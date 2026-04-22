package com.proyecto.controlador;

import com.proyecto.DAO.usuarioDao;
import com.proyecto.modelo.Registrarse;

public class controladorUsuario {
    private usuarioDao usuarioDao;

    public controladorUsuario() {
        usuarioDao = new usuarioDao();
    }

    public void registrarUsuario(String nombre, String apellido, String correo, int numeroCedula,
                                 String telefono, String usuario, String contraseña) {
        Registrarse nuevoUsuario = new Registrarse(nombre, apellido, correo, numeroCedula, telefono, usuario, contraseña);
        usuarioDao.insertarUsuario(nuevoUsuario);
    }

    public boolean iniciarSesion(String usuario, String contraseña) {
    return usuarioDao.validarLogin(usuario, contraseña);
}

}
