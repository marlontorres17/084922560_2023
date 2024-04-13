/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entity;

import Conexion.Conexion;
import Model.Interfase.Accion;

/**
 *
 * @author JuanDa
 */
public class Materia implements Accion{
    private Long id;
    private String nombreMateria;
    private String codigoMateria;
    private String descripcion;
    private Long hora;
    Conexion conn = new Conexion();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public String getCodigoMateria() {
        return codigoMateria;
    }

    public void setCodigoMateria(String codigoMateria) {
        this.codigoMateria = codigoMateria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getHora() {
        return hora;
    }

    public void setHora(Long hora) {
        this.hora = hora;
    }
    
    
    @Override
    public void Agregar() {
        String sql = "INSERT INTO materia (nombre_materia, codigo_materia, descripcion, hora_materia, created_at) " +
                 "VALUES ('" + this.getNombreMateria() + "', '" + this.getCodigoMateria() + "', '" + this.getDescripcion() + "', " + this.getHora() + ", NOW())";
        
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
        
    }

    @Override
    public void Modificar() {
       String sql= "UPDATE materia SET " +
                 "nombre_materia = '" + this.getNombreMateria() + "', " +
                 "codigo_materia = '" + this.getCodigoMateria() + "', " +
                 "descripcion = '" + this.getDescripcion() + "', " +
                 "hora_materia = " + this.getHora() + ", " +
                 "updated_at = NOW() " +
                 "WHERE id = " + this.getId();
    
    conn.ejecutarSQL(sql);
    conn.cerrarConexion();
}

@Override
public void Eliminar() {
    String sql = "DELETE FROM materia WHERE id = " + this.getId();
    
    conn.ejecutarSQL(sql);
    conn.cerrarConexion();
    }

    @Override
    public void EliminadoFisico() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void EliminadoLogico() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
