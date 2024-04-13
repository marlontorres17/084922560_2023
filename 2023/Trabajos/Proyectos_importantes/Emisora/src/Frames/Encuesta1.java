/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frames;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;



public class Encuesta1 extends JFrame {
    private DefaultTableModel tableModel;
    private JTable table;
    private List<Color> coloresFondo;
    private int currentColorIndex = 0;
    private List<Persona> personas = new ArrayList<>();
    private JLabel colorLabel; // Agrega esta línea
    
     public List<Persona> getPersonas() {
        return personas;
    }
     
     public void setPersonas(List<Persona> nuevasPersonas) {
        this.personas = nuevasPersonas;
    }
     
     
     
    public Encuesta1() {
        setTitle("Encuesta");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);

        // Inicializa la lista de colores de fondo
        inicializarColores();

        // Crea un modelo de tabla y la tabla
        JPanel panel = new JPanel();
        tableModel = new DefaultTableModel(
                new Object[]{"ID", "Nombre", "Sorteo", "Dirección", "Color de Fondo"}, 0
        );
        
        table = new JTable(tableModel);
       ColorRenderer colorRenderer = new ColorRenderer();
table.getColumnModel().getColumn(4).setCellRenderer(colorRenderer);

// Añade la tabla al JScrollPane
JScrollPane scrollPane = new JScrollPane(table);
getContentPane().add(scrollPane, BorderLayout.CENTER);

        JButton siguienteButton = new JButton("Siguiente");

        siguienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear una instancia de Cancion
                Sorteo sorteo = new Sorteo(Encuesta1.this, personas);
                sorteo.setVisible(true);

                // Cerrar la instancia actual de Encuesta si es necesario
                dispose();
            }
        });
        panel.add(siguienteButton, BorderLayout.SOUTH); // Agregar el botón en la parte inferior del panel

        JPanel buttonPanel = new JPanel();
        JButton agregarButton = new JButton("Agregar");
        JButton modificarButton = new JButton("Modificar");
        JButton eliminarButton = new JButton("Eliminar");
        buttonPanel.add(siguienteButton);
        buttonPanel.add(agregarButton);
        buttonPanel.add(modificarButton);
        buttonPanel.add(eliminarButton);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // Agregar acción para el botón Agregar
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

        // Agregar acción para el botón Modificar
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre:");
                    String nuevaDireccion = JOptionPane.showInputDialog("Ingrese la nueva dirección:");

                    if (nuevoNombre != null && nuevaDireccion != null) {
                        modificarPersona(selectedRow, nuevoNombre, nuevaDireccion);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una persona para modificar.");
                }
            }
        });

        // Agregar acción para el botón Eliminar
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    eliminarPersona(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una persona para eliminar.");
                }
            }
        });

        // Agregar el JLabel colorLabel
        colorLabel = new JLabel("Color de Fondo");
        getContentPane().add(colorLabel, BorderLayout.NORTH);
        

        // Asignar el renderizador a la columna de "Color de Fondo" (asumiendo que es la columna 4)
        table.getColumnModel().getColumn(4).setCellRenderer(colorRenderer);
        
        // Cargar datos iniciales
        cargarDatos();
    }

    private void inicializarColores() {
        coloresFondo = new ArrayList<>(Arrays.asList(
                Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE, Color.YELLOW,
                Color.CYAN, Color.MAGENTA, Color.PINK, Color.LIGHT_GRAY, Color.DARK_GRAY,
                new Color(255, 165, 0),
                new Color(128, 0, 128),
                new Color(0, 128, 0),
                new Color(255, 0, 0),
                new Color(0, 0, 255),
                new Color(255, 255, 0),
                new Color(0, 255, 255),
                new Color(255, 0, 255),
                new Color(128, 128, 0),
                new Color(128, 0, 0),
                new Color(0, 128, 128),
                new Color(0, 0, 128),
                new Color(128, 128, 128),
                new Color(192, 192, 192),
                new Color(255, 192, 203),
                new Color(255, 140, 0),
                Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE, Color.YELLOW,
                Color.CYAN, Color.MAGENTA, Color.PINK, Color.LIGHT_GRAY, Color.DARK_GRAY,
                Color.BLACK,
                new Color(255, 165, 0), new Color(128, 0, 128), new Color(0, 128, 0),
                new Color(255, 0, 0), new Color(0, 0, 255), new Color(255, 255, 0),
                new Color(0, 255, 255), new Color(255, 0, 255), new Color(128, 128, 0),
                new Color(128, 0, 0), new Color(0, 128, 128), new Color(0, 0, 128),
                new Color(128, 128, 128), new Color(192, 192, 192), new Color(255, 192, 203),
                new Color(255, 140, 0), new Color(0, 0, 0)
        ));
    }

    private Color obtenerColor() {
        // Verifica si se han agotado los colores y reinicia el índice si es necesario
        if (currentColorIndex >= coloresFondo.size()) {
            currentColorIndex = 0;
        }
        // Obtiene el color actual y avanza el índice
        Color color = coloresFondo.get(currentColorIndex);
        currentColorIndex++;

        return color;
    }

    private void agregarPersona(String nombre, String direccion) {
    Color color = obtenerColor();
    int nuevoID = tableModel.getRowCount() + 1;
    int nuevoSorteo = personas.size() + 1; // Sorteo en uno en uno

    Object[] rowData = {
        nuevoID,
        nombre,
        nuevoSorteo,
        direccion,
        color
    };

    tableModel.addRow(rowData);

    // Agrega la persona a la lista
    personas.add(new Persona(nuevoID, nombre, direccion, color, nuevoSorteo));
    guardarPersonas(); // Guarda la lista actualizada
}


    private void modificarPersona(int rowIndex, String nuevoNombre, String nuevaDireccion) {
        tableModel.setValueAt(nuevoNombre, rowIndex, 1);
        tableModel.setValueAt(nuevaDireccion, rowIndex, 3);

        // Modifica la persona en la lista
        Persona persona = personas.get(rowIndex);
        persona.setNombre(nuevoNombre);
        persona.setDireccion(nuevaDireccion);
        guardarPersonas(); // Guarda la lista actualizada
    }

    private void eliminarPersona(int rowIndex) {
    if (Sorteo.isSorteoFrameOpen()) {
        JOptionPane.showMessageDialog(null, "No puedes eliminar una persona mientras el sorteo está en curso.", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        tableModel.removeRow(rowIndex);
        personas.remove(rowIndex);
        renumerarIDs(); // Vuelve a numerar los IDs después de eliminar
        guardarPersonas(); // Guarda la lista actualizada
    }
}

    private void renumerarIDs() {
        for (int i = 0; i < personas.size(); i++) {
            personas.get(i).setId(i + 1);
        }
    }

    private void cargarDatos() {
        // Carga datos de personas desde un archivo si existe
       try {
            FileInputStream fileStream = new FileInputStream("personas.dat");
            ObjectInputStream objectStream = new ObjectInputStream(fileStream);
            personas = (List<Persona>) objectStream.readObject();
            objectStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Llena la tabla con los datos de las personas
        for (Persona persona : personas) {
            Object[] rowData = {
                    persona.getId(),
                    persona.getNombre(),
                    persona.getSorteo(),
                    persona.getDireccion(),
                    persona.getColor()
            };
            tableModel.addRow(rowData);
        }
    }

    public void guardarPersonas() {
        // Guarda la lista de personas en un archivo
        try {
            FileOutputStream fileStream = new FileOutputStream("personas.dat");
            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
            objectStream.writeObject(personas);
            objectStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Encuesta1 encuestaGUI = new Encuesta1();
                encuestaGUI.setVisible(true);
            }
        });
    }
}
