/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frames;
import java.awt.Color;
import java.io.Serializable;

public class Persona implements Serializable {
    private int id;
    private String nombre;
    private String direccion;
    private Color color;
    private int sorteo; // Agregar el atributo sorteo

    public Persona(int id, String nombre, String direccion, Color color, int sorteo) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.color = color;
        this.sorteo = sorteo; // Asignar el sorteo proporcionado
    }

    // Resto de los getters y setters

    public int getSorteo() {
        return sorteo;
    }

    public void setSorteo(int sorteo) {
        this.sorteo = sorteo;
    }

    // Getters y setters para los atributos

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", color=" + color +
                '}';
    }
}
