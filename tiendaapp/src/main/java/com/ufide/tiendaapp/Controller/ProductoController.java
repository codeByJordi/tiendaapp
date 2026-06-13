package com.ufide.tiendaapp.Controller;

import com.ufide.tiendaapp.Entity.Producto;
import com.ufide.tiendaapp.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping //tal cual el /productos            //required en false porque no hay nada en un inicio
    public String listar(Model model, @RequestParam(required = false) String search, @RequestParam(required = false) String Categoria) {
        model.addAttribute("productos", productoService.findAll());
        if (search != null && !search.isBlank()) {
            model.addAttribute("productos", productoService.findByName(search));
            model.addAttribute("filtro", "Buscando: " + search); //para mostrar en pantalla lo que se busca
        }

        if (Categoria != null && !Categoria.isBlank()) {
            model.addAttribute("productos", productoService.findByCategoria(Categoria));
            model.addAttribute("filtro", "Buscando: " + Categoria); //para mostrar en pantalla lo que se busca
        }
        else { //si no se busca o esta por categoria, mostrar todos.
            model.addAttribute("productos", productoService.findAll());
        }
        return "productos";
    }

    @GetMapping("/{id}") //extraemos el id del producto, esto en el detalle de producto
    public String detalle(@PathVariable Long id, Model model) {
        model.addAttribute("producto", productoService.findById(id).orElse(null)); //si no lo encuentra o muestra, poner null
        return "productos";
    }

    @GetMapping("/baja-stock")
    public String BajaStock(Model model) {
        model.addAttribute("productos", productoService.findByStockLessThan());
        model.addAttribute("filtro", "Producots con bajo stock");
        return "productos";
    }
}
