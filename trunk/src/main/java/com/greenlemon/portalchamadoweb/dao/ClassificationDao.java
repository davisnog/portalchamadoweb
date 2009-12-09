package com.greenlemon.portalchamadoweb.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;

import com.greenlemon.portalchamadoweb.model.Classification;
import com.greenlemon.portalchamadoweb.model.ServiceProvider;

@Component
public class ClassificationDao {

	private final Session session;
	private PersonDao personDao;

	public ClassificationDao(Session session, PersonDao personDao) {
		this.session = session;
		this.personDao = personDao;
	}

	public void create(Classification classification) {
		this.session.save(classification);
	}

	public void delete(Classification classification) {
		this.session.delete(classification);
	}

	public Classification findById(Long id) {
		return (Classification) this.session.load(Classification.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Classification> findAll() {
		return (List<Classification>) this.session.createCriteria(
				Classification.class).list();
	}

	public void update(Classification classification) {
		this.session.update(classification);
	}

	public List<ServiceProvider> getServicesProvider() {
		return this.personDao.getServicesProvider();
	}
}
