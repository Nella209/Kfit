package com.kfit.serviceImpl;

import com.kfit.dao.UsuarioDao;
import com.kfit.domain.Usuario;
import com.kfit.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl extends UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public List<Usuario> listarUsuarios() {
        return (List<Usuario>) usuarioDao.findAll();
    }
}