package com.sena.productoback.IService;

import java.util.List;
import java.util.Optional;

import com.sena.productoback.Entity.Producto;

public interface IProductoService {

    List<Producto> findAll();

    Optional<Producto> findById(Long id);

    Producto save(Producto producto);

    void update(Producto producto, Long id);

    void deletedAt(Long id);

    void delete(Long id);
}
