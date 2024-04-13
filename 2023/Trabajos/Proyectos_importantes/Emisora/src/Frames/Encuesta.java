/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frames;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Encuesta extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private List<Dato> datos = new ArrayList<>();

    private int currentID = 51; // Comienza desde 51
    private int currentSorteo = 51; // Comienza desde 51
    private int currentColorIndex = 0;

    private List<Color> coloresFondo = new ArrayList<>(Arrays.asList(
            Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE, Color.YELLOW,
            Color.CYAN, Color.MAGENTA, Color.PINK, Color.LIGHT_GRAY, Color.DARK_GRAY,
            new Color(255, 165, 0), new Color(128, 0, 128), new Color(0, 128, 0),
            new Color(255, 0, 0), new Color(0, 0, 255), new Color(255, 255, 0),
            new Color(0, 255, 255), new Color(255, 0, 255), new Color(128, 128, 0),
            new Color(128, 0, 0), new Color(0, 128, 128), new Color(0, 0, 128),
            new Color(128, 128, 128), new Color(192, 192, 192), new Color(255, 192, 203),
            new Color(255, 140, 0), Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE,
            Color.YELLOW, Color.CYAN, Color.MAGENTA, Color.PINK, Color.LIGHT_GRAY,
            Color.DARK_GRAY, Color.BLACK, new Color(255, 165, 0), new Color(128, 0, 128),
            new Color(0, 128, 0), new Color(255, 0, 0), new Color(0, 0, 255),
            new Color(255, 255, 0), new Color(0, 255, 255), new Color(255, 0, 255),
            new Color(128, 128, 0), new Color(128, 0, 0), new Color(0, 128, 128),
            new Color(0, 0, 128), new Color(128, 128, 128), new Color(192, 192, 192),
            new Color(255, 192, 203), new Color(255, 140, 0), new Color(0, 0, 0)
    ));

    public Encuesta() {
        setTitle("Encuesta");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Número de Sorteo");
        tableModel.addColumn("Dirección");
        tableModel.addColumn("Color");

        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        cargarDatos();
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton siguienteButton = new JButton("Siguiente");

        siguienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear una instancia de Cancion
                Cancion cancionGUI = new Cancion();
                cancionGUI.setVisible(true);

                // Cerrar la instancia actual de Encuesta si es necesario
                dispose();
            }
        });
        panel.add(siguienteButton, BorderLayout.SOUTH); // Agregar el botón en la parte inferior del panel

        JPanel buttonPanel = new JPanel();
        JButton agregarButton = new JButton("Agregar");
        JButton modificarButton = new JButton("Modificar");
        JButton eliminarButton = new JButton("Eliminar");

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nuevoNombre = JOptionPane.showInputDialog("Ingrese un nuevo nombre:");
                String nuevaDireccion = JOptionPane.showInputDialog("Ingrese una nueva dirección:");

                if (nuevoNombre != null && nuevaDireccion != null) {
                    agregarPersona(nuevoNombre, nuevaDireccion);
                }
            }
        });
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    String nombreActual = (String) tableModel.getValueAt(selectedRow, 1);
                    String direccionActual = (String) tableModel.getValueAt(selectedRow, 3);

                    String nuevoNombre = JOptionPane.showInputDialog("Modificar nombre:", nombreActual);
                    String nuevaDireccion = JOptionPane.showInputDialog("Modificar dirección:", direccionActual);

                    if (nuevoNombre != null && nuevaDireccion != null) {
                        modificarPersona(selectedRow, nuevoNombre, nuevaDireccion);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una fila para modificar.");
                }
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    eliminarPersona(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar.");
                }
            }
        });

        buttonPanel.add(agregarButton);
        buttonPanel.add(modificarButton);
        buttonPanel.add(eliminarButton);
        panel.add(buttonPanel, BorderLayout.NORTH);

        add(panel);
    }

    public void agregarPersona(String nombre, String direccion) {
        // Verifica si se han agotado los colores y reinicia el índice si es necesario
        if (currentColorIndex >= coloresFondo.size()) {
            currentColorIndex = 0;
        }

        // Obtiene el color actual y avanza el índice
        Color color = coloresFondo.get(currentColorIndex);
        currentColorIndex++;

        Dato nuevoDato = new Dato(currentID, nombre, currentSorteo, direccion, color);

        datos.add(nuevoDato);
        Object[] rowData = {
            nuevoDato.getId(),
            nuevoDato.getNombre(),
            nuevoDato.getSorteo(),
            nuevoDato.getDireccion(),
            nuevoDato.getColor()
        };
        tableModel.addRow(rowData);
        currentID++;
        currentSorteo++;
    }

    public void modificarPersona(int rowIndex, String nuevoNombre, String nuevaDireccion) {
        Dato dato = datos.get(rowIndex);
        dato.setNombre(nuevoNombre);
        dato.setDireccion(nuevaDireccion);
        tableModel.setValueAt(nuevoNombre, rowIndex, 1);
        tableModel.setValueAt(nuevaDireccion, rowIndex, 3);
    }

    public void eliminarPersona(int rowIndex) {
        datos.remove(rowIndex);
        tableModel.removeRow(rowIndex
      );
    }

    private void cargarDatos() {
        List<String> nombres = Arrays.asList(
            "Adriana González", "Pedro Rodríguez", "Ana Martínez", "Carlos López",
            "Laura Pérez", "Manuel García", "Isabel Sánchez", "David Romero",
            "Sofía Fernández", "Luis Torres", "María Ruiz", "José Jiménez",
            "Ana Moreno", "Carlos Herrera", "Laura Castro", "Manuel Ortega",
            "Isabel Flores", "David Delgado", "Sofía Morales", "Luis Ramírez",
            "María González", "José Rodríguez", "Ana Martínez", "Carlos López",
            "Laura Pérez", "Manuel García", "Isabel Sánchez", "David Romero",
            "Sofía Fernández", "Luis Torres", "María Ruiz", "José Jiménez",
            "Ana Moreno", "Carlos Herrera", "Laura Castro", "Manuel Ortega",
            "Isabel Flores", "David Delgado", "Sofía Morales", "Luis Ramírez",
            "María González", "José Rodríguez", "Ana Martínez", "Carlos López",
            "Laura Pérez", "Manuel Delgado", "Martha Morales", "Juan Ramírez",
            "Gabriela Torres", "Hitler Rodolfo"
        );

        List<Integer> ids = new ArrayList<>();
        for (int i = 1; i <= nombres.size(); i++) {
            ids.add(i);
        }

        List<Integer> numerosSorteo = new ArrayList<>();
        for (int i = 1; i <= nombres.size(); i++) {
            numerosSorteo.add(i);
        }
        

        
        // Generar direcciones aleatorias
       List<String> direccionesFijas = Arrays.asList(
    "123 Calle Principal", "456 Avenida Secundaria", "789 Camino Peatonal",
    "987 Callejón Oscuro", "654 Avenida Luminosa",
    "321 Boulevard del Sol", "567 Ruta del Bosque", "890 Paseo Marítimo",
    "1234 Carrera del Arte", "5678 Avenida de los Sueños",
    "111 Avenida Primavera", "222 Calle del Recuerdo", "333 Callejón del Deseo",
    "444 Camino de la Imaginación", "555 Avenida de la Creatividad",
    "666 Pasaje de los Sueños", "777 Calle de la Esperanza", "888 Ruta del Corazón",
    "999 Avenida de la Amistad", "1010 Calle del Abrazo",
    "2020 Paseo de la Alegría", "3030 Camino de la Felicidad",
    "4040 Avenida de la Ilusión", "5050 Ruta de los Recuerdos",
    "6060 Calle de la Gratitud", "7070 Avenida del Éxito",
    "8080 Paseo de la Inspiración", "9090 Ruta de la Esperanza",
    "12345 Calle del Destino", "67890 Avenida de la Fortuna",
    "13579 Camino de la Serenidad", "24680 Calle de la Plenitud",
    "98765 Avenida de la Armonía", "43210 Ruta de la Prosperidad",
    "11223 Calle de la Sabiduría", "44556 Avenida de la Paz",
    "77889 Camino de la Abundancia", "99000 Ruta de la Felicidad",
    "11111 Avenida de la Gratitud", "22222 Calle de la Inspiración",
    "33333 Paseo de la Esperanza", "44444 Ruta de la Creatividad",
    "55555 Avenida de los Sueños", "66666 Camino de la Imaginación",
    "77777 Callejón de la Alegría", "88888 Ruta de la Amistad",
    "99999 Avenida del Amor", "99988 Avenida Chicunguña", "999887 Casa abandonada", "76843 casa de Hitler"
    
);
       
         
        //Colores que apareceran pintados en el apartado color
     
       
       

       
        // Agregar datos a la tabla
        for (int i = 0; i < nombres.size(); i++) {
            Object[] rowData = {
                ids.get(i),
                nombres.get(i),
                numerosSorteo.get(i),
                direccionesFijas.get(i),
                coloresFondo.get(i)
            };
            tableModel.addRow(rowData);
        }

        table.getColumnModel().getColumn(4).setCellRenderer(new ColorRenderer());
    }

  

    class ColorRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(
                JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Verifica si el valor en la celda es un Color
            if (value instanceof Color) {
                Color color = (Color) value;
                component.setBackground(color);
                component.setForeground(new Color(0, 0, 0, 0)); // Color del texto en la celda
            }

            return component;
     }
        
    
    }
    }
