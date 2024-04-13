/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Entity.estudiante;
import java.time.LocalDate;

/**
 *
 * @author JuanDa
 */
public class estudianteC {
    public void GuardarRegistro(String nombreS, String apellido, Long tarjeta, LocalDate cumpleanos, String email){
        estudiante e = new estudiante();
        e.setNombreS(nombreS);
        e.setApellido(apellido);
        e.setCumpleaños(cumpleanos);
        e.setTarjeta(tarjeta);
        e.setEmail(email);
        e.Agregar();
    }
     public void ModificarRegistro(Long id, String nombreS, String apellido, Long tarjeta, LocalDate cumpleanos, String email){
        estudiante e = new estudiante();
        e.setId(id);
        e.setNombreS(nombreS);
        e.setApellido(apellido);
        e.setCumpleaños(cumpleanos);
        e.setTarjeta(tarjeta);
        e.setEmail(email);
        e.Modificar();
    }
    public void EliminarRegistro(Long id){
        estudiante e = new estudiante();
        e.setId(id);
        e.Eliminar();
    }
     
}
