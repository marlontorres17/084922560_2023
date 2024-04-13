/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Entity.Cliente;
import Model.Entity.Factura;
import java.time.LocalDate;

/**
 *
 * @author JuanDa
 */
public class FacturaC {

    public void GuardarRegistro(String codigo, LocalDate fecha, Double valorT, Long clienteId) {
        Factura factura = new Factura();
        factura.setCodigo(codigo);
        factura.setFecha(fecha);
        factura.setValorT(valorT);
        factura.setClienteId(clienteId);
        factura.Agregar();
    }

    public void ModificarRegistro(Long Id, String codigo, LocalDate fecha, Double valorT, Long clienteId) {
        Factura factura = new Factura();
        factura.setId(Id);
        factura.setCodigo(codigo);
        factura.setFecha(fecha);
        factura.setValorT(valorT);
        factura.setClienteId(clienteId);
        factura.Modificar();
    }
    
    public void  EliminarRegistro(Long Id){
        Factura factura=new Factura();
        factura.setId(Id);
    }                                     


}
