package com.greenlemon.portalchamadoweb.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;

import com.greenlemon.portalchamadoweb.model.State;

@Component
public class StateDao {

	private final Session session;
	
	public StateDao(Session session){
		this.session = session;
	}
	
	public State create(State State) {
		this.session.save(State);
		return State;
	}

	public void delete(State State) {
		this.session.delete(State);
	}

	public State find(Long id) {
		return (State) this.session.load(State.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<State> findAll() {
		return (List<State>) this.session.createCriteria(State.class).list();
	}

	@SuppressWarnings("unchecked")
	public List<State> findById(Long id) {
		return (List<State>) this.session.load(State.class, id);
	}

	public void update(State State) {
		this.session.update(State);
	}
}
