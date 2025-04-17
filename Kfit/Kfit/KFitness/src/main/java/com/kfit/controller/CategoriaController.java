package com.kfit.controller;

import com.kfit.domain.Categoria;
import com.kfit.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/categoria/listado")
    public String listarCategorias(Model model) {
        model.addAttribute("categorias", categoriaService.listarCategorias());
        return "templates.categoria.listados"; // Ruta hacia tu archivo listado.html
    }

    @GetMapping("/categoria/registro")
    public String registrarCategoria(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "templates.categoria.registro"; // Ruta hacia tu archivo registro.html
    }

    @PostMapping("/categoria/guardar")
    public String guardarCategoria(Categoria categoria) {
        categoriaService.guardar(categoria);
        return "redirect:/categoria/listado";
    }

    @GetMapping("/categoria/editar/{id}")
    public String editarCategoria(@PathVariable("id") Long id, Model model) {
        Categoria categoria = categoriaService.encontrarCategoria(id);
        model.addAttribute("categoria", categoria);
        return "templates.categoria.modifica"; // Ruta hacia tu archivo modifica.html
    }

    @GetMapping("/categoria/eliminar/{id}")
    public String eliminarCategoria(@PathVariable("id") Long id) {
        Categoria categoria = categoriaService.encontrarCategoria(id);
        if (categoria != null) {
            categoriaService.eliminar(categoria);
        }
        return "redirect:/categoria/listado";
    }
}