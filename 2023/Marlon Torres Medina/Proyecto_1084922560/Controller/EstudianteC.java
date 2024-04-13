package Proyecto_1084922560.Controller;

import Proyecto_1084922560.Model.Entity.Estudiante;

public class EstudianteC {
     public void GuardarRegistro(String nombre, String apellido, Long edad, String direccion, Long telefono){
        Estudiante e = new Estudiante();

        e.setNombre(nombre);
        e.setApellido(apellido);
        e.setEdad(edad);
        e.setDireccion(direccion);
        e.setTelefono(telefono);
        e.Agregar();
    }
     public void ModificarRegistro(Long IdEstudiante, String nombre, String apellido, Long edad, String direccion, Long telefono){
         Estudiante e = new Estudiante();

         e.setIdEstudiante(IdEstudiante);
         e.setNombre(nombre);
         e.setApellido(apellido);
         e.setEdad(edad);
         e.setDireccion(direccion);
         e.setTelefono(telefono);
         e.Modificar();
     }
     
      public void EliminarRegistro(Long IdEstudiante){
       Estudiante e = new Estudiante();

     e.setIdEstudiante(IdEstudiante);
     e.Eliminar();
}
}
