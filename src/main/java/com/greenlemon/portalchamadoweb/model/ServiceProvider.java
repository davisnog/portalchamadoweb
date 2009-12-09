package com.greenlemon.portalchamadoweb.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "service_provider")
public class ServiceProvider implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 4996739961071895820L;

	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="person_id")
	private Person person;
	
	@OneToOne(mappedBy="serviceProvider")
	private Corporation corporation;
	
	@OneToOne(mappedBy="serviceProvider")
	private Individual individual;
	
	@OneToMany(mappedBy = "serviceProvider", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Classification> classifications;

	@OneToMany(mappedBy = "serviceProvider", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ServiceRequest> servicesRequest;
	
	@OneToMany(mappedBy = "serviceProvider", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Service> services = new ArrayList<Service>();
	
	@Column(name = "fantasy_name", nullable = false)
	private String fantasyName;

	@Lob
	private Byte[] logo;
	
	public Person getPerson(){
		return person;
	}
	
	public void setPerson(Person person){
		this.person = person;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFantasyName() {
		return fantasyName;
	}

	public void setFantasyName(String fantasyName) {
		this.fantasyName = fantasyName;
	}

	public Byte[] getLogo() {
		return logo;
	}

	public void setLogo(Byte[] logo) {
		this.logo = logo;
	}

	public List<Classification> getClassifications() {
		if(classifications.isEmpty()){
			return new ArrayList<Classification>();
		}
		return classifications;
	}

	public void setClassifications(List<Classification> classifications) {
		this.classifications = classifications;
	}

	public List<ServiceRequest> getServicesRequest() {
		if(servicesRequest.isEmpty()){
			return new ArrayList<ServiceRequest>();
		}
		return servicesRequest;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public void setServicesRequest(List<ServiceRequest> servicesRequest) {
		this.servicesRequest = servicesRequest;
	}

	public Corporation getCorporation() {
		return corporation;
	}

	public void setCorporation(Corporation corporation) {
		this.corporation = corporation;
	}

	public Individual getIndividual() {
		return individual;
	}

	public void setIndividual(Individual individual) {
		this.individual = individual;
	}
}
