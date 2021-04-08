package com.example.demo.controller;

import com.example.demo.dao.ProductoDao;
import com.example.demo.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductosController {

    @Autowired
    ProductoDao producto_dao;

    @GetMapping("/agregar-producto")
    public String agregarProducto() {

        return "";
    }

    @PostMapping("/agregar-producto")
    public String agregarProducto(@ModelAttribute Producto producto) {

        return "";
    }

    @GetMapping("/listar-productos")
    public String listarProductos(Model model) {
        model.addAttribute("productos", producto_dao.getAll());

        return "";
    }

}
