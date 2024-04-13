/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frames;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 *
 * @author JuanDa
 */
public class Cancion extends JFrame{
    private JTable table;
    private DefaultTableModel tableModel;

    public Cancion() {
        setTitle("Canciones");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Establecer el tamaño de la ventana para que ocupe toda la pantalla
        setSize(screenSize.width, screenSize.height);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Artistas ID");
        tableModel.addColumn("Nombre de la cancion");
        

        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        
        

        cargarDatos();
        panel.add(scrollPane, BorderLayout.CENTER);
        
       JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEADING)); // FlowLayout con alineación izquierda

        JButton siguienteButton = new JButton("Atras");
        siguienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear una instancia de Encuesta
                Encuesta1 eGUI = new Encuesta1();
                eGUI.setVisible(true);

                // Cerrar la instancia actual de Cancion si es necesario
                dispose();
            }
        });
        buttonPanel.add(siguienteButton);

        JButton siguienteButton2 = new JButton("Siguiente");
        siguienteButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear una instancia de Artista
                Artista a = new Artista();
                a.setVisible(true);

                // Cerrar la instancia actual de Cancion si es necesario
                dispose();
            }
        });
        buttonPanel.add(siguienteButton2);

        panel.add(buttonPanel, BorderLayout.SOUTH); // Agregar el panel de botones en la parte inferior del panel principal

        add(panel);
    }
    
    private void cargarDatos(){
        List<String> NombreCancion = Arrays.asList("Vitruvian Groove", "Mona Lisa Serenade", "Da Vinci's Sonata", "Whispers of the Canvas", "Nocturne in Masterpiece", "Renaissance Waltz", 
                "Harmony of Art", "Vinci's Muse", "Canvas of Emotions", "Dreamer's Brushes", "Nighttime Symphony", "Starry Dreams", "Vincent's Visions", "Sunflower Serenade", "Terrace Tango", 
                "Dusk Irises", "The Eaters' Ballad", "Wheat Field Nocturne", "Crow's Melody", "Blossoms in Moonlight", "Cubist Concerto", "Guernica's Echo", "Blue Hues Waltz", "Dance of the Avant-Garde", 
                "Picasso's Palette", "Bullfight Rhapsody", "Harlequin's Muse", "Abstract Reverie", "Guitarist's Sketch", "Portrait of Shapes", "Legacy of Leonardo", "Van Gogh's Echoes", "Starry Night Sonata", 
                "Mysteries on Canvas", "Artistic Journeys", "Life in Brushstrokes", "Visions Unbound", "Dreams on Canvas", "Colors of Genius", "Elegance in Artistry", "Floral Nocturne", "Dali's Surreal Dreams", 
                "Symphony of the Subconscious", "Melting Clocks", "Persistence in Waltz", "Gala's Muse", "Elephant's Journey", "Clocks and Shadows", "Burning Giraffes Ballet", "Frida's Tears");
        
         

        List<String> ArtistaID = Arrays.asList("1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "3", "3", 
                "3", "3", "3", "3", "3", "3", "3", "3", "4", "4", "4", "4", "4", "4", "4", "4", "4", "4", "5", "5", "5", "5", "5", "5", "5", "5","5","5");
        
        List<Integer>ids = new ArrayList<>();
        for (int i = 1; i <= NombreCancion.size() ; i++) {
            ids.add(i);
        }

        for (int i = 0; i < NombreCancion.size(); i++) {
            Object[] rowData = { ids.get(i),ArtistaID.get(i), NombreCancion.get(i) };
            tableModel.addRow(rowData);
        }
    }

    }

