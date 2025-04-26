package com.proyecto.proyecto_farmasol.services;

import com.proyecto.proyecto_farmasol.model.Categoria;
import com.proyecto.proyecto_farmasol.model.Producto;
import com.proyecto.proyecto_farmasol.repository.ICategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private ICategoriaRepository repoCate;

    public List<Categoria> listarTodas(){
        return repoCate.findAll();
    }

}
