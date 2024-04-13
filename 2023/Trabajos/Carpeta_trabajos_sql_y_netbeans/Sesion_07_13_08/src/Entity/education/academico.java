/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity.education;

import java.util.Map;
/**
 *
 * @author JuanDa
 */
public class academico {
    private String alumno;
    private Double unidades;
    private Double costoP;
private Double descuento;
private Double Pagar;

    public Double getPagar() {
        return Pagar;
    }

    public void setPagar(Double Pagar) {
        this.Pagar = Pagar;
    }


    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getCostoP() {
        return costoP;
    }

    public void setCostoP(Double costoP) {
        this.costoP = costoP;
    }
    
    
    
    public Double getUnidades() {
        return unidades;
    }

    public void setUnidades(Double unidades) {
        this.unidades = unidades;
    }
    
    
    
    private Double promedio;

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    public Double getPromedio() {
        return promedio;
    }

    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }
    
    
    public Map<String, Double> CalcularPromedio(){        
        return null;        
    }
    
   
}
