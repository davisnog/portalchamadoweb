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
@Table(name = "individual")
public class Individual implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1083903813540787263L;

	@Id
	@GeneratedValue(generator = "foreign")
	@GenericGenerator(name = "foreign", strategy = "foreign", parameters = { @Parameter(name = "property", value = "serviceProvider") })
	@Column(name = "service_provider_id")
	private Long Id;
	
	@OneToOne(optional = false, cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private ServiceProvider serviceProvider;
	
	public Long getId() {
		return Id;
	}

	public void setId(Long serviceProviderId) {
		this.Id = serviceProviderId;
	}

	public ServiceProvider getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(ServiceProvider serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

	private Long cpf;
	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
}
