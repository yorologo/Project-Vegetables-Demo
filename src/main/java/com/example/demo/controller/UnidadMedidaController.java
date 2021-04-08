package com.example.demo.controller;

import com.example.demo.dao.UnidadMedidaDao;
import com.example.demo.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UnidadMedidaController {

    @Autowired
    UnidadMedidaDao udm_dao;

    @GetMapping("/agregar-udm")
    public String agregarUDM() {

        return "";
    }

    @PostMapping("/agregar-udm")
    public String agregarUDM(@ModelAttribute Producto producto) {

        return "";
    }

    @GetMapping("/listar-udms")
    public String listarUDMS(Model model) {
        model.addAttribute("udms", udm_dao.getAll());

        return "";
    }
}
