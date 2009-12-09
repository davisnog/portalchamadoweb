package com.greenlemon.portalchamadoweb.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "corporation")
public class Corporation implements Serializable {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -1504360101224083166L;

	@Id
	@GeneratedValue(generator = "foreign")
	@GenericGenerator(name = "foreign", strategy = "foreign", parameters = { @Parameter(name = "property", value = "serviceProvider") })
	@Column(name = "service_provider_id")
	private Long Id;
	
	@OneToOne(optional = false, cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private ServiceProvider serviceProvider;

	@Column(name = "corporation_name")
	private String corporationName;
	private Long cnpj;

	@Column(name = "municipal_registration")
	private String municipalRegistration;

	@Column(name = "state_registration")
	private String stateRegistration;

	public ServiceProvider getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(ServiceProvider serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

	public String getCorporationName() {
		return corporationName;
	}

	public void setCorporationName(String corporationName) {
		this.corporationName = corporationName;
	}

	public Long getCnpj() {
		return cnpj;
	}

	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}

	public String getMunicipalRegistration() {
		return municipalRegistration;
	}

	public void setMunicipalRegistration(String municipalRegistration) {
		this.municipalRegistration = municipalRegistration;
	}

	public String getStateRegistration() {
		return stateRegistration;
	}

	public void setStateRegistration(String stateRegistration) {
		this.stateRegistration = stateRegistration;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long serviceProviderId) {
		this.Id = serviceProviderId;
	}
}
