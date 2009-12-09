package com.greenlemon.portalchamadoweb.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;

import com.greenlemon.portalchamadoweb.model.Person;
import com.greenlemon.portalchamadoweb.model.Service;
import com.greenlemon.portalchamadoweb.model.ServiceProvider;
import com.greenlemon.portalchamadoweb.model.ServiceRequest;

@Component
public class ServiceRequestDao {

	private final Session session;
	
	public ServiceRequestDao(Session session){
		this.session = session;
	}
	
	public void create(Service service, ServiceRequest serviceRequest){
		
		serviceRequest.setServiceProvider(service.getServiceProvider());
		serviceRequest.setRequestDate(new Date());
		
		this.session.save(serviceRequest);
	}
	
	public void update(ServiceRequest serviceRequest){
		this.session.update(serviceRequest);
	}
	
	@SuppressWarnings("unchecked")
	public List<ServiceRequest> findAll(){
		return this.session.createCriteria(ServiceRequest.class).list();
	}
	
	public ServiceRequest find(long id){
		return (ServiceRequest)this.session.load(ServiceRequest.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<ServiceProvider> findAllPeople(){
		return this.session.createCriteria(ServiceProvider.class).list();
	}
	
	public Person getPerson(ServiceProvider serviceProvider){
		String hql = " from Person p inner join fetch p.serviceProvider s where s.id = :id";
		
		Query query = this.session.createQuery(hql);
		query.setParameter("id", serviceProvider.getId());
		
		return (Person)query.uniqueResult();
	}
}
