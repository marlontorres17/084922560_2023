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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 *
 * @author JuanDa
 */
public class Artista extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    
    public Artista(){
        setTitle("Artistas: ");
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Establecer el tamaño de la ventana para que ocupe toda la pantalla
        setSize(screenSize.width, screenSize.height);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Nombre del artista");
        

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
                Cancion c = new Cancion();
                c.setVisible(true);

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
                CancionEncuesta a = new CancionEncuesta();
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
        List<String> NombreArtistas = Arrays.asList(
            "Leonardo da Vinci",
            "Van Gogh",
            "Pablo Picasso",
            "Michelangelo",
            "Salvador Dalí"
        );
        
       List<String>NombreArtista= new ArrayList<>();
        for (String nombres : NombreArtistas) {
            for (int i = 1; i <= 10; i++) {
                NombreArtista.add(nombres);
            }
        }

                
        
         List<Integer> ArtistaID = new ArrayList<>();
        for (int i = 1; i <= NombreArtistas.size(); i++) {
            ArtistaID.add(i);
        }
        
          for (int i = 0; i < NombreArtistas.size(); i++) {
            Object[] rowData = {
                ArtistaID.get(i),
                
                  NombreArtistas.get(i),
                    
            };
            tableModel.addRow(rowData);
        }
        
    }
}