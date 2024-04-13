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
public class estado implements Accion{
     private Long Id;
    private String codigo_postal;
    private String descripcion;
    private Long pais_id;
    Conexion conn = new Conexion();

    public estado() {
    }

    public estado(Long Id, String codigo_postal, String descripcion, Long pais_id) {
        this.Id = Id;
        this.codigo_postal = codigo_postal;
        this.descripcion = descripcion;
        this.pais_id = pais_id;
    }

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

    public Long getPais_id() {
        return pais_id;
    }

    public void setPais_id(Long pais_id) {
        this.pais_id = pais_id;
    }

    @Override
    public void Agregar() {
        String sql = "INSERT INTO estado ("
                + "codigo_postal, "
                + "descripcion, "
                + "pais_id, "
                + "created_at"
                + ") VALUES ("
                + "'" + this.getCodigo_postal() + "', "
                + "'" + this.getDescripcion() + "', "
                + this.getPais_id() + ", "
                + "NOW()"
                + ");";
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public void Modificar() {
        String sql = "UPDATE estado SET "
                + "codigo_postal = '" + this.getCodigo_postal() + "', "
                + "descripcion = '" + this.getDescripcion() + "', "
                + "pais_id = " + this.getPais_id() + ", "
                + "updated_at = NOW() "
                + "WHERE Id = " + this.getId();

        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public void Eliminar() {
        String sql = "DELETE FROM estado WHERE Id = " + this.getId();

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
    String sql = "DELETE FROM estado WHERE Id = " + this.getId();
    conn.ejecutarSQL(sql);
    conn.cerrarConexion();
}

    @Override
public void EliminadoLogico() {
    String sql = "UPDATE estado SET state = 0, deleted_at = NOW() WHERE Id = " + this.getId();
    conn.ejecutarSQL(sql);
    conn.cerrarConexion();
}
    
}
