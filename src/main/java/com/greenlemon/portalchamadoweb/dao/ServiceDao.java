package com.greenlemon.portalchamadoweb.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;

import com.greenlemon.portalchamadoweb.model.Person;
import com.greenlemon.portalchamadoweb.model.Service;

@Component
public class ServiceDao {

	private final Session session;
	
	public ServiceDao(Session session){
		this.session = session;
	}
	
	public void create(Service service) {
		service.setActive(true);
		this.session.save(service);
	}

	public void delete(Service service) {
		this.session.delete(service);
	}

	public Service find(Long id) {
		return (Service) this.session.load(Service.class, id);
	}

	public void update(Service service) {
		this.session.update(service);
	}
	
	@SuppressWarnings("unchecked")
	public List<Service> findById(Person person){
		
		String hql = "from Service s where s.serviceProvider.person.id = :id";
		
		Query query = this.session.createQuery(hql);
		query.setParameter("id", person.getId());
		
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List findByParams(Service service){
		
		if(service != null && !service.getDescription().equals("")){
			
			String hql = "from Service s where lower(s.description) like '%" + service.getDescription().toLowerCase() + "%'";
			Query query = this.session.createQuery(hql);
			
			return query.list();
			
		}else {
			return this.session.createCriteria(Service.class).list();
		}
	}
	
	public List<Service> findAll(Person person){
		if(person != null){
			return this.findById(person);
		}
		return this.session.createCriteria(Service.class).list();
	}
}
