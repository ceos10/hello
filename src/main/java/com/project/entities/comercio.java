package com.project.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Comercio")
public class comercio {
	@Id
	@Column(name="Codigo")
	 private Integer id;
	@Column(name="Nombre")
	 private String nombre;
	@Column(name= "Nombre_de_via")
	 private String via;
	@Column(name="Numero")
	 private Integer numero;
	@Column(name="Giro")
	 private String giro;
	@Column(name="Geo_x")
	 private double geo_x;
	@Column(name="Geo_y")
	 private double geo_y;
	@Column(name="Interior")
	private String interior;
	@Column(name="Letra")
	private String letra;
	@Column(name="Nombre_comercial")
	private String nombre_comercial;
	
	
	
	
	
	public comercio() {
		super();
	}
	public comercio(Integer id, String nombre, String via, Integer numero, String giro, double geo_x, double geo_y,
			String interior, String letra, String nombre_comercial) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.via = via;
		this.numero = numero;
		this.giro = giro;
		this.geo_x = geo_x;
		this.geo_y = geo_y;
		this.interior = interior;
		this.letra = letra;
		this.nombre_comercial = nombre_comercial;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getGiro() {
		return giro;
	}
	public void setGiro(String giro) {
		this.giro = giro;
	}
	public double getGeo_x() {
		return geo_x;
	}
	public void setGeo_x(double geo_x) {
		this.geo_x = geo_x;
	}
	public double getGeo_y() {
		return geo_y;
	}
	public void setGeo_y(double geo_y) {
		this.geo_y = geo_y;
	}
}
