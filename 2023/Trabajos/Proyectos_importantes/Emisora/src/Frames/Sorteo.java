/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frames;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Sorteo extends JFrame {

  private JTable table;
    private DefaultTableModel tableModel;
    private List<String> NombreGanador;
    private Encuesta1 encuesta;
    private List<Persona> personas;
    private static boolean sorteoFrameOpen = false;
    private List<Persona> personasEncuesta;
    private int indiceGanador = -1;

    public static boolean isSorteoFrameOpen() {
        return sorteoFrameOpen;
    }

    public class ConfigManager {
        private static final String CONFIG_FILE = "config.txt";
        private static int indiceGanador = -1;

        public static void cargarConfiguracion() {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(CONFIG_FILE));
                String linea = reader.readLine();
                if (linea != null) {
                    indiceGanador = Integer.parseInt(linea);
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void guardarConfiguracion() {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(CONFIG_FILE));
                writer.write(String.valueOf(indiceGanador));
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static int getIndiceGanador() {
            return indiceGanador;
        }

        public static void setIndiceGanador(int indice) {
            indiceGanador = indice;
        }
    }

    public Sorteo(Encuesta1 encuesta, List<Persona> personas) {
        this.encuesta = encuesta;
        this.personas = personas;
        this.personasEncuesta = personas;
        sorteoFrameOpen = true;

        setTitle("Sorteo: ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Numero ganador");
        tableModel.addColumn("Color ganador");

        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        cargarNombreGanador();
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));

        JButton siguienteButton = new JButton("Volver al inicio");
        siguienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Encuesta1 eGUI = new Encuesta1();
                eGUI.setVisible(true);
                dispose();
            }
        });
        buttonPanel.add(siguienteButton);

        JButton siguienteButton2 = new JButton("Elegir nuevo ganador");
        siguienteButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elegirNuevoGanador();
            }
        });
        buttonPanel.add(siguienteButton2);

        panel.add(buttonPanel, BorderLayout.SOUTH);
        add(panel);
    }

    private void elegirNuevoGanador() {
        if (personasEncuesta.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay personas en la lista.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Random random = new Random();
        int indiceGanadorAnterior = ConfigManager.getIndiceGanador();
        int nuevoIndiceGanador;

        do {
            nuevoIndiceGanador = random.nextInt(personasEncuesta.size());
        } while (nuevoIndiceGanador == indiceGanadorAnterior);

        ConfigManager.setIndiceGanador(nuevoIndiceGanador);
        ConfigManager.guardarConfiguracion();
        actualizarTabla();
    }

    private void cargarNombreGanador() {
        List<Persona> personasEncuesta = encuesta.getPersonas();

        if (personasEncuesta.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay personas en la lista.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ConfigManager.cargarConfiguracion();
        indiceGanador = ConfigManager.getIndiceGanador();

        if (indiceGanador >= 0 && indiceGanador < personasEncuesta.size()) {
            Persona ganador = personasEncuesta.get(indiceGanador);
            Object[] rowData = {
                indiceGanador + 1,
                ganador.getNombre(),
                ganador.getColor()
            };
            tableModel.addRow(rowData);
            table.getColumnModel().getColumn(2).setCellRenderer(new ColorRenderer());
        }
    }

    private void actualizarTabla() {
        tableModel.setRowCount(0);
        ConfigManager.cargarConfiguracion();
        int indiceGanador = ConfigManager.getIndiceGanador();

        if (indiceGanador >= 0 && indiceGanador < personasEncuesta.size()) {
            Persona ganador = personasEncuesta.get(indiceGanador);
            Object[] rowData = {
                indiceGanador + 1,
                ganador.getNombre(),
                ganador.getColor()
            };
            tableModel.addRow(rowData);
            table.getColumnModel().getColumn(2).setCellRenderer(new ColorRenderer());
        } else {
            JOptionPane.showMessageDialog(this, "Índice de ganador no válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    class ColorRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(
                JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            if (value instanceof Color) {
                Color color = (Color) value;
                component.setBackground(color);
                component.setForeground(new Color(0, 0, 0, 0));
            }

            return component;
        }
    }
}
