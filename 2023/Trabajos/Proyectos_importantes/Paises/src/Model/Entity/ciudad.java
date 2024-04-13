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
public class ciudad implements Accion{
     private Long Id;
    private String codigo_postal;
    private String descripcion;
    private Long estado_id;
    Conexion conn = new Conexion();

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getEstado_id() {
        return estado_id;
    }

    public void setEstado_id(Long estado_id) {
        this.estado_id = estado_id;
    }
    
    

   @Override
     public void Agregar() {
        String sql = "INSERT INTO ciudad ("
                + "codigo_postal, "
                + "descripcion, "
                + "estado_id, "
                + "created_at"
                + ") VALUES ("
                + "'" + this.getCodigo_postal() + "', "
                + "'" + this.getDescripcion() + "', "
                + this.getEstado_id() + ", "
                + "NOW()"
                + ");";
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public void Modificar() {
        String sql = "UPDATE ciudad SET "
                + "codigo_postal = '" + this.getCodigo_postal() + "', "
                + "descripcion = '" + this.getDescripcion() + "', "
                + "estado_id = " + this.getEstado_id() + ", " // Changed to Long
                + "updated_at = NOW() "
                + "WHERE Id = " + this.getId();

        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public void Eliminar() {
          String sql = "DELETE FROM continente WHERE id = " + this.getId();
    
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

   @Override
public void EliminadoFisico() {
    String sql = "DELETE FROM continente WHERE id = " + this.getId();
    conn.ejecutarSQL(sql);
    conn.cerrarConexion();
}

@Override
public void EliminadoLogico() {
    String sql = "UPDATE continente SET state = 0, deleted_at = NOW() WHERE id = " + this.getId();
    conn.ejecutarSQL(sql);
    conn.cerrarConexion();
}
    
}
