package com.greenlemon.portalchamadoweb.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "classification")
public class Classification implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7251717204816118301L;
	@Id
	@GeneratedValue
	private Long id;
	private Integer note;
	private String observation;
	
	@ManyToOne
	@JoinColumn(name="service_provider_id")
	private ServiceProvider serviceProvider;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public ServiceProvider getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(ServiceProvider serviceProvider) {
		this.serviceProvider = serviceProvider;
	}
}
