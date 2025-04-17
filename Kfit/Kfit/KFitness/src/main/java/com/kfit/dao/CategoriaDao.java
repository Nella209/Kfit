package com.kfit.dao;

import com.kfit.domain.Categoria;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface CategoriaDao extends CrudRepository<Categoria, Long> {

    // Método personalizado para encontrar una categoría por su nombre
    List<Categoria> findByNombre(String nombre);

    // Método personalizado para listar todas las categorías ordenadas por nombre
    List<Categoria> findAllByOrderByNombreAsc();
}