package com.kfit.controller;

import com.kfit.domain.Cliente;
import com.kfit.dao.ClienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteDao clienteDao;

    @GetMapping("/listado")
    public String listarClientes(Model model) {
        var clientes = clienteDao.findAll();
        model.addAttribute("clientes", clientes);
        return "clientes/listado";
    }

    @PostMapping("/guardar")
    public String guardarCliente(Cliente cliente) {
        clienteDao.save(cliente);
        return "redirect:/clientes/listado";
    }
}