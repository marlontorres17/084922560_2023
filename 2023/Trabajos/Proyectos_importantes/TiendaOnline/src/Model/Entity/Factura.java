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
 * @author ariel
 */
public class Factura implements Accion{
     private Long id;
    private LocalDate fecha;
    private String codigo;
    private Double valorT;
    private Long clienteId;
    Cliente cliente;
    public Conexion conn = new Conexion();

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Double getValorT() {
        return valorT;
    }

    public void setValorT(Double valorT) {
        this.valorT = valorT;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Conexion getConn() {
        return conn;
    }

    public void setConn(Conexion conn) {
        this.conn = conn;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    

    @Override
    public void Agregar() {
       String sql;

        sql = "INSERT INTO factura ("
                + "codigo, "
                + "fecha, "
                + "valor_total, "
                + "cliente_id, "
                + "created_at"
                + ") VALUES ("
                + "'" + this.getCodigo()+ "', "
                + "'" + this.getFecha()+ "', "
                + this.getValorT()+ ", "
                + "'" + this.getClienteId()+ "', "
                + "NOW()"
                + ");";
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public void Modificar() {
        String sql = "UPDATE factura SET "
    + "codigo = '" + this.getCodigo() + "', "
    + "fecha = '" + this.getFecha() + "', "
    + "valor_total = " + this.getValorT() + ", "
    + "cliente_id = " + this.getClienteId() + ", "  
    + "created_at = NOW() "
    + "WHERE id = " + this.getId();
    
conn.ejecutarSQL(sql);
conn.cerrarConexion();
    }

    @Override
    public void Eliminar() {
        String sql = "DELETE FROM factura WHERE id = " + this.getId();
    
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
