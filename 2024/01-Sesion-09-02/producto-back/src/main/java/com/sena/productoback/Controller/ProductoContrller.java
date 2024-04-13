package com.sena.productoback.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sena.productoback.Entity.Producto;
import com.sena.productoback.IService.IProductoService;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("v1/api/producto")
public class ProductoContrller {

    @Autowired
    private IProductoService productoService;

    @GetMapping
    public List<Producto> findAll() {
        return productoService.findAll();
    }

    @GetMapping("{id}")
    public Optional<Producto> findById(@PathVariable Long id) {
        return productoService.findById(id);
    }

    @PostMapping
    public Producto save(@RequestBody Producto producto) {
        return productoService.save(producto);
    }

    @PutMapping("{id}")
    public void update(@RequestBody Producto producto, @PathVariable Long id) {
        productoService.update(producto, id);
    }

    @PutMapping("deleted-at/{id}")
    public void deletedAt(@PathVariable Long id) {
        productoService.deletedAt(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        productoService.delete(id);
    }
}
