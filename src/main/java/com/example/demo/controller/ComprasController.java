package com.example.demo.controller;

import com.example.demo.dao.CompraDao;
import com.example.demo.dao.ProductoDao;
import com.example.demo.dao.UnidadMedidaDao;
import com.example.demo.model.Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ComprasController {

    @Autowired
    private CompraDao compra_dao;
    @Autowired
    private ProductoDao producto_dao;
    @Autowired
    private UnidadMedidaDao udm_dao;

    @GetMapping("/realizar-compra")
    public String realizarCompra(Model model) {
        model.addAttribute("productos", producto_dao.getAll());
        model.addAttribute("udms", udm_dao.getAll());

        return "Get realizar-compra";
    }

    @PostMapping("/realizar-compra")
    public String realizarCompra(@ModelAttribute Compra compra) {
        compra_dao.add(compra);
        return "POST realizar-compra";
    }

    @GetMapping("/listar-compras")
    public String listarCompras(Model model) {
        model.addAttribute("compras", compra_dao.getAll());

        return "listar compra";
    }

    @GetMapping("/detalle-compra/{id}")
    public String detalleCompra(@PathVariable int id,  Model model) {
        model.addAttribute("compra", compra_dao.getByID(id));

        return "detalle-compra";
    }
}
