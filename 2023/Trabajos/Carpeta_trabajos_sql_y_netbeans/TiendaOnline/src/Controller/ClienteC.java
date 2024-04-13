/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Entity.Cliente;

/**
 *
 * @author JuanDa
 */
public class ClienteC {
     public void GuardarRegistro(String nombre, String correo, Long telefono, String direccion){
        Cliente c = new Cliente();
        c.setNombre(nombre);
        c.setCorreo(correo);
        c.setTelefono(telefono);
        c.setDireccion(direccion);
        c.Agregar();
    }
     public void ModificarRegistro(Long Id, String nombre, String correo, Long telefono, String direccion){
         Cliente c = new Cliente();
         c.setId(Id);
        c.setNombre(nombre);
        c.setCorreo(correo);
        c.setTelefono(telefono);
        c.setDireccion(direccion);
        c.Modificar();
     }
     
      public void EliminarRegistro(Long Id){
       Cliente c = new Cliente();
    c.setId(Id);
    c.Eliminar();
}
}
