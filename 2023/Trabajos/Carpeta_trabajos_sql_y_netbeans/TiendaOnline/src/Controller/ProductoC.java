/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Entity.Producto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *

 */
public class ProductoC {
    public void GuardarRegistro(String codigo, String nombre, Double precio, Long cantidad){
        Producto producto = new Producto();
        producto.setCodigo(codigo);
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setCantidad(cantidad);
        producto.Agregar();
    }
    
    public void ModificarRegistro(Long  id, String codigo, String nombre, Double precio, Long cantidad){
        Producto producto = new Producto();
        producto.setId(id);
        producto.setCodigo(codigo);
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setCantidad(cantidad);
        producto.Modificar();
    }
  public void EliminarRegistro(Long Id){
    Producto producto = new Producto();
    producto.setId(Id);
    producto.Eliminar();
}
  
  public java.util.List<Producto> ConsultarRegistro() {
        java.util.List<Producto> productos = new ArrayList<>();
        Producto producto = new Producto();
        ResultSet resultSet = (ResultSet) producto.Consultar();

        try {
            while (resultSet.next()) {
                Producto p = new Producto();
                p.setId(resultSet.getLong("id"));
                p.setCodigo(resultSet.getString("codigo"));
                p.setNombre(resultSet.getString("nombre"));
                p.setPrecio(resultSet.getDouble("precio"));
                p.setCantidad(resultSet.getLong("cantidad"));
                p.setState(resultSet.getBoolean("state"));
                // También puedes establecer otros campos si es necesario
                productos.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepciones según tu lógica
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace(); // Manejo de excepciones según tu lógica
            }
        }

        return productos;
    }
  public java.util.List<Producto> ListarProducto() {
        java.util.List<Producto> productos = new ArrayList<>();
        Producto producto = new Producto();
        ResultSet resultSet = (ResultSet) producto.Consultar();

        try {
            while (resultSet.next()) {
                Producto p = new Producto();
                p.setId(resultSet.getLong("id"));
                p.setNombre(resultSet.getString("nombre"));
                productos.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepciones según tu lógica
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace(); // Manejo de excepciones según tu lógica
            }
        }

        return productos;
    }
}
