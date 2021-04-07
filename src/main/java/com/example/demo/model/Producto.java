package com.example.demo.model;

import com.example.demo.model.Item;
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
import javax.persistence.FetchType;

/* 
*  Java Hibernate - Model Class - NotasDeVenta.Producto
*  
*/
@Entity
@Table(name = "Producto")
public @Data class Producto {

    // fields
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int m_id;

    @Column(name = "nombre")
    private String m_nombre;

    @Column(name = "imagen")
    private byte[] m_imagen;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProducto")
    private List<Item> item;

}
