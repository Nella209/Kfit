package com.kfit.service;

import com.kfit.dao.CategoriaDao;
import com.kfit.domain.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaDao categoriaDao;

    public List<Categoria> listarCategorias() {
        return (List<Categoria>) categoriaDao.findAll();
    }

    public void guardar(Categoria categoria) {
        categoriaDao.save(categoria);
    }

    public void eliminar(Categoria categoria) {
        categoriaDao.delete(categoria);
    }

    public Categoria encontrarCategoria(Long id) {
        return categoriaDao.findById(id).orElse(null);
    }
}