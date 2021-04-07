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

/* 
*  Java Hibernate - Model Class - NotasDeVenta.UnidadMedida
*  
*/ 
@Entity
@Table(name = "UnidadMedida")
public @Data class UnidadMedida {

    // fields
	@Id
 	@GeneratedValue
	@Column(name = "id")
    private int m_id;

	@Column(name = "medida")
    private String m_medida;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUnidadMedida")
    private List<Item> item;
    
}
