package com.proyecto.proyecto_farmasol.services;

import com.proyecto.proyecto_farmasol.model.Producto;
import com.proyecto.proyecto_farmasol.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductoService {

    @Autowired
    private IProductoRepository repoProd;

    public List<Producto> listarTodos(){
        return repoProd.findAll();
    }

    //Buscar producto por codigo
    public Producto obtenerPorCodigo(String codprod){
        return repoProd.findByCodprod(codprod);
    }

    public Producto obtenerPorId(Integer id){
        return repoProd.findById(id).orElse(null);
    }

    //registrar un medicamento
    public Producto agregarProducto(Producto producto) {
        return repoProd.save(producto);
    }

    //eliminar por id
    public void eliminarPorId(Integer id) {
        repoProd.deleteById(id);
    }

    //actualizar un Medicamento
    public Producto actualizarProducto(Producto producto) {
        return repoProd.save(producto);
    }
}
