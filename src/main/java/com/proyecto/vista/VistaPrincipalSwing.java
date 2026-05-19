package com.proyecto.vista;

import java.awt.CardLayout;
import java.awt.BorderLayout;
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

    // Vista de eventos con la tabla
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

        // Instancias de paneles
        vistaEvento = new VistaEventoSwing();
        JPanel panelInicio = crearPanel("Bienvenidos al Sistema de Gestion de Eventos Mayra Ponce");
        JPanel panelInfo = crearPanelInfo();
        JPanel panelConsultar = crearPanel("Consultar Reservas");

        // Agregar al contenedor
        panelContenedor.add(panelInicio, PANEL_INICIO);
        panelContenedor.add(vistaEvento, PANEL_EVENTOS);
        panelContenedor.add(panelInfo, PANEL_INFO);
        panelContenedor.add(panelConsultar, PANEL_CONSULTAR);

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

    private JPanel crearPanelInfo() {
        JPanel panel = new JPanel(new BorderLayout());

        // NORTH: título
        JLabel lblTitulo = new JLabel("Información adicional de contacto", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTitulo.setForeground(new Color(41, 128, 185));
        panel.add(lblTitulo, BorderLayout.NORTH);

        // WEST: Instagram
        JLabel lblInstagram = new JLabel("<html>Instagram:<br>https://www.instagram.com/mayraponceasesora</html>",
                SwingConstants.CENTER);
        lblInstagram.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblInstagram.setForeground(Color.black);
        panel.add(lblInstagram, BorderLayout.WEST);

        // CENTER: Facebook
        JLabel lblFacebook = new JLabel("<html>Facebook:<br>Mayra Ponce</html>", SwingConstants.CENTER);
        lblFacebook.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblFacebook.setForeground(Color.black);
        panel.add(lblFacebook, BorderLayout.CENTER);

        // EAST: TikTok
        JLabel lblTikTok = new JLabel("<html>TikTok:<br>www.tiktok.com/@mayraponcee</html>", SwingConstants.CENTER);
        lblTikTok.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblTikTok.setForeground(Color.black);
        panel.add(lblTikTok, BorderLayout.EAST);

        return panel;
    }

    private void configurarMenu() {
        JMenuBar menuBar = new JMenuBar();

        // Menú Archivo
        JMenu menuArchivo = new JMenu("Archivo");
        menuArchivo.setForeground(Color.BLACK);
        menuArchivo.setFont(new Font("Segoe UI", Font.BOLD, 12));
        menuItemInicio = new JMenuItem("Inicio");
        menuItemSalir = new JMenuItem("Salir");
        menuItemInicio.addActionListener(this);
        menuItemSalir.addActionListener(this);
        menuArchivo.add(menuItemInicio);
        menuArchivo.add(menuItemSalir);

        // Menú Eventos
        JMenu menuEventos = new JMenu("Eventos");
        menuEventos.setForeground(Color.BLACK);
        menuEventos.setFont(new Font("Segoe UI", Font.BOLD, 12));

        menuItemEventos = new JMenuItem("Gestión de Eventos");
        menuItemEventos.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        menuItemEventos.setBackground(new Color(52, 73, 94));
        menuItemEventos.setForeground(Color.WHITE);
        menuItemEventos.addActionListener(this);
        menuEventos.add(menuItemEventos);

        // Menú Información
        JMenu menuInfo = new JMenu("Información");
        menuInfo.setForeground(Color.BLACK);
        menuInfo.setFont(new Font("Segoe UI", Font.BOLD, 12));
        menuItemInfo = new JMenuItem("Acerca de Nosotros");
        menuItemInfo.addActionListener(this);
        menuInfo.add(menuItemInfo);

        // Menú Consultar
        JMenu menuConsultar = new JMenu("Consultar");
        menuConsultar.setForeground(Color.BLACK);
        menuConsultar.setFont(new Font("Segoe UI", Font.BOLD, 12));
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