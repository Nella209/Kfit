package com.kfit.controller;

import com.kfit.domain.Producto;
import com.kfit.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/producto/listado")
    public String listarProductos(Model model) {
        model.addAttribute("productos", productoService.listarProductos());
        return "templates.producto.listado";
    }

    @GetMapping("/producto/registro")
    public String registrarProducto(Model model) {
        model.addAttribute("producto", new Producto());
        return "templates.producto.registro";
    }

    @PostMapping("/producto/guardar")
    public String guardarProducto(Producto producto) {
        productoService.guardar(producto);
        return "redirect:/producto/listado";
    }

    @GetMapping("/producto/editar/{id}")
    public String editarProducto(@PathVariable("id") Long id, Model model) {
        Producto producto = productoService.encontrarProducto(id);
        model.addAttribute("producto", producto);
        return "templates.producto.modifica";
    }

    @GetMapping("/producto/eliminar/{id}")
    public String eliminarProducto(@PathVariable("id") Long id) {
        Producto producto = productoService.encontrarProducto(id);
        if (producto != null) {
            productoService.eliminar(producto);
        }
        return "redirect:/producto/listado";
    }
}