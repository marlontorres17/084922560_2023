package Entity.education;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author JuanDa
 */
import Utils.FunctionNumeric;
import Utils.FunctionString;

/*1.5.8.	Una institución educativa estableció un programa para estimular a los alumnos con buen rendimiento académico y que consiste en lo siguiente:
-	Si el promedio es de 9.5 o más y el alumno es de preparatoria, entonces este podrá cursar 55 unidades y se le hará un 25% de descuento.
-	Si el promedio es mayor o igual a 9 pero menor que 9.5 y el alumno es de preparatoria, entonces este podrá cursar 50 unidades y se le hará un 10% de descuento.
-	Si el promedio es mayor que 7 y menor que 9 y el alumno es de preparatoria, este podrá cursar 50 unidades y no tendrá ningún descuento.
-	Si el promedio es de 7 o menor,  el número de materias reprobadas es de 0 a 3 y el alumno es de preparatoria, entonces podrá cursar 45 unidades y no tendrá descuento.
-	Si el promedio es de 7 o menor, el número de materias reprobadas es de 4 o más y el alumno es de preparatoria, entonces podrá cursar 40 unidades y no tendrá ningún descuento.
-	Si el promedio es mayor o igual a 9.5 y el alumno es de profesional, entonces podrá cursar 55 unidades y se le hará un 20% de descuento.
-	Si el promedio es menor de 9.5 y el alumno es de profesional, entonces podrá cursar 55 unidades y no tendrá descuento.
-	Obtener el total que tendrá que pagar un alumno si la colegiatura para alumnos de profesional es de $300 por cada cinco unidades y para alumnos de preparatoria es de $180 por cada cinco unidades.
 */
public class Promedio25Porcentaje {

    private Double CostoT;
    private Double descuento;
    private Double uni;
    private Double Promedio;
    private String alumno;
    private Double total;
    private String Costo;
    private Double reprobadas;

    public Double getReprobadas() {
        return reprobadas;
    }

    public void setReprobadas(Double reprobadas) {
        this.reprobadas = reprobadas;
    }

    public String getCosto() {
        return Costo;
    }

    public void setCosto(String Costo) {
        this.Costo = Costo;
    }

    FunctionNumeric fn = new FunctionNumeric();
    FunctionString fs = new FunctionString();

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    public Double getPromedio() {
        return Promedio;
    }

    public void setPromedio(Double Promedio) {
        this.Promedio = Promedio;
    }

    public Double getUni() {
        return uni;
    }

    public void setUni(Double uni) {
        this.uni = uni;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getCostoT() {
        return CostoT;
    }

    public void setCostoT(Double CostoT) {
        this.CostoT = CostoT;
    }

    public void Promedio25() {

        this.setAlumno(fs.InputScanner("Preparatoria o Profesional: "));
        this.setPromedio(fn.InputDoubleNumericPositiveScanner("Digite el promedio: "));
        if ("Preparatoria".equals(this.getAlumno())) {
            if (this.getPromedio() >= 9.5) {
                this.setCostoT(11.0 * 180.0);
                this.setTotal(this.getCostoT() * (1 - 0.25));
                this.setCosto("El costo total del alumno es: " + this.getTotal() + " ");

            }

            if (this.getPromedio() >= 9.0 && this.getPromedio() < 9.5) {
                this.setCostoT(10.0 * 180.0);
                this.setTotal(this.getCostoT() * (1 - 0.1));
                this.setCosto("El costo total del alumno es: " + this.getTotal() + " ");
            }
            if (this.getPromedio() > 7.0 && this.getPromedio() < 9.0) {
                this.setCostoT(10.0 * 180.0);
                this.setTotal(this.getCostoT() * (1 - 0.0));
                this.setCosto("El costo total del alumno es: " + this.getTotal() + " ");
            }
            if (this.getPromedio() <= 7.0) {
                this.setReprobadas(fn.InputDoubleNumericPositiveScanner("Materias reprobadas de 0 a 3: "));
                if (this.getReprobadas() >= 0.0 && this.getReprobadas() <= 3.0) {
                    this.setCostoT(9.0 * 180.0);
                    this.setTotal(this.getCostoT() * (1 - 0.0));
                    this.setCosto("El costo total del alumno es: " + this.getTotal() + " ");
                } else if (this.getReprobadas() >= 4.0) {
                    this.setCostoT(8.0 * 180.0);
                    this.setTotal(this.getCostoT() * (1 - 0.0));
                    this.setCosto("El costo total del alumno es: " + this.getTotal() + " ");
                }
                if ("Profesional".equals(this.getAlumno())) {
                    if (this.getPromedio() >= 9.5) {
                        this.setCostoT(11.0 * 180.0);
                        this.setTotal(this.getCostoT() * (1 - 0.20));
                        this.setCosto("El costo total del alumno es: " + this.getTotal() + " ");

                    } else if (this.getPromedio() < 9.5) {
                        this.setCostoT(11.0 * 180.0);
                        this.setTotal(this.getCostoT() * (1 - 0.0));
                        this.setCosto("El costo total del alumno es: " + this.getTotal() + " ");
                    }

                }

            }
        }

    }
}
