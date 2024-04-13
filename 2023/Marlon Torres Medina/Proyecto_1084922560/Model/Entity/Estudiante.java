package Proyecto_1084922560.Model.Entity;

import Proyecto_1084922560.Conexion.Conexion;
import Proyecto_1084922560.Model.Interfase.Accion;

public class Estudiante implements Accion {

    private Long idEstudiante;
    private String nombre;
    private String apellido;
    private Long edad;
    private String direccion;
    private Long telefono;
    public Conexion conn = new Conexion();


    public Long getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Long getEdad() {
        return edad;
    }

    public void setEdad(Long edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
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

        sql = "INSERT INTO Estudiante ("
                + "nombre, "
                + "apellido, "
                + "edad, "
                + "direccion, "
                + "telefono, "
                + "created_at"
                + ") VALUES ("
                + "'" + this.getNombre() + "', "
                + "'" + this.getApellido() + "', "
                + this.getEdad() + ", "
                + "'" + this.getDireccion() + "', "
                + "'" + this.getTelefono() + "', "
                + "NOW()"
                + ");";
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public void Modificar() {
       String sql = "UPDATE Estudiante SET "
            + "nombre = '" + this.getNombre() + "', "
            + "apellido = '" + this.getApellido() + "', "
            + "edad = " + this.getEdad() + ", "
            + "direccion = '" + this.getDireccion() + "', "
            + "telefono = '" + this.getTelefono() + "', "
            + "created_at = NOW() "
            + "WHERE idEstudiante = " + this.getIdEstudiante();

conn.ejecutarSQL(sql);
conn.cerrarConexion();
    }

    @Override
    public void Eliminar() {
       String sql = "DELETE FROM Estudiante WHERE idEstudiante = " + this.getIdEstudiante();
    
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
