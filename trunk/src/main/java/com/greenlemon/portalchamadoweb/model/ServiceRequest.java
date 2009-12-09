package com.greenlemon.portalchamadoweb.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "service_request")
public class ServiceRequest implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7938805768144640402L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String description;
	
	@Column(name="request_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date requestDate;
	
	@ManyToOne
	@JoinColumn(name="service_provider_id")
	private ServiceProvider serviceProvider;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public ServiceProvider getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(ServiceProvider serviceProvider) {
		this.serviceProvider = serviceProvider;
	}
}
