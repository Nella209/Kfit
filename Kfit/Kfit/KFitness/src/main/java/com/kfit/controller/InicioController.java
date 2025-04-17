package com.kfit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/")
public class InicioController {

    @GetMapping
    public String inicio(Model model) {
        model.addAttribute("mensaje", "Bienvenido a KFit");
        return "index"; // El archivo principal HTML que quieres mostrar (index.html)
    }

    @GetMapping("/nutricion-saludable")
    public String nutricionSaludable(Model model) {
        model.addAttribute("titulo", "Nutrición Saludable");
        return "nutricion-saludable"; // Crea un archivo llamado nutrucion-saludable.html en templates
    }

    @GetMapping("/ejercicio-efectivo")
    public String ejercicioEfectivo(Model model) {
        model.addAttribute("titulo", "Ejercicio Efectivo");
        return "ejercicio-efectivo"; // Crea un archivo llamado ejercicio-efectivo.html en templates
    }

    @GetMapping("/blog")
    public String blog(Model model) {
        model.addAttribute("titulo", "Blog");
        return "blog"; // Crea un archivo llamado blog.html en templates
    }

    @GetMapping("/contacto")
    public String contacto(Model model) {
        model.addAttribute("titulo", "Contacto");
        return "contacto"; // Crea un archivo llamado contacto.html en templates
    }
}