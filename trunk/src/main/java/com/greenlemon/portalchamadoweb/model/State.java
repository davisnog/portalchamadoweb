package com.greenlemon.portalchamadoweb.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "state")
public class State implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6502836259711473197L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	private String uf;
	
	@OneToMany(mappedBy="state", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<City> cities = new ArrayList<City>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	public List<City> getCities() {
		return cities;
	}
	
	public void setCities(List<City> cities) {
		this.cities = cities;
	}
}
