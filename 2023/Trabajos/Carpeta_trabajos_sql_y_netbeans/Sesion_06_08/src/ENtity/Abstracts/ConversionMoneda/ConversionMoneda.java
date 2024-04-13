/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENtity.Abstracts.ConversionMoneda;



import ENtity.Abstracts.SuperEntity;
import Utils.FunctionNumeric;
import Utils.FunctionString;


public class ConversionMoneda extends SuperEntity {
    private Double ConversionMoneda;
    private Double Conversion;
    
     //Objeto de la clase FunctionNumeric
    FunctionNumeric fn = new FunctionNumeric();
    
    //Objeto de la clase FunctionString
    FunctionString fs = new FunctionString();

    public Double getConversionMoneda() {
        return ConversionMoneda;
    }

    public void setConversionMoneda(Double ConversionMoneda) {
        this.ConversionMoneda = ConversionMoneda;
    }

    public Double getConversion() {
        return Conversion;
    }

    public void setConversion(Double Conversion) {
        this.Conversion = Conversion;
    }
    
    public void PesosCOPaUSD(){
        this.setConversionMoneda(fn.InputDoubleNumericScanner("Ingrese su dinero en COP: "));
        this.setConversion(this.getConversion()/0.00024);
        fs.ShowScanner("La conversion de "+this.getConversionMoneda()+"COP a USD es: "+this.getConversion()+"\n");
        
    }
    
    
    
}
