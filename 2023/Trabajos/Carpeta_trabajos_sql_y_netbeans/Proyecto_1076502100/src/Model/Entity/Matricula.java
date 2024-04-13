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
public class Matricula implements Accion{
    private Long id;
    private Long materia_id;
    private Long estudiante_id;
    private Double nota;
    Conexion conn = new Conexion();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMateria_id() {
        return materia_id;
    }

    public void setMateria_id(Long materia_id) {
        this.materia_id = materia_id;
    }

    public Long getEstudiante_id() {
        return estudiante_id;
    }

    public void setEstudiante_id(Long estudiante_id) {
        this.estudiante_id = estudiante_id;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }
    
    @Override
    public void Agregar() {
        String sql = "INSERT INTO matricula ("
                + "materia_id, "
                + "estudiante_id, "
                + "nota, "
                + "created_at"
                + " )VALUES (" 
                + this.getMateria_id() + ", " 
                + this.getEstudiante_id() + ", " 
                + this.getNota() + ")";
        System.out.println(sql);
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public void Modificar() {
        String sql = "UPDATE matricula SET "
                + "materia_id = " + this.getMateria_id()+ ", "
                + "estudiante_id = " + this.getEstudiante_id()+ ", "
                + "nota = " + this.getNota() + ", "
                + "updated_at = NOW() " +
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
