package com.kfit.dao;

import com.kfit.domain.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDao extends CrudRepository<Usuario, Long> {
}