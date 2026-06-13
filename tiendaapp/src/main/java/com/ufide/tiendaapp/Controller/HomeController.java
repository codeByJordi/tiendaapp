package com.ufide.tiendaapp.Controller;

import com.ufide.tiendaapp.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class HomeController {
    @Autowired
    private ProductoService productoService;

    @GetMapping("/")
    public String index(Model model, @RequestParam(defaultValue = "Estudiante") String nombre) {
        model.addAttribute("nombre", nombre);
        model.addAttribute("totalProductos", productoService.findAll());
        model.addAttribute("bajoStock", productoService.findByStockLessThan().size());
        return "home";
    }
}
