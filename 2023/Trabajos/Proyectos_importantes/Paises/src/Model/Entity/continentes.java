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
public class continentes implements Accion {
    private Long Id;
    private String codigoPostal;
    private String descripcion;
    public Conexion conn = new Conexion();
    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
    @Override
    public void Agregar() {
        String sql = "INSERT INTO continente ("
                + "nombre_continente, "
                + "descripcion, "
                + "created_at"
                + ") VALUES ("
                + "' "+ this.getCodigoPostal()+ "', "
                + "' "  + this.getDescripcion()+ "', "
                + "NOW()"
                + ");";
                 conn.ejecutarSQL(sql);
                conn.cerrarConexion();
    }

    @Override
    public void Modificar() {
       String sql = "UPDATE continente SET "
               + "nombre_continente = '" + this.getCodigoPostal() + "', "
               + "descripcion = '" + this.getDescripcion() + "', "
               + "created_at = NOW() "
               + "WHERE id = " + this.getId();
       
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
