/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entity;

import Conexion.Conexion;
import Model.Interfase.Accion;

/**
 *
 * @author ariel
 */
public class DetalleFactura implements Accion{
    
    private Long Id;
    private Long cantidad;
    private Double valorP;
    private Long productoId;
    private Long facturaId;
     public Conexion conn = new Conexion();

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Double getValorP() {
        return valorP;
    }

    public void setValorP(Double valorP) {
        this.valorP = valorP;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public Long getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(Long facturaId) {
        this.facturaId = facturaId;
    }
    
    
    
    @Override
    public void Agregar() {
         String sql;

        sql = "INSERT INTO factura_detalle ("
        + "cantidad, "
        + "valor_pagar, "
        + "producto_id, "
        + "factura_id, "
        + "created_at"
        + ") VALUES ("
        + "'" + this.getCantidad()+ "', "
        + "'" + this.getValorP()+ "', " // Se agregó un apóstrofe alrededor del valor
        + "'" + this.getProductoId()+ "', "
        + "'" + this.getFacturaId()+ "', "
        + "NOW()"
        + ");";
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public void Modificar() {
        String sql = "UPDATE factura_detalle SET "
                + "cantidad = " +  this.getCantidad() + ", "
                + "valor_pagar = " + this.getValorP() + ", "
                + "producto_id = " + this.getProductoId() + ", "
                + "factura_id = " + this.getFacturaId() + ", "
                + "created_at = NOW() "
                + "WHERE id = " + this.getId();
    
conn.ejecutarSQL(sql);
conn.cerrarConexion();
    }

    @Override
    public void Eliminar() {
        String sql = "DELETE FROM factura_detalle WHERE id = " + this.getId();
    
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
