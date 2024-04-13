/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Entity.pais;

/**
 *
 * @author JuanDa
 */
public class paisC {
     public void AgregarRegistro(String codigoPostal, String descripcion, Long continenteId){
        pais p = new pais();
        p.setCodigo_postal(codigoPostal);
        p.setDescripcion(descripcion);
        p.setContinente_id(continenteId);
        p.Agregar();
    }
    
    public void ModificarRegistro(Long id, String codigoPostal, String descripcion, Long continenteId){
        pais p = new pais();
        p.setId(id);
       p.setCodigo_postal(codigoPostal);
        p.setDescripcion(descripcion);
        p.setContinente_id(continenteId);
        p.Modificar();
    }
    
    public void EliminarRegistroFisico(Long id){
        pais p = new pais();
        p.setId(id);
        p.EliminadoFisico();
    }
    
       public void EliminarRegistroLogico(Long id){
        pais p = new pais();
        p.setId(id);
        p.EliminadoLogico();
    }     
}
