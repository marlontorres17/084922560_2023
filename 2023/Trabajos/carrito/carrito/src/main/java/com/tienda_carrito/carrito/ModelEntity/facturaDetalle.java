package com.tienda_carrito.carrito.ModelEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "factura_detalle")


public class facturaDetalle {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cantidad", nullable = false)
    private Long cantidad;

    @Column(name = "valor_pagar", nullable = false)
    private Double valorPagar;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "producto_id", nullable = false)
    private producto productoId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "factura_id", nullable = false)
    private factura facturaId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getCantidad() {
        return cantidad;
    }


    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }


    public Double getValorPagar() {
        return valorPagar;
    }


    public void setValorPagar(Double valorPagar) {
        this.valorPagar = valorPagar;
    }


    public producto getProductoId() {
        return productoId;
    }


    public void setProductoId(producto productoId) {
        this.productoId = productoId;
    }


    public factura getFacturaId() {
        return facturaId;
    }


    public void setFacturaId(factura facturaId) {
        this.facturaId = facturaId;
    }

}
