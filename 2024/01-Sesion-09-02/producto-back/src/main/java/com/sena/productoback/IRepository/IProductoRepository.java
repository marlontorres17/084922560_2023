package com.sena.productoback.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.productoback.Entity.Producto;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long> {
    
}
