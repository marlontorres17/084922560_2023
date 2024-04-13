/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Entity.continentes;

/**
 *
 * @author JuanDa
 */
public class continentesC {
    
    public void AgregarRegistro(String codigoPostal, String descripcion){
        continentes c = new continentes();
        c.setCodigoPostal(codigoPostal);
        c.setDescripcion(descripcion);
        c.Agregar();
    }
    
    public void ModificarRegistro(Long id, String codigoPostal, String descripcion){
        continentes c = new continentes();
        c.setId(id);
        c.setCodigoPostal(codigoPostal);
        c.setDescripcion(descripcion);
        c.Modificar();
    }
    
    public void EliminarRegistroFisico(Long id){
        continentes c = new continentes();
        c.setId(id);
        c.EliminadoFisico();
    }
    
       public void EliminarRegistroLogico(Long id){
        continentes c = new continentes();
        c.setId(id);
        c.EliminadoLogico();
    }     
            
}
