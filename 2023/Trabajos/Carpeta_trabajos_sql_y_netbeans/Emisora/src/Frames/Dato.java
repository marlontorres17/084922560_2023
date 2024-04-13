/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frames;

import java.awt.Color;

/**
 *
 * @author JuanDa
 */
public class Dato {
    private int id;
    private String nombre;
    private int sorteo;
    private String direccion;
    private Color color;

    public Dato(int id, String nombre, int sorteo, String direccion, Color color) {
        this.id = id;
        this.nombre = nombre;
        this.sorteo = sorteo;
        this.direccion = direccion;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSorteo() {
        return sorteo;
    }

    public String getDireccion() {
        return direccion;
    }

    public Color getColor() {
        return color;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    public void setColor(Color color) {
        this.color = color;
    }
}