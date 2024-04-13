/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Entity.estado;

/**
 *
 * @author JuanDa
 */
public class estadoC {
    public void AgregarRegistro(String codigo_postal, String descripcion, Long pais_id){
        estado e = new estado();
        e.setCodigo_postal(codigo_postal);
        e.setDescripcion(descripcion);
        e.setPais_id(pais_id);
        e.Agregar();
    }
        public void ModificarRegistro(Long id, String codigo_postal, String descripcion, Long pais_id){
        estado e = new estado();
        e.setCodigo_postal(codigo_postal);
        e.setDescripcion(descripcion);
        e.setPais_id(pais_id);
        e.Modificar();
    }
         public void EliminarRegistroFisico(Long id){
        estado e = new estado();
        e.setId(id);
        e.EliminadoFisico();
    }
    
       public void EliminarRegistroLogico(Long id){
        estado e = new estado();
        e.setId(id);
        e.EliminadoLogico();
    }     
    }

