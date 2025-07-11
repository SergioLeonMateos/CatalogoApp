package com.openweniars.webapp.controladores;

import com.openweniars.webapp.repositorios.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ProductoController {

    @Autowired
    private ProductoRepository repository;

    @GetMapping({"/","/list", "/products"})
    public String todosLosProductos(Model model) {

    model.addAttribute("productos", repository.findAll());
    return "index";
    }


    @ModelAttribute("categorias")
    public List<String> categorias(){
        return repository.listarCategorias();
    }


    @GetMapping("/categoria/{cat}")
    public String productosPorCategoria(@PathVariable("cat") String categoria, Model model){
        model.addAttribute("productos", repository.findByCategoriaIgnoreCase(categoria));
                return "index";
    }
}
