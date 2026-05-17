package com.proyecto.vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import com.proyecto.DAO.EventoDao;
import com.proyecto.modelo.RegistrarEvento;

public class VistaEventoSwing extends JPanel implements ActionListener {

    private JTable tablaEventos;
    private JButton btnRegistrar;
    private JButton btnReservar;
    private DefaultTableModel modelo;

    public VistaEventoSwing() {
        initComponents();
        cargarEventos();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        String[] columnas = {"ID", "Nombre", "Lugar", "Capacidad", "Descripción"};
        modelo = new DefaultTableModel(columnas, 0);
        tablaEventos = new JTable(modelo);
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

    private void cargarEventos() {
        modelo.setRowCount(0); // limpiar tabla
        EventoDao dao = new EventoDao();
        List<RegistrarEvento> lista = dao.listarEventos();

        for (RegistrarEvento ev : lista) {
            modelo.addRow(new Object[]{
                ev.getNombreEvento(),
                ev.getLugarEvento(),
                ev.getCapacidadMaxima(),
                ev.getDescripcion()
            });
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object fuente = e.getSource();

        if (fuente == btnRegistrar) {
            JOptionPane.showMessageDialog(this, "Abrir formulario para registrar evento");
            // Aquí abrirías tu VistaRegistroEventoSwing
        } else if (fuente == btnReservar) {
            int fila = tablaEventos.getSelectedRow();
            if (fila != -1) {
                int idEvento = (int) tablaEventos.getValueAt(fila, 0);
                JOptionPane.showMessageDialog(this, "Reservar evento con ID: " + idEvento);
                // Aquí llamarías a ReservaDao para reservar el evento
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un evento de la tabla para reservar");
            }
        }
    }
}
