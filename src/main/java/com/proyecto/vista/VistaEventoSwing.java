package com.proyecto.vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import com.proyecto.DAO.EventoDao;
import com.proyecto.DAO.ReservaDao;
import com.proyecto.modelo.RegistrarEvento;

public class VistaEventoSwing extends JPanel implements ActionListener {

    private JTable tablaEventos;
    private JButton btnRegistrar;
    private JButton btnReservar;
    private DefaultTableModel modelo;
    private int idCliente; 

    public VistaEventoSwing(int idCliente) {
        this.idCliente = idCliente;
        initComponents();
        cargarEventos();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        String[] columnas = {"ID", "Nombre", "Lugar", "Capacidad", "Descripción", "Teléfono"};
        modelo = new DefaultTableModel(columnas, 0);
        tablaEventos = new JTable(modelo);

        // Ocultar la columna ID
        tablaEventos.getColumnModel().getColumn(0).setMinWidth(0);
        tablaEventos.getColumnModel().getColumn(0).setMaxWidth(0);

        JScrollPane scrollPane = new JScrollPane(tablaEventos);

        JPanel panelBotones = new JPanel();
        btnRegistrar = new JButton("Registrar Evento");
        btnReservar = new JButton("Reservar Evento");

        btnRegistrar.addActionListener(this);
        btnReservar.addActionListener(this);

        panelBotones.add(btnRegistrar);
        panelBotones.add(btnReservar);

        add(scrollPane, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    public void cargarEventos() {
        modelo.setRowCount(0);
        EventoDao dao = new EventoDao();
        List<RegistrarEvento> lista = dao.listarEventos();

        for (RegistrarEvento ev : lista) {
            modelo.addRow(new Object[]{
                ev.getIdEvento(), // cargamos el ID oculto
                ev.getNombreEvento(),
                ev.getLugarEvento(),
                ev.getCapacidadMaxima(),
                ev.getDescripcion(),
                ev.getTelefonoContacto()
            });
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object fuente = e.getSource();

        if (fuente == btnRegistrar) {
            registrarEvento();
        } else if (fuente == btnReservar) {
            reservarEvento();
        }
    }

    private void registrarEvento() {
        String nombre = JOptionPane.showInputDialog(this, "Nombre del evento:");
        String lugar = JOptionPane.showInputDialog(this, "Lugar del evento:");
        String capacidadStr = JOptionPane.showInputDialog(this, "Capacidad máxima:");
        String descripcion = JOptionPane.showInputDialog(this, "Descripción:");
        String telefono = JOptionPane.showInputDialog(this, "Teléfono de contacto:");

        try {
            int capacidad = Integer.parseInt(capacidadStr);

            RegistrarEvento nuevo = new RegistrarEvento(telefono, capacidad, telefono, telefono, telefono);
            nuevo.setNombreEvento(nombre);
            nuevo.setLugarEvento(lugar);
            nuevo.setCapacidadMaxima(capacidad);
            nuevo.setDescripcion(descripcion);
            nuevo.setTelefonoContacto(telefono);

            EventoDao dao = new EventoDao();
            if (dao.insertarEvento(nuevo)) {
                JOptionPane.showMessageDialog(this, "✅ Evento registrado con éxito");
                cargarEventos();
            } else {
                JOptionPane.showMessageDialog(this, "❌ Error al registrar evento");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Capacidad debe ser un número válido");
        }
    }

    private void reservarEvento() {
        int fila = tablaEventos.getSelectedRow();
        if (fila != -1) {
            int idEvento = (int) tablaEventos.getValueAt(fila, 0); // usamos el ID oculto

            String fecha = JOptionPane.showInputDialog(this, "Ingrese fecha (YYYY-MM-DD):");
            String hora = JOptionPane.showInputDialog(this, "Ingrese hora (HH:MM):");
            String servicio = JOptionPane.showInputDialog(this, "Ingrese tipo de servicio:");

            ReservaDao reservaDao = new ReservaDao();
            boolean ok = reservaDao.reservarEvento(idEvento, idCliente, fecha, hora, servicio);

            if (ok) {
                JOptionPane.showMessageDialog(this, "✅ Reserva realizada con éxito");
            } else {
                JOptionPane.showMessageDialog(this, "❌ No se pudo realizar la reserva");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un evento de la tabla para reservar");
        }
    }
}