package Proyecto_1084922560.Model.Entity;

import Proyecto_1084922560.Conexion.Conexion;
import Proyecto_1084922560.Model.Interfase.Accion;

public class Matricula implements Accion {

    private Long id;
    private long idEstudiante;
    private long idMateria;
    private Long notas;
    private long año;
    private String estado;
    public Conexion conn = new Conexion();


    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public long getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(long idMateria) {
        this.idMateria = idMateria;
    }

    public Long getNotas() {
        return notas;
    }

    public void setNotas(Long notas) {
        this.notas = notas;
    }

    public long getAño() {
        return año;
    }

    public void setAño(long año) {
        this.año = año;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

        sql = "INSERT INTO matricula ("
                + "idEstudiante, "
                + "idMateria, "
                + "notas, "
                + "año, "
                + "estado, "
                + "created_at"
                + ") VALUES ("
                + "'" + this.getIdEstudiante() + "', "
                + "'" + this.getIdMateria() + "', "
                + this.getNotas() + ", "
                + "'" + this.getAño() + "', "
                + "'" + this.getEstado() + "', "
                + "NOW()"
                + ");";
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public void Modificar() {
       String sql = "UPDATE Matricula SET "
            + "nombre = '" + this.getIdEstudiante() + "', "
            + "apellido = '" + this.getIdMateria() + "', "
            + "edad = " + this.getNotas() + ", "
            + "direccion = '" + this.getAño() + "', "
            + "telefono = '" + this.getEstado() + "', "
            + "created_at = NOW() "
            + "WHERE idEstudiante = " + this.getId();

conn.ejecutarSQL(sql);
conn.cerrarConexion();
    }

    @Override
    public void Eliminar() {
       String sql = "DELETE FROM Matricula WHERE id = " + this.getId();
    
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
