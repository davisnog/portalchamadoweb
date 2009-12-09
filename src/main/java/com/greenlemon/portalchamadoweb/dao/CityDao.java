package com.greenlemon.portalchamadoweb.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;

import com.greenlemon.portalchamadoweb.model.City;
import com.greenlemon.portalchamadoweb.model.State;

@Component
public class CityDao {

	private final Session session;
	private StateDao stateDao;

	public CityDao(Session session, StateDao stateDao) {
		this.session = session;
		this.stateDao = stateDao;
	}

	public void create(City city) {
		this.session.save(city);
	}

	public void delete(City city) {
		this.session.delete(city);
	}

	public City find(Long id) {
		return (City) this.session.load(City.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<City> findAll() {
		return (List<City>) this.session.createCriteria(City.class).list();
	}

	public void update(City city) {
		this.session.update(city);
	}
	
	public List<State> getStates(){
		return this.stateDao.findAll();
	}
}
