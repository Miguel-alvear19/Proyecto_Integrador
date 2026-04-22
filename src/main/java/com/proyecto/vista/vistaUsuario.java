package com.proyecto.vista;

import java.util.Scanner;
import com.proyecto.controlador.controladorUsuario;

public class vistaUsuario {
    Scanner scanner = new Scanner(System.in);

    public void registrarUsuario() {
        System.out.println("Ingrese su nombre:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese su apellido:");
        String apellido = scanner.nextLine();

        System.out.println("Ingrese su correo electrónico:");
        String correo = scanner.nextLine();

        System.out.println("Ingrese su número de cédula:");
        int numeroCedula = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        System.out.println("Ingrese su número de teléfono:");
        String telefono = scanner.nextLine();

        System.out.println("Ingrese un nombre de usuario:");
        String usuario = scanner.nextLine();

        System.out.println("Ingrese una contraseña:");
        String contraseña = scanner.nextLine();

        controladorUsuario ctrl = new controladorUsuario();
        ctrl.registrarUsuario(nombre, apellido, correo, numeroCedula, telefono, usuario, contraseña);
        System.out.println("Usuario registrado exitosamente.");
    }

    public void inicioSesion() {
        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contraseña = scanner.nextLine();

        controladorUsuario ctrl = new controladorUsuario();
        if (ctrl.iniciarSesion(usuario, contraseña)) {
            System.out.println("Inicio de sesión exitoso. Bienvenido " + usuario);
            // aquí puedes mostrar el menú principal
        } else {
            System.out.println("Usuario o contraseña incorrectos.");
        }

    }

}