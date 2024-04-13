/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Entity.Matricula;
import javax.swing.JComboBox;

/**
 *
 * @author JuanDa
 */
public class MatriculaC {
     public void GuardarRegistro(Long materiaid, Long estudianteid, Double nota){
        Matricula m = new Matricula();
        m.setMateria_id(materiaid);
        m.setEstudiante_id(estudianteid);
        m.setNota(nota);
        m.Agregar();
    }
     public void ModificarRegistro(Long id, String nombreMateria, String codigo, String descripcion, Long hora){
        Matricula m = new Matricula();
    }
     public void EliminarRegistro(Long id){
        Matricula m = new Matricula();
     }
     
    
}
