package com.proyecto.proyecto_farmasol.controllers;

import com.proyecto.proyecto_farmasol.model.Producto;
import com.proyecto.proyecto_farmasol.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "http://localhost:4200/producto")
public class ProductoController {

    @Autowired
    private ProductoService service;

    @GetMapping //cargar datos
    public ResponseEntity<List<Producto>> listarTodos(){
        List<Producto> productos = service.listarTodos(); // obtiene la lista
        if(productos.isEmpty()) { //esta condicional esta evaluando la lista
            return ResponseEntity.noContent().build(); // 204 no content
        } else {
            return ResponseEntity.ok(productos); // 200 OK (TODO BIEN, SALIERON LA LISTA COMPLETA)
        }
    }

    //obtener medicamento por id
    @GetMapping("/{cod}")
    public ResponseEntity<Producto> obtenerPorId(@PathVariable String cod) {
        Producto producto = service.obtenerPorCodigo(cod); // obtiene la lista
        if (producto == null) { //esta condicional esta evaluando la lista
            return ResponseEntity.noContent().build(); // 204 no content
        } else {
            return ResponseEntity.ok(producto); // 200 OK (TODO BIEN, SALIERON LA LISTA COMPLETA)
        }
    }

    @PostMapping
    public ResponseEntity<Producto> agregarProducto(@RequestBody Producto producto) {
        try {
            Producto nuevo = service.agregarProducto(producto);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevo); // 201 created
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500 ERROR
        }
    }

    // Eliminar -> Delete
    @DeleteMapping("/{cod}")
    public ResponseEntity<?> eliminarPorCodigo(@PathVariable String cod){
        Producto producto = service.obtenerPorCodigo(cod);
        if (producto == null) {
            return ResponseEntity.
                    status(HttpStatus.BAD_REQUEST).body("producto no existe");
        }
        try {
            service.eliminarPorId(producto.getIdproducto());
            return ResponseEntity.status(HttpStatus.CREATED).
                    body("Producto eliminado");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Error al eliminar");
        }
    }

    // actualizar producto
    @PutMapping("/{cod}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable String cod, @RequestBody Producto producto) {
        Producto existente = service.obtenerPorCodigo(cod);
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404
        }

        try {
            producto.setIdproducto(producto.getIdproducto()); // aseguramos que el ID sea el correcto
            Producto actualizado = service.actualizarProducto(producto); // o mejor: service.actualizarProducto(producto)
            return ResponseEntity.ok(actualizado); // 200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
        }
    }
}
