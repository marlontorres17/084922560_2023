package Proyecto_1084922560.Controller;

import Proyecto_1084922560.Model.Entity.Matricula;

public class MatriculaC {
     public void GuardarRegistro(long IdEstudiante, long IdMateria, Long notas, long año, String estado){
        Matricula t = new Matricula();

        t.setIdEstudiante(IdEstudiante);
        t.setIdMateria(IdMateria);
        t.setNotas(notas);
        t.setAño(año);
        t.setEstado(estado);
        t.Agregar();
    }
     public void ModificarRegistro(Long Id, long IdEstudiante, Long IdMateria, long notas, long año, String estado){
         Matricula t = new Matricula();

        t.setId(Id);
        t.setIdEstudiante(IdEstudiante);
        t.setIdMateria(IdMateria);
        t.setNotas(notas);
        t.setAño(año);
        t.setEstado(estado);
        t.Modificar();
     }
     
      public void EliminarRegistro(Long Id){
       Matricula t = new Matricula();

     t.setId(Id);
     t.Eliminar();
}
}
