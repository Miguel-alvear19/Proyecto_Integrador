package com.proyecto.vista;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VistaPrincipalSwing extends JFrame implements ActionListener {

    // Constantes para los paneles
    private static final String PANEL_INICIO = "PANEL_INICIO";
    private static final String PANEL_EVENTOS = "PANEL_EVENTOS";
    private static final String PANEL_INFO = "PANEL_INFO";
    private static final String PANEL_CONSULTAR = "PANEL_CONSULTAR";

    private CardLayout cardLayout;
    private JPanel panelContenedor;

    // Menú items
    private JMenuItem menuItemInicio;
    private JMenuItem menuItemSalir;
    private JMenuItem menuItemEventos;
    private JMenuItem menuItemInfo;
    private JMenuItem menuItemConsultar;

    private VistaEventoSwing vistaEvento;

    public VistaPrincipalSwing() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Sistema de Gestión de Eventos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        panelContenedor = new JPanel(cardLayout);

        vistaEvento = new VistaEventoSwing();

        // Paneles
        JPanel panelInicio = crearPanel("Bienvenido al sistema");
        JPanel panelEventos = crearPanel("Gestión de Eventos");
        JPanel panelInfo = crearPanel("Información del sistema");
        JPanel panelConsultar = crearPanel("Consultar Reservas");

        panelContenedor.add(panelInicio, PANEL_INICIO);
        panelContenedor.add(panelEventos, PANEL_EVENTOS);
        panelContenedor.add(panelInfo, PANEL_INFO);
        panelContenedor.add(panelConsultar, PANEL_CONSULTAR);
        panelContenedor.add(vistaEvento, PANEL_EVENTOS);

        configurarMenu();

        add(panelContenedor);
        cardLayout.show(panelContenedor, PANEL_INICIO);
    }

    private JPanel crearPanel(String mensaje) {
        JPanel panel = new JPanel();
        JLabel label = new JLabel(mensaje);
        label.setFont(new Font("Segoe UI", Font.BOLD, 18));
        label.setForeground(new Color(41, 128, 185));
        panel.add(label);
        return panel;
    }

    private void configurarMenu() {
        JMenuBar menuBar = new JMenuBar();

        // Menú Archivo
        JMenu menuArchivo = new JMenu("Archivo");
        menuItemInicio = new JMenuItem("Inicio");
        menuItemSalir = new JMenuItem("Salir");
        menuItemInicio.addActionListener(this);
        menuItemSalir.addActionListener(this);
        menuArchivo.add(menuItemInicio);
        menuArchivo.add(menuItemSalir);

        // Menú Eventos
        JMenu menuEventos = new JMenu("Eventos");
        menuItemEventos = new JMenuItem("Gestión de Eventos");
        menuItemEventos.addActionListener(this);
        menuEventos.add(menuItemEventos);

        // Menú Información
        JMenu menuInfo = new JMenu("Información");
        menuItemInfo = new JMenuItem("Acerca del sistema");
        menuItemInfo.addActionListener(this);
        menuInfo.add(menuItemInfo);

        // Menú Consultar
        JMenu menuConsultar = new JMenu("Consultar");
        menuItemConsultar = new JMenuItem("Consultar Reservas");
        menuItemConsultar.addActionListener(this);
        menuConsultar.add(menuItemConsultar);

        menuBar.add(menuArchivo);
        menuBar.add(menuEventos);
        menuBar.add(menuInfo);
        menuBar.add(menuConsultar);

        setJMenuBar(menuBar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object fuente = e.getSource();

        if (fuente == menuItemSalir) {
            System.exit(0);
        } else if (fuente == menuItemInicio) {
            cardLayout.show(panelContenedor, PANEL_INICIO);
        } else if (fuente == menuItemEventos) {
            cardLayout.show(panelContenedor, PANEL_EVENTOS);
        } else if (fuente == menuItemInfo) {
            cardLayout.show(panelContenedor, PANEL_INFO);
        } else if (fuente == menuItemConsultar) {
            cardLayout.show(panelContenedor, PANEL_CONSULTAR);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VistaPrincipalSwing().setVisible(true));
    }
}

