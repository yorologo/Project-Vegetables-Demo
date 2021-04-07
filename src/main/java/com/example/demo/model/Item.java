package com.example.demo.model;

import com.example.demo.model.Compra;
import com.example.demo.model.Producto;
import com.example.demo.model.UnidadMedida;
import java.sql.*;
import java.util.List;
//import java.util.*;
import java.text.*;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/* 
*  Java Hibernate - Model Class - NotasDeVenta.Item
*  
*/
@Entity
@Table(name = "Item")
public @Data class Item {

    // fields
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int m_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCompra")
    private Compra compra;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProducto")
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUnidadMedida")
    private UnidadMedida unidadmedida;

    @Column(name = "precioUnitario")
    private double m_precioUnitario;

    @Column(name = "cantidad")
    private int m_cantidad;

    @Column(name = "subtotal")
    private double m_subtotal;

}
