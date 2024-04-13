package Proyecto_1084922560.Controller;

import Proyecto_1084922560.Model.Entity.Materia;

public class MateriaC {
     public void GuardarRegistro(String nombre, String duracion, Long coste, String profesor, Long codigo){
        Materia m = new Materia();

        m.setNombre(nombre);
        m.setDuracion(duracion);
        m.setCoste(coste);
        m.setProfesor(profesor );
        m.setCodigo(codigo);
        m.Agregar();
    }
     public void ModificarRegistro(Long IdMateria, String nombre, String duracion, Long coste, String profesor, long codigo){
         Materia m = new Materia();

         m.setIdMateria(IdMateria);
         m.setNombre(nombre);
         m.setDuracion(duracion);
         m.setCoste(coste);
         m.setProfesor(profesor);
         m.setCodigo(codigo);
         m.Modificar();
     }
     
      public void EliminarRegistro(Long IdMateria){
       Materia m = new Materia();

     m.setIdMateria(IdMateria);
     m.Eliminar();
}
}

