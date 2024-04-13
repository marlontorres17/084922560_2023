/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frames;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;


public class ColorRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Verifica si el valor en la celda es un Color
        if (value instanceof Color) {
            Color color = (Color) value;
            component.setBackground(color);

            // Configura el texto de la celda en blanco (transparente)
            setText("");

            // Asegura que el fondo de la celda sea opaco para que se muestre el color de fondo
            setOpaque(true);
        } else if (value instanceof ColorBox) {
            // Si el valor es un ColorBox, establece el fondo de la celda y el texto en blanco
            ColorBox colorBox = (ColorBox) value;
            component.setBackground(colorBox.getColor());
            setText("");
            setOpaque(true);
        } else {
            // Si el valor no es ni Color ni ColorBox, restaura el fondo a blanco y muestra el valor de texto
            component.setBackground(Color.WHITE);
            setText(value != null ? value.toString() : "");
        }

        return component;
    }
}
