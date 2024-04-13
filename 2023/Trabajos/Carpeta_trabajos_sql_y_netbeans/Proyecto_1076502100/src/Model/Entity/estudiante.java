/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entity;

import Conexion.Conexion;
import Model.Interfase.Accion;
import java.time.LocalDate;

/**
 *
 * @author JuanDa
 */
public class estudiante implements Accion{
    
    private Long id;
    private String nombreS;
    private String apellido;
   private Long tarjeta;
   private LocalDate cumpleaños;
   private String email;
   Conexion conn = new Conexion();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreS() {
        return nombreS;
    }

    public void setNombreS(String nombreS) {
        this.nombreS = nombreS;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Long getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Long tarjeta) {
        this.tarjeta = tarjeta;
    }

    public LocalDate getCumpleaños() {
        return cumpleaños;
    }

    public void setCumpleaños(LocalDate cumpleaños) {
        this.cumpleaños = cumpleaños;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   
   

    @Override
    public void Agregar() {
        String sql = "INSERT INTO estudiante ("
                + "nombre_estudiante, "
                + "apellido_estudiante, "
                + "tarjeta_identidad, "
                + "cumpleaños, "
                + "email, "
                 + "created_at"
                + ") VALUES ("
                + "'" + this.getNombreS()+ "', "
                + "'" + this.getApellido()+"', "
                + this.getTarjeta()+", "
                + "'" + this.getCumpleaños()+ "', "
                + "'" + this.getEmail()+ "', "
                 + "NOW()"
                + ");";
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public void Modificar() {
        String sql = "UPDATE estudiante SET " +
                     "nombre_estudiante = '" + this.getNombreS() + "', " +
                     "apellido_estudiante = '" + this.getApellido() + "', " +
                     "tarjeta_identidad = " + this.getTarjeta() + ", " +
                     "cumpleaños = '" + this.getCumpleaños() + "', " +
                     "email = '" + this.getEmail() + "', " +
                     "updated_at = NOW() " +
                     "WHERE id = " + this.getId();
        
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public void Eliminar() {
          String sql = "DELETE FROM estudiante WHERE id = " + this.getId();
    
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
