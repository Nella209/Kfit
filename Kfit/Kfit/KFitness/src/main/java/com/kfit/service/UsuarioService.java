package com.kfit.service;

import com.kfit.domain.Usuario;
import com.kfit.dao.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    public List<Usuario> listarUsuarios() {
        return (List<Usuario>) usuarioDao.findAll();
    }
}