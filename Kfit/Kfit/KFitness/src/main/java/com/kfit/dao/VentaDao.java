package com.kfit.dao;

import com.kfit.domain.Venta;
import org.springframework.data.repository.CrudRepository;

public interface VentaDao extends CrudRepository<Venta, Long> {
}