/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Entity.ciudad;

/**
 *
 * @author JuanDa
 */
public class ciudadC {
    public void AgregarRegistro(String codigo_postal, String descripcion, Long estado_id){
        ciudad c = new ciudad();
        c.setCodigo_postal(codigo_postal);
        c.setDescripcion(descripcion);
        c.setEstado_id(estado_id);
        c.Agregar();
    }
        public void ModificarRegistro(Long id, String codigo_postal, String descripcion, Long estado_id){
      ciudad c = new ciudad();
      c.setId(id);
        c.setCodigo_postal(codigo_postal);
        c.setDescripcion(descripcion);
        c.setEstado_id(estado_id);
        c.Modificar();
    }
         public void EliminarRegistroFisico(Long id){
       ciudad c = new ciudad();
      c.setId(id);
        c.EliminadoFisico();
    }
    
       public void EliminarRegistroLogico(Long id){
         ciudad c = new ciudad();
      c.setId(id);
        c.EliminadoLogico();
    }     
}
