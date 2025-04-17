package com.kfit.controller;

import com.kfit.domain.Venta;
import com.kfit.dao.VentaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaDao ventaDao;

    @GetMapping("/listado")
    public String listarVentas(Model model) {
        var ventas = ventaDao.findAll();
        model.addAttribute("ventas", ventas);
        return "ventas/listado";
    }

    @PostMapping("/guardar")
    public String guardarVenta(Venta venta) {
        ventaDao.save(venta);
        return "redirect:/ventas/listado";
    }
}