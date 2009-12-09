package com.greenlemon.portalchamadoweb.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;

import com.greenlemon.portalchamadoweb.model.Address;
import com.greenlemon.portalchamadoweb.model.City;
import com.greenlemon.portalchamadoweb.model.Person;
import com.greenlemon.portalchamadoweb.model.Role;
import com.greenlemon.portalchamadoweb.model.ServiceProvider;

@Component
public class PersonDao {

	private final Session session;
	private final CityDao cityDao;
	
	public PersonDao(Session session, CityDao cityDao){
		this.session = session;
		this.cityDao = cityDao;
	}
	
	public void create(Person person, Address address){
		this.session.save(address);
		person.setRole(Role.VISITOR);
		person.setActive(true);
		person.setAddress(address);
		this.session.save(person);
	}
	
	public void update(Person person, Address address){
		this.session.update(address);
		this.session.update(person);
	}
	
	public void delete(Person person, Address address){
		this.session.delete(person);
		this.session.delete(address);
	}
	
	public Person find(Long id){
		return (Person)this.session.load(Person.class, id);
	}
	
	public Address getAddress(Long id){
		return (Address)this.session.load(Address.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Person> findAll(){
		return (List<Person>)this.session.createCriteria(Person.class).list();
	}
	
	public List<City> getCities(){
		return this.cityDao.findAll();
	}
	
	@SuppressWarnings("unchecked")
	public List<ServiceProvider> getServicesProvider(){
		return (List<ServiceProvider>)this.session.createCriteria(ServiceProvider.class).list();
	}
}
