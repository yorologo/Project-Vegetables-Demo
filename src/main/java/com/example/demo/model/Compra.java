package com.example.demo.model; 

import com.example.demo.model.Item;
import com.example.demo.model.Comprador;
import com.example.demo.model.Vendedor;
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
*  Java Hibernate - Model Class - NotasDeVenta.Compra
*  
*/ 
@Entity
@Table(name = "Compra")
public @Data class Compra {

    // fields
	@Id
 	@GeneratedValue
	@Column(name = "id")
    private int m_id;

    @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "idComprador")
    private Comprador comprador;

    @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "idVendedor")
    private Vendedor vendedor;

	@Column(name = "fecha")
    private java.sql.Timestamp m_fecha;

	@Column(name = "notas")
    private String m_notas;

	@Column(name = "total")
    private double m_total;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCompra")
    private List<Item> item;
    
}
