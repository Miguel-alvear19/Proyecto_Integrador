package com.proyecto.vista;

import java.util.Scanner;
import com.proyecto.controlador.controladorEvento;

public class vistaEvento {
    private controladorEvento eventoCtrl;

    public vistaEvento() {
        eventoCtrl = new controladorEvento();
    }

    public void FormularioRegistroEvento() {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Registro de Evento ===");
        System.out.print("Nombre del evento: ");
        String nombreEvento = sc.nextLine();
        System.out.print("Capacidad máxima: ");
        int capacidadMaxima = sc.nextInt();
        sc.nextLine(); // limpiar buffer
        System.out.print("Lugar del evento: ");
        String lugarEvento = sc.nextLine();
        System.out.print("Descripción: ");
        String descripcion = sc.nextLine();
        System.out.print("Teléfono de contacto: ");
        String telefonoContacto = sc.nextLine();
        

        eventoCtrl.registrarEvento(nombreEvento, capacidadMaxima, lugarEvento, descripcion, telefonoContacto);
    }
}