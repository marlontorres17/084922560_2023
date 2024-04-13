package Proyecto_1084922560.Model.Entity;

import Proyecto_1084922560.Conexion.Conexion;
import Proyecto_1084922560.Model.Interfase.Accion;

public class Materia implements Accion {

    private Long idMateria;
    private String nombre;
    private String duracion;
    private Long coste;
    private String profesor;
    private Long codigo;
    public Conexion conn = new Conexion();

    public Long getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Long idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public Long getCoste() {
        return coste;
    }

    public void setCoste(Long coste) {
        this.coste = coste;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
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

        sql = "INSERT INTO Materia ("
                + "nombre, "
                + "duracion, "
                + "coste, "
                + "profesor, "
                + "codigo, "
                + "created_at"
                + ") VALUES ("
                + "'" + this.getNombre() + "', "
                + "'" + this.getDuracion() + "', "
                + this.getCoste() + ", "
                + "'" + this.getProfesor() + "', "
                + "'" + this.getCodigo() + "', "
                + "NOW()"
                + ");";
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public void Modificar() {
       String sql = "UPDATE Materia SET "
            + "nombre = '" + this.getNombre() + "', "
            + "duracion = '" + this.getDuracion() + "', "
            + "coste = " + this.getCoste() + ", "
            + "profesor = '" + this.getProfesor() + "', "
            + "codigo = '" + this.getCodigo() + "', "
            + "created_at = NOW() "
            + "WHERE idMateria = " + this.getIdMateria();

conn.ejecutarSQL(sql);
conn.cerrarConexion();
    }

    @Override
    public void Eliminar() {
       String sql = "DELETE FROM Materia WHERE idMateria = " + this.getIdMateria();
    
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
