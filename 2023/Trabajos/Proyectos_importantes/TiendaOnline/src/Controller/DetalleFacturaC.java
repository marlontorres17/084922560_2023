/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Entity.DetalleFactura;


/**
 *
 * @author JuanDa
 */
public class DetalleFacturaC {
    public void GuardarRegistro(Long cantidad, Double valorP, Long productoId, Long facturaId){
        DetalleFactura df = new DetalleFactura();
        df.setCantidad(cantidad);
        df.setValorP(valorP);
        df.setProductoId(productoId);
        df.setFacturaId(facturaId);
        df.Agregar();
    }
    
    public void ModificarRegistro(Long Id, Long cantidad, Double valorP, Long productoId, Long facturaId ){
     DetalleFactura df = new DetalleFactura();
        df.setId(Id);
        df.setCantidad(cantidad);
        df.setValorP(valorP);
        df.setProductoId(productoId);
        df.setFacturaId(facturaId);
        df.Modificar();
    }
    
     public void EliminarRegstro(Long Id ){
     DetalleFactura df = new DetalleFactura();
        df.setId(Id);
        
        df.Eliminar();
    }
    
}
