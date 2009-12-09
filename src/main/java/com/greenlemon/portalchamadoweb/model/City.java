package com.greenlemon.portalchamadoweb.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6132257640831248984L;

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne 
	@JoinColumn(name="state_id", nullable = false)
	private State state;
	
	@OneToMany(mappedBy="city", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Address> address = new ArrayList<Address>();
	
	private String name;
	
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

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}
}
