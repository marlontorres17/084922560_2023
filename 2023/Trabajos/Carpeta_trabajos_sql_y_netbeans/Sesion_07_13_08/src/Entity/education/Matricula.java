/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity.education;

import Utils.FunctionNumeric;
import Utils.FunctionString;

/**
 *
 * @author JuanDa
 */
public class Matricula extends Notas {
    private String Nombre;
    private Double totalPagar;
    private Double porcentajeDescuento;
    private Byte cantidadUnidades;
    private Byte reprobada;
    final Double costePreparatoria = 180.0;
    final Double costeProfesional = 300.0;

    public Byte getReprobada() {
        return reprobada;
    }

    public void setReprobada(Byte reprobada) {
        this.reprobada = reprobada;
    }
    
    
    

    public String getNombre() {
        return Nombre;
    }

    private void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(Double totalPagar) {
        this.totalPagar = totalPagar;
    }

    private Double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    private void setPorcentajeDescuento(Double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public Byte getCantidadUnidades() {
        return cantidadUnidades;
    }

    public void setCantidadUnidades(Byte cantidadUnidades) {
        this.cantidadUnidades = cantidadUnidades;
    }
    
    public String[] GeneraValorPagar(){
    return null;
}
    
    
    
    public void GenerarFactura(){
        this.CapturarDatos();
        if(super.getTipo().equals("Preparatoria")){
            this.FacturaPreparatoria();
            this.setTotalPagar((costePreparatoria*(this.getCantidadUnidades()/5))*(1-this.getPorcentajeDescuento()));
        }else{
            this.FacturaPreparatoria();
            this.setTotalPagar(costeProfesional*((this.getCantidadUnidades()/5))*(1-this.getPorcentajeDescuento()));
        }
    }
    
    
    private void CapturarDatos(){
        FunctionNumeric fn = new FunctionNumeric();
        FunctionString fs = new FunctionString();
        
        this.setNombre(fs.InputScanner("Digite el numbre del estudiante: "));
        do{
            super.setTipo(fs.InputScanner("Digite Preparatoria/Profesional: "));
        }while (!(super.getTipo().equals("Preparatoria")||super.getTipo().equals("Profesional")));
        super.setPromedio(fn.InputDoubleNumericRangeScanner("Digite el promedio: ",0.0, 10.0));
        if(super.getPromedio()<7 && super.getTipo().equals("Preparatoria")){
            this.setReprobada(fn.InputIntegerNumericRangeScanner("Digite la cantidad de materias reprobadas 0/6: ", 0.0, 6.0).byteValue());
        }
        
    }
    public void FacturaPreparatoria(){
        if(super.getPromedio()>=9.5){
            this.setPorcentajeDescuento(0.25);
            this.setCantidadUnidades((byte)55);
        }else if(super.getPromedio()>=9.0){
            this.setPorcentajeDescuento(0.1);
            this.setCantidadUnidades((byte)50);
        }else if(super.getPromedio()>7.0){
            this.setPorcentajeDescuento(0.0);
            this.setCantidadUnidades((byte)50);
        }else if(super.getPromedio()<=7.0 && this.getReprobada()<=3){
            this.setPorcentajeDescuento(0.0);
            this.setCantidadUnidades((byte)45);
        }else if(super.getPromedio()<=7.0 && this.getReprobada()>3){
            this.setPorcentajeDescuento(0.0);
            this.setCantidadUnidades((byte)40);
    }
    
}
}
