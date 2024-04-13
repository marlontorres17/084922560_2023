/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entity;

import Conexion.Conexion;
import Model.Interfase.Accion;

/**
 *
 * @author ariel
 */
public class Cliente implements Accion {

    private Long id;
    private String nombre;
    private String correo;
    private Long telefono;
    private String direccion;
    public Conexion conn = new Conexion();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Conexion getConn() {
        return conn;
    }

    public void setConn(Conexion conn) {
        this.conn = conn;
    }

    @Override
    public void Agregar() {
        String sql;

        sql = "INSERT INTO cliente ("
                + "nombre, "
                + "correo, "
                + "telefono, "
                + "direccion, "
                + "created_at"
                + ") VALUES ("
                + "'" + this.getNombre() + "', "
                + "'" + this.getCorreo() + "', "
                + this.getTelefono() + ", "
                + "'" + this.getDireccion() + "', "
                + "NOW()"
                + ");";
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public void Modificar() {
       String sql = "UPDATE cliente SET "
            + "nombre = '" + this.getNombre() + "', "
            + "correo = '" + this.getCorreo() + "', "
            + "telefono = " + this.getTelefono() + ", "
            + "direccion = '" + this.getDireccion() + "', "
            + "created_at = NOW() "
            + "WHERE id = " + this.getId();

conn.ejecutarSQL(sql);
conn.cerrarConexion();
    }

    @Override
    public void Eliminar() {
       String sql = "DELETE FROM cliente WHERE id = " + this.getId();
    
    conn.ejecutarSQL(sql);
    conn.cerrarConexion();
    }

    @Override
    public Object Consultar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String ConsultarWhereAnd() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
