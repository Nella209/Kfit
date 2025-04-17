package com.kfit.dao;

import com.kfit.domain.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoDao extends CrudRepository<Producto, Long> {
}