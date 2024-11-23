package com.example.apirest.apirest.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apirest.apirest.Entities.Producto;
import com.example.apirest.apirest.Repositories.ProductoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public List<Producto> getAllProductos() {

        return productoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Producto getProductById(@RequestParam Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el producto. " + id));
    }

    @PostMapping
    public Producto storeProducto(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    @PutMapping("/{id}")
    public Producto putProducto(@PathVariable Long id, @RequestBody Producto producto) {
        Producto producto2 = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el producto"));
        producto2.setNombre(producto.getNombre());
        producto2.setPrecio(producto.getPrecio());
        producto2.setDescripcion(producto.getDescripcion());
        return productoRepository.save(producto2);
    }

    @DeleteMapping("/{id}")
    public String deleteProducto(@PathVariable Long id) {
        Producto producto2 = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el producto"));
        productoRepository.delete(producto2);
        return "El producto a sido eliminado con el id:" + id;
    }

}
