package com.kfit.dao;

import com.kfit.domain.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<Cliente, Long> {
}
