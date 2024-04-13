package com.sena.productoback.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.productoback.Entity.Producto;
import com.sena.productoback.IRepository.IProductoRepository;
import com.sena.productoback.IService.IProductoService;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoRepository productoRepository;

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @SuppressWarnings("null")
    @Override
    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto save(Producto producto) {
        producto.setFechaCreacion(LocalDateTime.now());
        return productoRepository.save(producto);
    }

    @SuppressWarnings("null")
    @Override
    public void update(Producto producto, Long id) {
        Optional<Producto> op = productoRepository.findById(id);
        if (op.isEmpty()) {
            System.out.print("Registro no existe.");
        } else {
            Producto updateProducto = op.get();
            updateProducto.setNombre(producto.getNombre());
            updateProducto.setPrecio(producto.getPrecio());
            updateProducto.setCantidad(producto.getCantidad());
            updateProducto.setCategoria(producto.getCategoria());
            updateProducto.setDescripcion(producto.getDescripcion());
            updateProducto.setFechaModificacion(LocalDateTime.now());
            productoRepository.save(updateProducto);
        }
    }

    @SuppressWarnings("null")
    @Override
    public void deletedAt(Long id) {
        Optional<Producto> op = productoRepository.findById(id);
        if (op.isEmpty()) {
            System.out.print("Registro no existe para eliminar.");
        } else {
            Producto updateProducto = op.get();
            updateProducto.setFechaEliminacion(LocalDateTime.now());
            productoRepository.save(updateProducto);
        }
    }

    @SuppressWarnings("null")
    @Override
    public void delete(Long id) {
        productoRepository.deleteById(id);
    }
}
