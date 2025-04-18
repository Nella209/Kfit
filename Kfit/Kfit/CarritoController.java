/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kfit.controller;

import com.kfit.domain.Plan;
import com.kfit.domain.Producto;
import com.kfit.domain.Plan;
import com.kfit.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.kfit.service.ProductoService;

/**
 *
 * @author Karol
 */
@Controller
public class CarritoController {

    @Autowired
    private PlanService itemService;
    @Autowired
    private ProductoService productoService;

    @GetMapping("/")
    private String listado(Model model) {
        var productos = productoService.getProductos(false);
        model.addAttribute("productos", productos);
        return "/index";
    }

    //Para ver el carrito
    @GetMapping("/carrito/listado")
    public String inicio(Model model) {
        var plan = itemService.gets();
        model.addAttribute("Plans", plan);
        var carritoTotalVenta = 0;
        for (Plan i : plan) {
            carritoTotalVenta += (i.getCantidad() * i.getPrecio());
        }
        model.addAttribute("carritoTotal",
                carritoTotalVenta);
        return "/carrito/listado";
    }

    //Para Agregar un producto al carrito
    public ModelAndView agregarItem(Model model, Plan plan) {
    Plan plan2 = itemService.get(plan);
    if (plan2 == null) {
        Producto producto = productoService.encontrarProducto(plan.getProducto().getIdProducto());
        plan2 = new Plan(producto);
    }
    itemService.save(plan2);
        var lista = itemService.gets();
        var totalCarritos = 0;
        var carritoTotalVenta = 0;
        for (Plan i : lista) {
            totalCarritos += i.getCantidad();
            carritoTotalVenta += (i.getCantidad() * i.getPrecio());
        }
        model.addAttribute("listaItems", lista);
        model.addAttribute("listaTotal", totalCarritos);
        model.addAttribute("carritoTotal", carritoTotalVenta);
        return new ModelAndView("/carrito/fragmentos :: verCarrito");
    }

    //Para mofificar un producto del carrito
    @GetMapping("/carrito/modificar/{idProducto}")
    public String modificarPlan(Plan plan, Model model) {
        plan = itemService.get(plan);
        model.addAttribute("item", plan);
        return "/carrito/modificar";
    }

    //Para eliminar un elemento del carrito
    @GetMapping("/carrito/eliminar/{idProducto}")
    public String eliminarPlan(Plan plan) {
        itemService.delete(plan);
        return "redirect:/carrito/listado";
    }

    //Para actualizar un producto del carrito (cantidad)
    @PostMapping("/carrito/guardar")
    public String guardarPlan(Plan plan) {
        itemService.actualiza(plan);
        return "redirect:/carrito/listado";
    }

    //Para facturar los productos del carrito... no implementado...
    @GetMapping("/facturar/carrito")
    public String facturarCarrito() {
        itemService.facturar();
        return "redirect:/";
    }
}
