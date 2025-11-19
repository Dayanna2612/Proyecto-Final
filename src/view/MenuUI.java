package view;

import controller.Controlador;
import model.Vuelo;

import javax.swing.*;
import java.awt.*;

public class MenuUI extends JFrame {

    private Controlador controlador;
    private JTextArea textArea;
    private Vuelo vueloEnEjecucion;

    public MenuUI() {
        controlador = new Controlador();
        vueloEnEjecucion = null;

        setTitle("Simulador de Aeropuerto");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10,10));

        JLabel titulo = new JLabel("Simulador de Aeropuerto");
        titulo.setFont(new Font("Arial", Font.BOLD, 28));
        titulo.setForeground(new Color(255, 165, 0));
        titulo.setHorizontalAlignment(JLabel.CENTER);
        add(titulo, BorderLayout.NORTH);

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.BOLD, 14));
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.GREEN);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(6, 1, 5, 5));
        panelBotones.setBackground(Color.DARK_GRAY);

        JButton btnAgregar = crearBoton("Registrar vuelo", Color.BLUE);
        JButton btnCola = crearBoton("Enviar a cola de espera", Color.MAGENTA);
        JButton btnEjecucion = crearBoton("Mover a ejecución", Color.ORANGE);
        JButton btnFinalizar = crearBoton("Finalizar vuelo", Color.RED);
        JButton btnMostrar = crearBoton("Mostrar estructuras", Color.CYAN);
        JButton btnSalir = crearBoton("Salir", Color.GRAY);

        panelBotones.add(btnAgregar);
        panelBotones.add(btnCola);
        panelBotones.add(btnEjecucion);
        panelBotones.add(btnFinalizar);
        panelBotones.add(btnMostrar);
        panelBotones.add(btnSalir);

        add(panelBotones, BorderLayout.EAST);

        btnAgregar.addActionListener(e -> registrarVuelo());
        btnCola.addActionListener(e -> enviarACola());
        btnEjecucion.addActionListener(e -> moverAEjecucion());
        btnFinalizar.addActionListener(e -> finalizarEjecucion());
        btnMostrar.addActionListener(e -> mostrarTodo());
        btnSalir.addActionListener(e -> System.exit(0));
    }

    private JButton crearBoton(String texto, Color colorFondo) {
        JButton btn = new JButton(texto);
        btn.setBackground(colorFondo);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Arial", Font.BOLD, 14));
        return btn;
    }

    private void registrarVuelo() {
        String codigo = JOptionPane.showInputDialog("Código del vuelo:");
        String destino = JOptionPane.showInputDialog("Destino:");
        String prioridadTxt = JOptionPane.showInputDialog("Prioridad (1–10):");
        int prioridad = Integer.parseInt(prioridadTxt);

        Vuelo v = new Vuelo(codigo, destino, prioridad);
        controlador.agregarVueloListaGlobal(v);

        textArea.append("Registrado: " + v + "\n");
        JOptionPane.showMessageDialog(this, "Vuelo registrado correctamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    private void enviarACola() {
        String codigo = JOptionPane.showInputDialog("Código del vuelo a encolar:");
        Vuelo encontrado = null;
        for (Vuelo v : controlador.getListaGlobal()) {
            if (v.getCodigo().equalsIgnoreCase(codigo)) {
                encontrado = v;
                break;
            }
        }
        if (encontrado != null) {
            controlador.encolarVuelo(encontrado);
            textArea.append("Encolado: " + encontrado + "\n");
        } else {
            JOptionPane.showMessageDialog(this, "Vuelo no encontrado!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void moverAEjecucion() {
        if (vueloEnEjecucion != null) {
            JOptionPane.showMessageDialog(this, "Ya hay un vuelo en ejecución!", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Vuelo v = controlador.moverAEnEjecucion();
        if (v == null) {
            JOptionPane.showMessageDialog(this, "Cola vacía!", "Info", JOptionPane.INFORMATION_MESSAGE);
        } else {
            vueloEnEjecucion = v;
            textArea.append("Ejecutando: " + v + "\n");
        }
    }

    private void finalizarEjecucion() {
        if (vueloEnEjecucion == null) {
            JOptionPane.showMessageDialog(this, "No hay vuelo en ejecución!", "Atención", JOptionPane.WARNING_MESSAGE);
        } else {
            controlador.finDeEjecucion(vueloEnEjecucion);
            textArea.append("Finalizado: " + vueloEnEjecucion + "\n");
            vueloEnEjecucion = null;
        }
    }

    private void mostrarTodo() {
        textArea.append("\n---- LISTA GLOBAL ----\n");
        for (Vuelo v : controlador.getListaGlobal()) textArea.append(v + "\n");

        textArea.append("\n---- COLA DE ESPERA ----\n");
        for (Vuelo v : controlador.getCola()) textArea.append(v + "\n");

        textArea.append("\n---- FINALIZADOS ----\n");
        for (Vuelo v : controlador.getFinalizados()) textArea.append(v + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuUI().setVisible(true));
    }
}
