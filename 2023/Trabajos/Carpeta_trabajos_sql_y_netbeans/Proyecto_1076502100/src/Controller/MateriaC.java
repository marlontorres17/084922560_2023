/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Entity.Materia;

/**
 *
 * @author JuanDa
 */
public class MateriaC {
    public void GuardarRegistro(String nombreMateria, String codigo, String descripcion, Long hora){
        Materia m = new Materia();
     m.setNombreMateria(nombreMateria);
     m.setCodigoMateria(nombreMateria);
     m.setDescripcion(descripcion);
     m.setHora(hora);
     m.Agregar();
    }
     public void ModificarRegistro(Long id, String nombreMateria, String codigo, String descripcion, Long hora){
        Materia m = new Materia();
     m.setId(id);
     m.setNombreMateria(nombreMateria);
     m.setCodigoMateria(nombreMateria);
     m.setDescripcion(descripcion);
     m.setHora(hora);
     m.Modificar();
    }
     public void EliminarRegistro(Long id){
         Materia m = new Materia();
         m.setId(id);
         m.Eliminar();
     }
}
